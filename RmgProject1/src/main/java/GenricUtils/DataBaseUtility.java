package GenricUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * this class cointains generic method to access database connection
 * @author SHOBHA
 *
 */

public class DataBaseUtility {
	
	Connection con;
	ResultSet result;
	/**
	 * this method will get connection to database
	 * @throws Throwable 
	 */
	public void connectToDB() throws Throwable
	{
	Driver  driverref=new Driver();
		DriverManager.registerDriver(driverref);
		con= DriverManager.getConnection(IPathConstants.dbURL, IPathConstants.dbUsername,IPathConstants.dbPassword);
	}
	/**
	 * this method will close the database connection
	 * @throws Throwable 
	 */
	
	public void closeDB() throws Throwable
	{
		con.close();
	
	}
	/**
	 * this method will execte select query and return the value
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws Throwable 
	 */
	public String executeQueryAndGetData(String query,int columnIndex,String expData) throws Throwable
	{
		Boolean flag = false;
		result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			String actData = result.getString(columnIndex);
			if(actData.equalsIgnoreCase(expData))
			{
				flag = true;
				break;
			}
		}
		if(flag)
		{
			System.out.println(expData + "data verified succesfully");
			return expData;
		}
		else
			
		{
			System.out.println(expData + "data not verified in DB");
			return "";
		}
	}
		
	}

