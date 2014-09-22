package com.zliang.mybatch.simplestep;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerLauncher {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/META-INF/transferCustomerJob.xml");
//		Job job = (Job) ctx.getBean("transferCustomerJob");
//		JobLauncher jobLauncher = null;
//		System.out.println(job);
		SimpleJobLauncher jobLauncher = (SimpleJobLauncher) ctx.getBean("jobLauncher");
		
		Job job = (Job) ctx.getBean("transferCustomerJob");
		try {
			JobExecution jobExecution = jobLauncher.run(job, new JobParameters());
//			Date createTime = jobExecution.getCreateTime();
//			System.out.println("createTime :"+createTime);
//			Date endTime = jobExecution.getEndTime();
//			System.out.println("endTime : "+endTime);
//			ExecutionContext executionContext = jobExecution.getExecutionContext();
//			System.out.println("executionContext : "+executionContext);
//			ExitStatus exitStatus = jobExecution.getExitStatus();
//			System.out.println("exitStatus.getExitCode() : "+exitStatus.getExitCode());
//			List<Throwable> failureExceptions = jobExecution.getFailureExceptions();
//			System.out.println("failureExceptions size : "+failureExceptions.size());
//			Long id = jobExecution.getId();
//			System.out.println("id : "+id);
//			Long jobId = jobExecution.getJobId();
//			System.out.println("jobId : "+jobId);
//			JobInstance jobInstance = jobExecution.getJobInstance();
//			if(jobInstance!=null){
//				Long jobInstanceId = jobInstance.getId();
//				System.out.println("jobInstanceId : "+jobInstanceId);
//				String jobName = jobInstance.getJobName();
//				System.out.println("jobInstanceJobName : "+jobName);
//				Integer jobInstanceVersion = jobInstance.getVersion();
//				System.out.println("jobInstanceVersion : "+jobInstanceVersion);
//			}
//			JobParameters jobParameters = jobExecution.getJobParameters();
//			System.out.println("jobParameters : "+jobParameters);
//			Date lastUpdated = jobExecution.getLastUpdated();
//			System.out.println("lastUpdated : "+lastUpdated);
//			Date startTime = jobExecution.getStartTime();
//			System.out.println("startTime : "+startTime);
//			BatchStatus status = jobExecution.getStatus();
//			System.out.println("(BatchStatus)status.name() : "+status.name());
//			Collection<StepExecution> stepExecutions = jobExecution.getStepExecutions();
//			System.out.println("stepExecutions size : "+stepExecutions.size());
//			Integer version = jobExecution.getVersion();
//			System.out.println("jobExecution.version : "+version);
			System.out.println("Job finished...");
		} catch (JobExecutionAlreadyRunningException e) {
			e.printStackTrace();
		} catch (JobRestartException e) {
			e.printStackTrace();
		} catch (JobInstanceAlreadyCompleteException e) {
			e.printStackTrace();
		} catch (JobParametersInvalidException e) {
			e.printStackTrace();
		}
	}
}
