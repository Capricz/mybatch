package com.zliang.mybatch;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application.xml","classpath:batch.xml","classpath:test-context.xml"})
public class MyBatchTest {

	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;

	private SimpleJdbcTemplate simpleJdbcTemplate;

	@Test
	public void testJob() throws Exception {
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
		assertEquals("COMPLETED", jobExecution.getExitStatus().getExitCode());
		
	}
}
