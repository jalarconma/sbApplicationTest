package com.conexia.entities;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BILLING")
public class BillingEntity extends BaseEntity {

	private static final long serialVersionUID = -4438096790155234328L;
	
	@Id
	@GeneratedValue(generator = "billing_generator")
	@SequenceGenerator(name = "billing_generator", sequenceName = "billing_sequence")
	private Integer id;
	
    @JoinColumn(name = "CLIENT_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private ClientEntity client;
    
    @JoinColumn(name = "WAITER_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private WaiterEntity waiter;
    
    @JoinColumn(name = "TABLE_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private TableEntity table;
    
    private Double value;
    
    private LocalTime registrationDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ClientEntity getClient() {
		return client;
	}

	public void setClient(ClientEntity client) {
		this.client = client;
	}

	public WaiterEntity getWaiter() {
		return waiter;
	}

	public void setWaiter(WaiterEntity waiter) {
		this.waiter = waiter;
	}

	public TableEntity getTable() {
		return table;
	}

	public void setTable(TableEntity table) {
		this.table = table;
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
