package com.stock.company.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "STOCKMARKET")
@Entity
public class Company {

	@Id
	@Column(name = "COMPANYCODE")
	private String companyCode;

	@Column(name = "COMPANYNAME")
	private String companyName;

	@Column(name = "CEO")
	private String companyCEO;

	@Column(name = "TURNOVER")
	private Double companyTrunover;

	@Column(name = "WEBSITE")
	private String companyWebsite;

	@Column(name = "STOCKENLISTED")
	private String companystock;

	public Company() {

	}

	public Company(String companyCode, String companyName, String companyCEO, Double companyTrunover,
			String companyWebsite, String companystock) {
		super();
		this.companyCode = companyCode;
		this.companyName = companyName;
		this.companyCEO = companyCEO;
		this.companyTrunover = companyTrunover;
		this.companyWebsite = companyWebsite;
		this.companystock = companystock;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyCEO() {
		return companyCEO;
	}

	public void setCompanyCEO(String companyCEO) {
		this.companyCEO = companyCEO;
	}

	public Double getCompanyTrunover() {
		return companyTrunover;
	}

	public void setCompanyTrunover(Double companyTrunover) {
		this.companyTrunover = companyTrunover;
	}

	public String getCompanyWebsite() {
		return companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	public String getCompanystock() {
		return companystock;
	}

	public void setCompanystock(String companystock) {
		this.companystock = companystock;
	}

	@Override
	public String toString() {
		return "Company [companyCode=" + companyCode + ", companyName=" + companyName + ", companyCEO=" + companyCEO
				+ ", companyTrunover=" + companyTrunover + ", companyWebsite=" + companyWebsite + ", companystock="
				+ companystock + "]";
	}

}
