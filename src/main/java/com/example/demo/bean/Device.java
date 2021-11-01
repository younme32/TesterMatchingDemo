package com.example.demo.bean;

import java.util.Objects;

public class Device {

	//id
	private int id;
	//description
	private String description;
	
	
	
	public Device() {
		super();
	}



	public Device(String description) {
		super();
		this.description = description;
	}



	public Device(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Device other = (Device) obj;
		return Objects.equals(description, other.description) && id == other.id;
	}



	@Override
	public String toString() {
		return "Device [id=" + id + ", description=" + description + "]";
	}
	
}
