package com.stackexelero.StateProperty.json;

import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = Include.ALWAYS)
public class ApplicationMasterJson {
	private String description;
	
	@JsonProperty(value = "type")
	private String applicationType;
	
	private String status;
	private String startDate;
	private String endDate;
	
	@JsonProperty(value = "requestors")
	private Set<ApplicantJson> applicants = new LinkedHashSet<ApplicantJson>();
	
	private Set<OperaJson> operas = new LinkedHashSet<OperaJson>();
	
	public ApplicationMasterJson () {}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getApplicationType() {
		return applicationType;
	}

	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Set<ApplicantJson> getApplicants() {
		return applicants;
	}

	public void setApplicants(Set<ApplicantJson> applicants) {
		this.applicants = applicants;
	}

	public Set<OperaJson> getOperas() {
		return operas;
	}

	public void setOperas(Set<OperaJson> operas) {
		this.operas = operas;
	}
}
