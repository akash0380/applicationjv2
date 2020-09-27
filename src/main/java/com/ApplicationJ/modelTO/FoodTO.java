package com.ApplicationJ.modelTO;

public class FoodTO {

	private Integer food_id;
	private String name;
	private String description;
	private boolean status;
	private FoodTypeTO food_type;
	private Integer type_id;
	public Integer getFood_id() {
		return food_id;
	}
	public void setFood_id(Integer food_id) {
		this.food_id = food_id;
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
	public FoodTypeTO getFood_type() {
		return food_type;
	}
	public void setFood_type(FoodTypeTO food_type) {
		this.food_type = food_type;
	}
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	
}
