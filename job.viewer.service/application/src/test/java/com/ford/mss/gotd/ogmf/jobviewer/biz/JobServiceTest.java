package com.ford.mss.gotd.ogmf.jobviewer.biz;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.ford.mss.gotd.ogmf.jobviewer.controller.Job;
import com.ford.mss.gotd.ogmf.jobviewer.job.JobDE;
import com.ford.mss.gotd.ogmf.jobviewer.job.JobRepository;

@RunWith(MockitoJUnitRunner.class)
public class JobServiceTest {

	@InjectMocks
	JobService jobService;
	
	@Mock
	JobRepository jobRepository;
	
	@Test
	public void givenNoJobsWhenRequestedForAllJobsThenReturnEmptyJobs() {
		when(jobRepository.findAll()).thenReturn(mockDBJobs());
		List<Job> jobs = jobService.getAllJobs();
		assertNotNull(jobs);
		assertTrue(jobs.size() == 0);
	}

	private List<JobDE> mockDBJobs() {
		return Collections.emptyList();
	}

}
