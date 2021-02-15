package com.ApplicationJ.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users_token")
public class UsersToken {

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "token", length = 3000)
	private String token;

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", nullable = false, unique = true)
	private UsersBO userbo;

	public UsersToken() {}

	public UsersToken(String token, UsersBO userbo) {
		super();
		this.token = token;
		this.userbo = userbo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UsersBO getUserbo() {
		return userbo;
	}

	public void setUserbo(UsersBO userbo) {
		this.userbo = userbo;
	}

}
