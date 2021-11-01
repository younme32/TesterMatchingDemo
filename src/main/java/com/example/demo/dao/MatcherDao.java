package com.example.demo.dao;

import java.util.List;

import com.example.demo.bean.Tester;

public interface MatcherDao {
	public List<Tester> matchTestersByCountryAndDevice(List<String> countries, List<String> devices);
}
