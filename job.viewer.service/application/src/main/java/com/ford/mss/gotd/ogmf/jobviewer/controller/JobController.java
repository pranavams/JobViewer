package com.ford.mss.gotd.ogmf.jobviewer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ford.mss.gotd.ogmf.jobviewer.biz.JobService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api/v1/")
public class JobController {

	private JobService jobService;
	
	@Autowired
	public JobController(JobService jobService) {
		this.jobService = jobService;
	}
	
	@ApiOperation(value = "Get All Jobs", notes = "Returns all Jobs")
	@GetMapping
	@RequestMapping("/listAll")
	public ResponseEntity<JobResponse> getAllJobs() {
		return ResponseEntity.ok(JobResponse.builder().jobs(this.jobService.getAllJobs()).build());
	}
	
	@ApiOperation(value = "Save A Job", notes = "Persist a Job")
	@PostMapping
	@RequestMapping("/save")
	public ResponseEntity<Object> save() {
		this.jobService.saveJob();
		return ResponseEntity.ok().build();
	}

}
