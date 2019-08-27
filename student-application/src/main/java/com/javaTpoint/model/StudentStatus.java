package com.javaTpoint.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class StudentStatus {
	@Id
	private int id;
	private boolean status;
		 
	 public StudentStatus(){}
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "StudentStatus [id=" + id + ", status=" + status + "]";
	}
	
	

}
