package com.ford.mss.gotd.ogmf.jobviewer;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ford.mss.gotd.ogmf.jobviewer.biz.JobService;
import com.ford.mss.gotd.ogmf.jobviewer.controller.Job;
import com.ford.mss.gotd.ogmf.jobviewer.controller.JobController;
import com.ford.mss.gotd.ogmf.jobviewer.controller.JobResponse;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class JobControllerTest {

	@InjectMocks
	private JobController jobController;
	
	@Mock
	private JobService jobService;

	@Test
	public void testGetAllJobs() throws Exception {
		when(jobService.getAllJobs()).thenReturn(createExpectedJobs());
		ResponseEntity<JobResponse> response = jobController.getAllJobs();
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody()).isEqualTo(getExpectedJob());
	}
	
	private List<Job> createExpectedJobs() {
		return Collections.emptyList();
	}

	private JobResponse getExpectedJob() {
		return JobResponse.builder().jobs(Collections.emptyList()).build();
	}

}