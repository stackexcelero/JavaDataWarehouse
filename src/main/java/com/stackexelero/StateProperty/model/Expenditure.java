package com.stackexelero.StateProperty.model;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="expenditure")
public class Expenditure {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idExpenditure")
	private Integer idExpenditure;
	
	@Basic
	private String description;
	
	@Basic
	private BigDecimal amount;
	
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar date;
	
	@ManyToOne
	@JoinColumn(name = "operaId")
	private Opera opera;
	
	public Expenditure() {}
	
	public Integer getIdExpenditure() {
		return idExpenditure;
	}

	public void setIdExpenditure(Integer idExpenditure) {
		this.idExpenditure = idExpenditure;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Opera getOpera() {
		return opera;
	}

	public void setOpera(Opera opera) {
		this.opera = opera;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}
}
