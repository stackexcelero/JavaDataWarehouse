package com.stackexelero.StateProperty.model;

import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="applicant")
public class Applicant {
	@Id
	@Column(name="applicantId")
	private Integer applicantId;
	
	@Basic
	private String name;
	
	@Basic
	private String lastName;
	
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dateOfBirth;
	
	@Basic
	@Enumerated(EnumType.STRING)
	private ApplicantType applicantType;
	
	@OneToOne(mappedBy = "applicant", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
	private ContactInfo contactInfo;
	
	@ManyToMany(mappedBy="applicants")
	Set<Application> applications = new LinkedHashSet<>();
	
	public Applicant() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}

	public ApplicantType getApplicantType() {
		return applicantType;
	}

	public void setApplicantType(ApplicantType applicantType) {
		this.applicantType = applicantType;
	}

	public Set<Application> getApplications() {
		return applications;
	}

	public void setApplications(Set<Application> applications) {
		this.applications = applications;
	}
}
