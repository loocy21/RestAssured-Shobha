package ComplexResponceValidation;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponce {
	@Test
	
	public void staticResponce() 
	{
		
		
		baseURI = "http://localhost";
		port = 8084;
		
		String expData = "TY_PROJ_002";
		
		
		//store all the responses
		Response res = when().get("/projects");
		
		
	//capture the data using json path	
	String actData = res.jsonPath().get("[0].projectId");
	System.out.println(actData);
	
	//validate
	Assert.assertEquals(actData, expData);
	System.out.println(actData + "data varified");
	
	res.then().log().all();
	
		
		
		
		
	}

}
