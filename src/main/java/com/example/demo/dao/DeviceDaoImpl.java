package com.example.demo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.bean.Device;
import com.example.demo.util.DAOUtility;

@Component
public class DeviceDaoImpl implements DeviceDao {

	private final static String STATEMENT = """
			SELECT * 
			FROM devices;
			""";
	
	private final static String ID_COL = "ID";
	private final static String DESCR_COL = "Descr";
	
	@Override
	public List<Device> getAllDevices() {
		List<Device> devices = new LinkedList<Device>();
		
		
		try {
			Connection conn = DAOUtility.getConnection();
			Statement statement = conn.createStatement();
			
			boolean executionSuccesful = statement.execute(STATEMENT);
			
			if(executionSuccesful)
			{
				ResultSet rs = statement.getResultSet();
				processResults(rs, devices);
			}
			
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return devices;
	}
	
	private void processResults(ResultSet results, List<Device> devices)
	{
		try {
			while(results.next()) 
			{
				int id = results.getInt(ID_COL);
				String descr = results.getString(DESCR_COL);
				
				devices.add(new Device(id, descr));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
