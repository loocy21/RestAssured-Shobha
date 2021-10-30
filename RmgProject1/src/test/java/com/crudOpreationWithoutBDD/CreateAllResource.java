package com.crudOpreationWithoutBDD;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateAllResource {
	
	public void create() {
		
		//create the json data before request
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "rmgyantra");
		jobj.put("projectName", "rmgyantra_project");
		jobj.put("status", "completed");
		jobj.put("teamSize", 10);
		
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jobj);
		
		Response res = req.post("http://localhost:8084/addProject");
		ValidatableResponse validate = res.then();
		validate.assertThat().contentType("application/json");
		validate.assertThat().assertThat().statusCode(201);
	
		validate.log().all();
	}
		
	}


