package com.conexia.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class ClientEntity extends BaseEntity {

	private static final long serialVersionUID = -5688914738377618071L;

	@Id
	@GeneratedValue(generator = "client_generator")
	@SequenceGenerator(name = "client_generator", sequenceName = "client_sequence", initialValue = 1000)
	private Integer id;
	
	private String name;
	
	private String firstLastName;
	
	private String secondLastName;
	
	private String observations;

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

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}
		
}
