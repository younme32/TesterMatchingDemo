package com.example.demo.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


public class Tester {
	
	//id
	private int id;
	//first name
	private String firstName;
	//last name
	private String lastName; 
	//country
	private String country;
	//last login
	private Date lastLogin;
	
	private List<Device> devices;
	
	private int bugsFilled;
	
	public Tester() {
		super();
		devices = new ArrayList<Device>();
	}
	
	public Tester(String firstName, String lastName, String country, Date lastLogin) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.lastLogin = lastLogin;
		devices = new ArrayList<Device>();
	}

	public Tester(String firstName, String lastName, String country, Date lastLogin, int bugsFilled) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.lastLogin = lastLogin;
		this.bugsFilled = bugsFilled;
		devices = new ArrayList<Device>();
	}

	public Tester(int id, String firstName, String lastName, String country, Date lastLogin, int bugsFilled) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.lastLogin = lastLogin;
		this.bugsFilled = bugsFilled;
		devices = new ArrayList<Device>();
	}



	public List<Device> getDevices() {
		return devices;
	}



	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public void addDevice(Device device)
	{
		this.devices.add(device);
	}

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public Date getDate() {
		return lastLogin;
	}



	public void setDate(Date lastLogin) {
		this.lastLogin = lastLogin;
	}



	public int getBugsFilled() {
		return bugsFilled;
	}

	public void setBugsFilled(int bugsFilled) {
		this.bugsFilled = bugsFilled;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bugsFilled, country, devices, firstName, id, lastLogin, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tester other = (Tester) obj;
		return bugsFilled == other.bugsFilled && Objects.equals(country, other.country)
				&& Objects.equals(devices, other.devices) && Objects.equals(firstName, other.firstName)
				&& id == other.id && Objects.equals(lastLogin, other.lastLogin)
				&& Objects.equals(lastName, other.lastName);
	}

	@Override
	public String toString() {
		return "Tester [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", country=" + country
				+ ", lastLogin=" + lastLogin + ", devices=" + devices + ", bugsFilled=" + bugsFilled + "]";
	}

	
}
