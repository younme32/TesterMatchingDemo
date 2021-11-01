package com.example.demo.bean;

import java.util.Objects;



import org.springframework.stereotype.Component;

@Component
public class Bug {
	

	public int id;
	public Device device;	
	public Tester tester;
	
	
	public Bug() {
		super();
	}

	public Bug(int id, Device device, Tester tester) {
		super();
		this.id = id;
		this.device = device;
		this.tester = tester;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public Tester getTester() {
		return tester;
	}

	public void setTester(Tester tester) {
		this.tester = tester;
	}

	@Override
	public int hashCode() {
		return Objects.hash(device, id, tester);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bug other = (Bug) obj;
		return Objects.equals(device, other.device) && id == other.id && Objects.equals(tester, other.tester);
	}
	
	
}
