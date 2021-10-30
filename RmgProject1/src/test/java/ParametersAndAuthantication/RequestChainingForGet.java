package ParametersAndAuthantication;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import com.POJO.Class.ProjectLibrary;

import GenricUtils.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RequestChainingForGet {
	
@Test
	
	public void requestChainingForGet ()
	{
		JavaUtility jLib = new JavaUtility();
		baseURI = "http://localhost";
		port= 8084;
		
		ProjectLibrary pLib = new ProjectLibrary("Shiva","Accenture" +jLib.getRandomNumber(),"Completed",50);
		 Response res= given()
		.contentType(ContentType.JSON)
		.body(pLib)
		.when()
		.post("/addProject");
		 
		 String myProjID = res.jsonPath().getString("projectId");
		 System.out.println(myProjID);
		 
		 res.then().log().all();
		 
		 given()
		 .pathParam("ProjID", myProjID)
		 
		 .when()
		 .get("/projects/{projID}")
		 
		 .then().assertThat().statusCode(200).log().all();
		
	}

}
