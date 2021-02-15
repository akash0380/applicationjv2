package com.ApplicationJ.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="food")
public class FoodBO{

	@Id
	@Column(name = "food_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long food_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;

	@Column(name="status")
	private boolean status;
	
	@Column(name = "type_id")
	private Long type_id;

	public Long getFood_id() {
		return food_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Long getType_id() {
		return type_id;
	}

	public void setType_id(Long type_id) {
		this.type_id = type_id;
	}

	public void setFood_id(Long food_id) {
		this.food_id = food_id;
	}
	
}