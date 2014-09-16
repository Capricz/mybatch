package com.zliang.mybatch;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
		"classpath:application.xml",
		"classpath:batch.xml",
		"classpath:test-context.xml"})
public class CustomerCreditCardTest {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerCreditCardTest.class);

	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;

	@Test
	public void testJob() throws Exception {
		log.trace("in {} method","testJob");
//		simpleJdbcTemplate.update("delete from CUSTOMER");
//		for (int i = 1; i <= 10; i++) {
//			simpleJdbcTemplate.update(
//					"insert into CUSTOMER values (?, 0, ?, 100000)", i,
//					"customer" + i);
//		}
//		JobExecution jobExecution = jobLauncherTestUtils.launchJob()
//				.getStatus();
//		Assert.assertEquals("COMPLETED", jobExecution.getExitStatus());
		
		JobExecution jobExecution = jobLauncherTestUtils.launchJob();
		assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
	}
	
	@Test
	public void testStep() throws Exception{
		log.trace("in {} method","testSetp");
		JobExecution stepExecution = jobLauncherTestUtils.launchStep("step_hello");
		assertEquals(BatchStatus.COMPLETED,stepExecution.getStatus());
	}
}
