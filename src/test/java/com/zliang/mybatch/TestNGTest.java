package com.zliang.mybatch;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

@ContextConfiguration(locations = {
    "classpath:application.xml",
    "classpath:batch.xml",
    "classpath:test-context.xml"})
public class TestNGTest extends AbstractTestNGSpringContextTests {
 
    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;
 
 
    @Test
    public void launchJob() throws Exception {
 
        JobExecution jobExecution = jobLauncherTestUtils.launchJob();
        Assert.assertEquals(jobExecution.getStatus(), BatchStatus.COMPLETED);
 
    }
}