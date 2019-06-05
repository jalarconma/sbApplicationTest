package com.conexia.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "WAITER")
public class WaiterEntity extends BaseEntity {

	private static final long serialVersionUID = 2493937053645232029L;
	
	@Id
	@GeneratedValue(generator = "waiter_generator")
	@SequenceGenerator(name = "client_generator", sequenceName = "waiter_sequence")
	private Integer id;
	
	private String name;
	
	private String firstLastName;
	
	private String secondLastName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstLastName() {
		return firstLastName;
	}

	public void setFirstLastName(String firstLastName) {
		this.firstLastName = firstLastName;
	}

	public String getSecondLastName() {
		return secondLastName;
	}

	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}

}
