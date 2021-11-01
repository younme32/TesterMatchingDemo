package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.bean.Device;
import com.example.demo.dao.DeviceDao;

@Component
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	DeviceDao deviceDao;
	
	@Override
	public List<Device> getAllDevices() {
		return deviceDao.getAllDevices();
	}

}
