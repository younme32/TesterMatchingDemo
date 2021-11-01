package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.bean.Device;

@Component
public interface DeviceService {
	public List<Device> getAllDevices();
}
