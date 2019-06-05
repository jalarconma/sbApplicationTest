package com.conexia.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant_table")
public class TableEntity extends BaseEntity {

	private static final long serialVersionUID = -766183555558675108L;
	
	@Id
	@GeneratedValue(generator = "table_generator")
	@SequenceGenerator(name = "table_generator", sequenceName = "table_sequence")
	private Integer id;
	
	private String location;
	
	private Integer maxConsumers;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getMaxConsumers() {
		return maxConsumers;
	}

	public void setMaxConsumers(Integer maxConsumers) {
		this.maxConsumers = maxConsumers;
	}
}
