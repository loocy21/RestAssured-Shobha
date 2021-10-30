package com.crudOpreationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
	@Test
	
	public void UpdateProject()
	{
		JSONObject js = new JSONObject();
		js.put("createdBy", "Shobha");
		js.put("createdBy", "Axisbank");
		js.put("createdBy", "on-going");
		js.put("createdBy", 50);
		
	RequestSpecification req = RestAssured.given();
	req.contentType(ContentType.JSON);
	req.body(js);
	
	Response res = req.put("http://localhost:8084/projects/TY_PROJ_802");
	
	res.then().assertThat().statusCode(200);
	
		
	}

}
