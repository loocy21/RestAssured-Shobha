package CrudOpreationWithBDD;

import org.testng.annotations.Test;


import com.POJO.Class.ProjectLibrary;

import GenricUtils.JavaUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingPOJO {
	@Test
	
	public void CreateProjectUsingPOJO ()
	{
		JavaUtility jLib = new JavaUtility();
		baseURI = "http://localhost";
		port = 8084;
		
		//read data throw pojo class
		ProjectLibrary pLib = new ProjectLibrary("shobha","Accionabs" +jLib.getRandomNumber(),"Completed",20);
		
		//request Specification	
		given()
		.contentType(ContentType.JSON)
		.body(pLib)
		
		//request
		
		.when()
		.post("/addProject")
		//validation
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
		
	}

}
