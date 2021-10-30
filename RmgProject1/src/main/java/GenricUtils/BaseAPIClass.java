package GenricUtils;

import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class BaseAPIClass {
	
	public DataBaseUtility dLib = new DataBaseUtility();
	public RestAssuredUtilities rLib = new RestAssuredUtilities();
	public JavaUtility jLib = new JavaUtility();
	
	@BeforeSuite
	public void bsConfig() throws Throwable
	{
		
		dLib.connectToDB();
		baseURI = "http://localhost";
		port = 8084;
	}
	public void asConfig () throws Throwable 
	{
		dLib.closeDB();
	}

}
