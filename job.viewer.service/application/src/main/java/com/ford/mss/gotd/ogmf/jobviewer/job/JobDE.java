package com.ford.mss.gotd.ogmf.jobviewer.job;

import java.sql.Clob;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ford.mss.gotd.ogmf.jobviewer.controller.Job;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jobs")
public class JobDE {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long processCode;
	
	@Column(name = "processCodeName")
	private String processCodeName;
	@Column(name = "submittedTime")
	private OffsetDateTime submittedTime;
	
	@Column(name = "jobStatus")
	private String jobStatus; 
	@Column(name = "stopFlag")
	private String stopFlag;
	@Column(name = "parameters")
	private Clob parameters; 
	@Column(name = "jobRunStartTime")
	private OffsetDateTime jobRunStartTime;
	
	@Column(name = "completed")
	private float completed;
	
	@Column(name = "jobStartTime")
	private OffsetDateTime jobStartTime;
	@Column(name = "jobEndTime")
	private OffsetDateTime jobEndTime;
	@Column(name = "jvmName")
	private String jvmName;
	@Column(name = "recordCreatedTime")
	private OffsetDateTime recordCreatedTime;
	@Column(name = "recordCreatedUser")	
	private String recordCreatedUser;
	@Column(name = "lastUpdatedTime")	
	private OffsetDateTime lastUpdatedTime;
	@Column(name = "lastUpdatedUser")
	private String lastUpdatedUser;

	public static List<Job> transform(List<JobDE> jobDEs){
		List<Job> jobs = new ArrayList<>(jobDEs.size());
		for (JobDE jobDE : jobDEs) {
			jobs.add(
				Job.builder()
					.name(jobDE.getProcessCodeName())
					.completedOn(jobDE.getJobEndTime())
					.startedOn(jobDE.getJobStartTime())
					.status(jobDE.getJobStatus())
					.createdBy(jobDE.getRecordCreatedUser())
					.build()
				);
		}
		
		return jobs;
	}
}
