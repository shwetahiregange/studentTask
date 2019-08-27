package com.javaTpoint.model;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity 

public class StudentName {
	@Id

	private int id;
	private String name;

	public StudentName(){}
	

	public StudentName(int id,String name) {
		this.id = id;
		this.name=name;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "StudentName [id=" + id + ", name=" + name + "]";
	}
}



