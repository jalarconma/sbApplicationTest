package com.conexia.billing.dto;

public class BillingWaiterDTO {
	
	private String waiterName;
	
	private String waiterLastName;
	
	private Double totalBillingsValue;

	public String getWaiterName() {
		return waiterName;
	}

	public void setWaiterName(String waiterName) {
		this.waiterName = waiterName;
	}

	public String getWaiterLastName() {
		return waiterLastName;
	}

	public void setWaiterLastName(String waiterLastName) {
		this.waiterLastName = waiterLastName;
	}

	public Double getTotalBillingsValue() {
		return totalBillingsValue;
	}

	public void setTotalBillingsValue(Double totalBillingsValue) {
		this.totalBillingsValue = totalBillingsValue;
	}

}
