package com.ApplicationJ.modelBO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="food_type")
public class FoodTypeBO{

	@Id
	@Column(name = "food_type_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer food_type_id;
	
	@Column(name="name")
	private String name;

	@Column(name="status")
	private boolean status;
	
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "type_id", referencedColumnName = "food_type_id", insertable = false, updatable = false, nullable = true)
	private List<FoodBO> food;

	public Integer getFood_type_id() {
		return food_type_id;
	}

	public void setFood_type_id(Integer food_type_id) {
		this.food_type_id = food_type_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<FoodBO> getFood() {
		return food;
	}

	public void setFood(List<FoodBO> food) {
		this.food = food;
	}
	
}