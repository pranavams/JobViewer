package com.ford.mss.gotd.ogmf.jobviewer.job;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ford.mss.gotd.ogmf.jobviewer.controller.Job;

public class JobDETest {

	@Test
	public void givenDEWhenTransformedShouldGetJobs() {
		JobDE de = new JobDE();
		List<JobDE> jobs = new ArrayList<>();
		jobs.add(de);
		List<Job> jobBos = JobDE.transform(jobs);
		assertNotNull(jobBos);
		assertTrue(jobBos.size() == 1);
	}

}
