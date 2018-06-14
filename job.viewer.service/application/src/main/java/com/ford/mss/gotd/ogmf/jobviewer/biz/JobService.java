package com.ford.mss.gotd.ogmf.jobviewer.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ford.mss.gotd.ogmf.jobviewer.controller.Job;
import com.ford.mss.gotd.ogmf.jobviewer.job.JobDE;
import com.ford.mss.gotd.ogmf.jobviewer.job.JobRepository;

@Service
public class JobService {
	private JobRepository jobRepository;
	
	@Autowired
	public JobService(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}
	
	public List<Job> getAllJobs() {
		return JobDE.transform(jobRepository.findAll());
	}
	
	public boolean saveJob() {
		jobRepository.save(JobDE.builder().completed(0).build());
		return true;
	}
	
}
