package com.conexia.billing.dto;

public class BillingRegistrationINDTO {
	
	private String year;
	
	private String month;
	
	public BillingRegistrationINDTO(String year, String month) {
		this.year = year;
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	
	
}
