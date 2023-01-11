package com.stackexelero.StateProperty.model;

import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="application")
public class Application {
	@Id
	@Column(name="applicationId")
	private Integer applicationId;
	
	@Basic
	private char status;
	
	@Basic
	private String title;
	
	@Basic
	private String description;
	
	@Basic
	private String applicationType;
	
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar startDate;
	
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar endDate;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable( name="application_applicant", joinColumns = { @JoinColumn(name="applicationId") }, 
	inverseJoinColumns = { @JoinColumn( name="applicantId" ) })
	Set<Applicant> applicants = new LinkedHashSet<>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable( name="application_applicant", joinColumns = { @JoinColumn(name="applicationId") }, 
		inverseJoinColumns = { @JoinColumn( name="assetId" ) })
	Set<Asset> assets = new LinkedHashSet<>();
	
	public Application() {}

	public Integer getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

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

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	public Set<Applicant> getApplicants() {
		return applicants;
	}

	public void setApplicants(Set<Applicant> requestors) {
		this.applicants = requestors;
	}

	public Set<Asset> getAssets() {
		return assets;
	}

	public void setAssets(Set<Asset> assets) {
		this.assets = assets;
	}
	
}
