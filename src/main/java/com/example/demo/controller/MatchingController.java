package com.example.demo.controller;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Device;
import com.example.demo.bean.Tester;
import com.example.demo.service.DeviceService;
import com.example.demo.service.MatchingService;
import com.example.demo.service.TesterService;

@RestController
@RequestMapping(value = "/api/demo/Matching/")
@ImportResource("classpath:beans.xml")
public class MatchingController {
	
	@Autowired
	DeviceService deviceService;
	
	@Autowired
	MatchingService matchingService;
	
	@Autowired
	TesterService testerService;
	
	private static final String COUNTRIES = "countries";
	private static final String DEVICES = "devices";
	
	
	@RequestMapping(value = "Match", method = RequestMethod.GET, produces = "application/json" )
	@ResponseBody
	public List<Tester> matchTesters(HttpServletRequest request)
	{
		
		List<Tester> testers = null;
		List<String> countries = new LinkedList<String>();
		List<String> devices = new LinkedList<String>();
		
		if(request.getParameter(COUNTRIES) != null)
		{
			countries = new LinkedList<String>(Arrays.asList( request.getParameter(COUNTRIES).split("_")));
		}
		if(request.getParameter(DEVICES) != null)
		{
			devices = new LinkedList<String>(Arrays.asList(request.getParameter(DEVICES).split("_")));
		}
		
		
		
		testers = matchingService.matchTesters(countries,  devices);
		
		
		return testers;
	}
	
	@RequestMapping(value="countries", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<String> getCountries()
	{
		return testerService.getAllCountries();
	}
	
	@RequestMapping(value="devices", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Device> getDevices()
	{
		return deviceService.getAllDevices();
	}
}
