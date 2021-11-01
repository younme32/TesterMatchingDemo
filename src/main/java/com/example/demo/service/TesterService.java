package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;


@Component
public interface TesterService {
	public List<String> getAllCountries();
}
