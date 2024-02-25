package com.index.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

import com.index.repository.ArticleRepo;
import com.index.utility.NewsApiItemReader;
import com.index.utility.NewsArticle;
import com.index.utility.NewsProcessor;

@Configuration
@EnableBatchProcessing
@EnableScheduling
public class BatchConfiguration {
	
	@Autowired
	private ArticleRepo articleRepo;
	
	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private PlatformTransactionManager platformTransactionManager;

    @Bean
    @Scope("prototype")
    NewsApiItemReader itemReader() {
		return new NewsApiItemReader();
	}

    @Bean
    NewsProcessor processor() {
		return new NewsProcessor();
	}

    @Bean
    RepositoryItemWriter<NewsArticle> writer() {
		RepositoryItemWriter<NewsArticle> writer = new RepositoryItemWriter<NewsArticle>();
		writer.setRepository(articleRepo);
		writer.setMethodName("save");
		return writer;
	}

    @Bean
    Step step() {
		return new StepBuilder("api-call-step", jobRepository)
				.<NewsArticle, NewsArticle>chunk(1, platformTransactionManager)
				.reader(itemReader())
				.processor(processor())
				.writer(writer())
				.taskExecutor(taskExecutor())
				.build();
	}

    @Bean
    Job job() {
		return new JobBuilder("import-news-job", jobRepository)
				.start(step())
				.build();
	}

    @Bean
    TaskExecutor taskExecutor() {
		SimpleAsyncTaskExecutor sete = new SimpleAsyncTaskExecutor();
		sete.setConcurrencyLimit(10);
		return sete;
	}
	
}
