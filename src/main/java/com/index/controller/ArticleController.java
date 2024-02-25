package com.index.controller;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.index.service.ArticlesService;
import com.index.utility.NewsArticle;

@RestController
public class ArticleController {
	
	@Autowired
	private JobLauncher jobLauncher;
	
	private ArticlesService articleService;
	
	public ArticleController(ArticlesService as) {
		this.articleService = as;
	}
	
	@Autowired	
	private Job job;
	
	@PostMapping("/manual-fetch")
	public String fetchArticles() {
		JobParameters jobParameters = new JobParametersBuilder()
				.addLong("startAt", System.currentTimeMillis())
				.toJobParameters();
		
		String responseString = "Batch successfully executed";
		
		try {
			jobLauncher.run(job, jobParameters);
		} catch (JobExecutionAlreadyRunningException 
				| JobRestartException 
				| JobInstanceAlreadyCompleteException 
				| JobParametersInvalidException e){
			e.printStackTrace();
			responseString = e.getMessage();
		}
		
		return responseString;
	}
	
	@GetMapping("/main-fetch")
	public List<NewsArticle> getArticles() {
		
		return articleService.getArticles();
	}
	
	
	

}
