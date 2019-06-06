package com.conexia.billing.dto;

public class BillingClientDTO {
	
	private String clientName;
	
	private String clientLastName;
	
	private Double totalBillingsValue;

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientLastName() {
		return clientLastName;
	}

	public void setClientLastName(String clientLastName) {
		this.clientLastName = clientLastName;
	}

	public Double getTotalBillingsValue() {
		return totalBillingsValue;
	}

	public void setTotalBillingsValue(Double totalBillingsValue) {
		this.totalBillingsValue = totalBillingsValue;
	}
	
	

}
