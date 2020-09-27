package com.ApplicationJ.modelTO;

import java.util.List;

public class FoodTypeTO {

	private Integer food_type_id;
	private String name;
	private boolean status;
	private List<FoodTO> food;
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
	public List<FoodTO> getFood() {
		return food;
	}
	public void setFood(List<FoodTO> food) {
		this.food = food;
	}
	
}
