package com.stackexelero.StateProperty.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/*
 * Asset is Opera -> From Latin opera, plural of opus; a collection of work.
 * */
@Entity
@Table(name="asset")
public class Asset {
	@Id
	@Column(name="assetId")
	private Integer assetId;
	
	@Basic
	private String assetType;
	
	@Basic
	private String assetDescription;
	
	@Basic
	private float coordinateX;
	
	@Basic
	private float coordinateY;
	
	@ManyToMany(mappedBy="assets")
	Set<Application> applications = new LinkedHashSet<>();
	
	public Asset() {}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public String getAssetDescription() {
		return assetDescription;
	}

	public void setAssetDescription(String assetDescription) {
		this.assetDescription = assetDescription;
	}

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

	public Integer getAssetId() {
		return assetId;
	}

	public void setAssetId(Integer assetId) {
		this.assetId = assetId;
	}

	public Set<Application> getApplications() {
		return applications;
	}

	public void setApplications(Set<Application> applications) {
		this.applications = applications;
	}
}
