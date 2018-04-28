package com.vegas.currency.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "countryCodeFrom", "countryCodeTo" }) })
public class CurrencyRate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "countryCodeFrom")
	private String countryCodeFrom;
	@Column(name = "countryCodeTo")
	private String countryCodeTo;
	@Column(name = "conversionRate")
	private double conversionRate;

	@LastModifiedDate
	@Column(name = "lastUpdatedOn")
	private LocalDate lastUpdatedOn;

	public LocalDate getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(LocalDate lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountryCodeFrom() {
		return countryCodeFrom;
	}

	public void setCountryCodeFrom(String countryCodeFrom) {
		this.countryCodeFrom = countryCodeFrom;
	}

	public String getCountryCodeTo() {
		return countryCodeTo;
	}

	public void setCountryCodeTo(String countryCodeTo) {
		this.countryCodeTo = countryCodeTo;
	}

	public double getConversionRate() {
		return conversionRate;
	}

	public void setConversionRate(double conversionRate) {
		this.conversionRate = conversionRate;
	}
}
