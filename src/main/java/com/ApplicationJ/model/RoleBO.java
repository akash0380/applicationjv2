package com.ApplicationJ.model;

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
@Table(name="roles")
public class RoleBO{

	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer role_id;
	
	@Column(name="name")
	private String name;

	@Column(name="status")
	private boolean status;
	
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", referencedColumnName = "role_id", insertable = false, updatable = false, nullable = true)
	private List<AuthUriBO> authUri;

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
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

	public List<AuthUriBO> getAuthUri() {
		return authUri;
	}

	public void setAuthUri(List<AuthUriBO> authUri) {
		this.authUri = authUri;
	}

	@Override
	public String toString() {
		return "RoleBO [role_id=" + role_id + ", name=" + name + ", status=" + status + ", authUri=" + authUri + "]";
	}
	
}