package com.stackexelero.StateProperty.json;

import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.ALWAYS)
public class OperaJson {
	
	@JsonProperty(value = "type")
	private String operaType;
	
	private String assetWorks;
	private float coordinateX;
	private float coordinateY;
	private String council;
	private String postcode;
	
	@JsonProperty(value = "expences")
	private Set<ExpenditureJson> expenditures = new LinkedHashSet<ExpenditureJson>();
	
	public OperaJson() {}

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

	public Set<ExpenditureJson> getExpenditures() {
		return expenditures;
	}

	public void setExpenditures(Set<ExpenditureJson> expenditures) {
		this.expenditures = expenditures;
	}
}
