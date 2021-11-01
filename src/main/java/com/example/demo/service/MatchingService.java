package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.bean.Tester;

@Component
public interface MatchingService {
	public List<Tester> matchTesters(List<String> countries, List<String> devices);
}
