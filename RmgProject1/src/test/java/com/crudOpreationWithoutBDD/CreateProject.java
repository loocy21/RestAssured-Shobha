package com.crudOpreationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
	@Test
	

	public void createProject() 
	{
		//create the json data before request
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "shobha");
		jobj.put("projectName", "project");
		jobj.put("status", "completed");
		jobj.put("teamSize", 11);
		
		
		//set the request specification before sending the request
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jobj);
		
		//send the request
		Response res = req.post("http://localhost:8084/addProject");
		res.then().assertThat().statusCode(201);
		//print the response
		System.out.println(res.asString());
		System.out.println(res.prettyPrint());
		System.out.println(res.prettyPeek()); 
			
		}
		
	}


