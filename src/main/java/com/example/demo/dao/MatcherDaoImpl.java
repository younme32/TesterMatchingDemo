package com.example.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.bean.Device;
import com.example.demo.bean.Tester;
import com.example.demo.util.DAOUtility;

@Component
public class MatcherDaoImpl implements MatcherDao {

	//This Statement brings back more information then is strictly necessary for the requirements.
	//You could Omit the deviceID, description, and even the Last Login, and change the GROUP BY to just tester.ID
	private final static String BASE_STATEMENT = """
			SELECT tester.ID as testerID, FirstName, LastName, Country, LastLogin, devices.ID as DeviceID, devices.Descr as DeviceDescr, COUNT(bugs.ID) as bugCount
			FROM tester 
			INNER JOIN tester_devices 
			ON tester_devices.TesterID = tester.ID
			INNER JOIN devices
			ON devices.ID = tester_devices.DeviceID
			INNER JOIN bugs
			ON tester.ID = bugs.TesterID
			WHERE bugs.DeviceID = devices.ID 
			""";
	private final static String GROUP_BY_CLAUSE = " GROUP BY tester.ID, DeviceID;";
	
	//Column Names
	private final static String TESTER_ID_COL = "testerID";
	private final static String FIRST_NAME_COL = "FirstName";
	private final static String LAST_NAME_COL = "LastName";
	private final static String COUNTRY_COL = "Country";
	private final static String LAST_LOGIN_COL = "LastLogin";
	private final static String DEVICE_ID_COL = "DeviceID";
	private final static String DEVICE_DESCR_COL = "DeviceDescr";
	private final static String BUG_COUNT_COL = "bugCount";
	
	
	@Override
	public List<Tester> matchTestersByCountryAndDevice(List<String> countries, List<String> devices) {
		List<Tester> testers = new LinkedList<Tester>();
		
		
		try {
			Connection conn = DAOUtility.getConnection();
			
			String sqlText = prepareStatement(countries, devices);
			PreparedStatement statement = conn.prepareStatement(sqlText);
			
			int i = 1;
			for(; i <= countries.size(); i++)
			{
				statement.setString(i, countries.get(i - 1));
			}
			for(;i <= countries.size() + devices.size(); i++)
			{
				statement.setString(i,  devices.get(i-1 - countries.size()));
			}
			
			boolean executionSuccesful = statement.execute();
			
			if(executionSuccesful)
			{
				ResultSet rs = statement.getResultSet();
				processResults(rs, testers);
			}
			
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return testers;
	}
	
	private void processResults(ResultSet results, List<Tester> testers)
	{
		try {
			while(results.next()) 
			{
				//Get values from ResultList
				int id = results.getInt(TESTER_ID_COL);
				String firstName = results.getString(FIRST_NAME_COL);
				String lastName = results.getString(LAST_NAME_COL);
				String country = results.getString(COUNTRY_COL);
				Date login = results.getDate(LAST_LOGIN_COL);
				int deviceId = results.getInt(DEVICE_ID_COL);
				String deviceDescr = results.getString(DEVICE_DESCR_COL);
				int bugCount = results.getInt(BUG_COUNT_COL);
				
				//If the tester already exists use that otherwise make a new one.
				Tester test = null;
				
				
				 test = testers.stream().filter(tester -> (tester.getId() == id)).findAny().orElse(null);
				 if(test == null)
				 {
					test = new Tester(firstName, lastName, country, login); 
					test.setId(id);
					testers.add(test);
				 }
				
				//Add Device to the Tester's Device List
				Device device = new Device(deviceId, deviceDescr);
				test.addDevice(device);
				
				//Update Bugs Filled field with this Devices bug count
				test.setBugsFilled(test.getBugsFilled() + bugCount);	
	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String prepareStatement(List<String> countries, List<String> devices)
	{
		StringBuilder statement = new StringBuilder();
		statement.append(BASE_STATEMENT);
		if (countries.size() > 0)
		{
			statement.append("AND ( ");
			addWhereStatements(countries, statement, "tester.country");
			statement.append( ") ");
			
		}
		if(devices.size() > 0)
		{
			
			statement.append(" AND (" );
			addWhereStatements(devices, statement, "devices.Descr");
			statement.append( ")");
		}
		
		statement.append( GROUP_BY_CLAUSE);
		
		return statement.toString();
	}
	
	private void addWhereStatements(List<String> items, StringBuilder statement, String columnName)
	{
		for(String item : items)
		{
			statement.append( "(" + columnName + " = ?)");
			if(items.indexOf(item) + 1 != items.size()) 
			{
				statement.append( " OR");				
			}
		}
	}

}
