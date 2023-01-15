package com.stackexelero.StateProperty.json;

import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.ALWAYS)
public class ApplicantJson {
	private String name;
	private String lastName;
	private String dateOfBirth;
	
	@JsonProperty(value = "type")
	private String applicantType;
	
	private Set<ContactInfoJson> contactInfo = new LinkedHashSet<ContactInfoJson>();
	
	public ApplicantJson() {}

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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getApplicantType() {
		return applicantType;
	}

	public void setApplicantType(String applicantType) {
		this.applicantType = applicantType;
	}

	public Set<ContactInfoJson> getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(Set<ContactInfoJson> contactInfo) {
		this.contactInfo = contactInfo;
	}
}
