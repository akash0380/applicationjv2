package com.ApplicationJ.modelTO;

import java.util.Date;

public class UsersTO {

	private Integer id;
	private String name;
	private String username;
	private String password;
	private String email;
	private StatusTO status;
	private FoodTypeTO foodtype;
	private Date updatedAt;
	private Integer updatedBy;
	private Date createdAt;
	private Integer createdBy;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public StatusTO getStatus() {
		return status;
	}

	public void setStatus(StatusTO status) {
		this.status = status;
	}
	
	public FoodTypeTO getFoodtype() {
		return foodtype;
	}

	public void setFoodtype(FoodTypeTO foodtype) {
		this.foodtype = foodtype;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	
}
