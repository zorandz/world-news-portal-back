package com.index.utility;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ArticleFetchingScheduler {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job; 
	
	
	//@Scheduled(cron = "0 */60 7-21 * * *")
	//public void launchJob() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
	//    JobParameters jobParameters = new JobParametersBuilder()
	//                .addLong("time", System.currentTimeMillis())
	//                .toJobParameters();
	//    jobLauncher.run(job, jobParameters);
	//}
	
	@Scheduled(cron = "0 */90 0-23 * * *")
	public void launchJob() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
	    JobParameters jobParameters = new JobParametersBuilder()
	                .addLong("time", System.currentTimeMillis())
	                .toJobParameters();
	    jobLauncher.run(job, jobParameters);
	}
	
}
