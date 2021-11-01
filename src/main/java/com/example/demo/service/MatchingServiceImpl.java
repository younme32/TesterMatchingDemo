package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.bean.Tester;
import com.example.demo.dao.MatcherDao;

@Component
public class MatchingServiceImpl implements MatchingService {

	@Autowired
	MatcherDao matchDao;
	
	@Override
	public List<Tester> matchTesters(List<String> countries, List<String> devices) {
		return matchDao.matchTestersByCountryAndDevice(countries, devices);
	}

}
