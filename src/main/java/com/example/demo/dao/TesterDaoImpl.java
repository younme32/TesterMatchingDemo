package com.example.demo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.util.DAOUtility;

@Component
public class TesterDaoImpl implements TesterDao {

	private final static String STATEMENT = """
			SELECT Country FROM tester GROUP BY Country;
			""";
	private static final String COUNTRY_COL = "Country";
	
	@Override
	public List<String> getAllCountries() {
		List<String> countries = new LinkedList<String>();
		
		
		try {
			
			Connection conn = DAOUtility.getConnection();
			Statement statement = conn.createStatement();
			
			boolean executionSuccesful = statement.execute(STATEMENT);
			
			if(executionSuccesful)
			{
				ResultSet rs = statement.getResultSet();
				processResults(rs, countries);
			}
			
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return countries;
	}
	
	private void processResults(ResultSet results, List<String> countries)
	{
		try {
			while(results.next())
			{
				countries.add(results.getString(COUNTRY_COL));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
