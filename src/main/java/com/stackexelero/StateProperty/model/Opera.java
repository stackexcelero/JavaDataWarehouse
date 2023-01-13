package com.stackexelero.StateProperty.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * Opera -> From Latin opera, plural of opus; a collection of work.
 * */
@Entity
@Table(name="opera")
public class Opera {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="assetId")
	private Integer operaId;
	
	@Basic
	private String operaType;
	
	@Basic
	private String assetWorks;
	
	@Basic
	private float coordinateX;
	
	@Basic
	private float coordinateY;
	
	@Basic
	private String council;
	
	@Basic
	private String postcode;
	
	@ManyToMany(mappedBy="operas", cascade = CascadeType.ALL)
	Set<Application> applications = new LinkedHashSet<>();
	
	@OneToMany(mappedBy ="opera", cascade = CascadeType.ALL)  
	Set<Expenditure> expenditures = new LinkedHashSet<Expenditure>();
	
	public Opera() {}

	public float getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(float coordinateX) {
		this.coordinateX = coordinateX;
	}

	public float getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(float coordinateY) {
		this.coordinateY = coordinateY;
	}

	public Set<Application> getApplications() {
		return applications;
	}

	public void setApplications(Set<Application> applications) {
		this.applications = applications;
	}

	public Integer getOperaId() {
		return operaId;
	}

	public void setOperaId(Integer operaId) {
		this.operaId = operaId;
	}

	public Set<Expenditure> getExpenditures() {
		return expenditures;
	}

	public void setExpenditures(Set<Expenditure> expenditures) {
		this.expenditures = expenditures;
	}

	public String getOperaType() {
		return operaType;
	}

	public void setOperaType(String operaType) {
		this.operaType = operaType;
	}

	public String getAssetWorks() {
		return assetWorks;
	}

	public void setAssetWorks(String assetWorks) {
		this.assetWorks = assetWorks;
	}

	public String getCouncil() {
		return council;
	}

	public void setCouncil(String council) {
		this.council = council;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
}
