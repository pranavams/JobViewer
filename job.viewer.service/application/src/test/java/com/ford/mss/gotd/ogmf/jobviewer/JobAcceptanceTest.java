
package com.ford.mss.gotd.ogmf.jobviewer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ford.cloudnative.base.test.acceptance.AcceptanceTestUtil;
import com.ford.mss.gotd.ogmf.jobviewer.controller.JobResponse;

public class JobAcceptanceTest {

	private RestTemplate restTemplate;

	@Before
	public void setup() {
		restTemplate = AcceptanceTestUtil.restTemplateBuilder().disableErrorHandler().build();
	}

	@Test
	public void testGetAllJobsEndpoint() throws Exception {
		ResponseEntity<JobResponse> response = restTemplate.getForEntity("/api/v1/listAll/", JobResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void testSaveJobEndPoint() throws Exception {
		ResponseEntity<JobResponse> response = restTemplate.getForEntity("/api/v1/save/", JobResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
}
