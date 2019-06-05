package com.conexia.billing.dto;

import java.time.LocalTime;

import javax.validation.constraints.NotNull;

public class BillingINDTO {
	
	@NotNull
	private Integer clientId;
	
	@NotNull
	private Integer waiterId;
	
	@NotNull
	private Integer tableId;
	
	@NotNull
	private Double value;
	
	@NotNull
	private LocalTime registrationDate;

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getWaiterId() {
		return waiterId;
	}

	public void setWaiterId(Integer waiterId) {
		this.waiterId = waiterId;
	}

	public Integer getTableId() {
		return tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public LocalTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalTime registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	
}
