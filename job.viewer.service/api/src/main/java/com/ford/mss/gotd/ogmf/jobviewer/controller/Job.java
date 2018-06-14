package com.ford.mss.gotd.ogmf.jobviewer.controller;

import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {
	private String name, status, createdBy;
	
	private OffsetDateTime submittedOn, startedOn, completedOn;
}
