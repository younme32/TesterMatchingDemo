package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.TesterDao;

@Component
public class TesterServiceImpl implements TesterService{

	@Autowired
	TesterDao testerDao;
	
	@Override
	public List<String> getAllCountries() {
		return testerDao.getAllCountries();
	}

}
