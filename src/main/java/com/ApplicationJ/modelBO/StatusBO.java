package com.ApplicationJ.modelBO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="status")
public class StatusBO{

	@Id
	@Column(name = "status_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer status_id;
	
	@Column(name="name")
	private String name;

	@Column(name="status")
	private boolean status;
	
//    @OneToMany(mappedBy = "status")
//    private List<UsersBO> users = new ArrayList<UsersBO>();

	public Integer getStatus_id() {
		return status_id;
	}

	public void setStatus_id(Integer status_id) {
		this.status_id = status_id;
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

	@Override
	public String toString() {
		return "StatusBO [status_id=" + status_id + ", name=" + name + ", status=" + status + "]";
	}
	
}