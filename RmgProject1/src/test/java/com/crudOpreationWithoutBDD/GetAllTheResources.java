package com.crudOpreationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetAllTheResources {
	
	@Test
	public void getAllData() {
		Response resp = RestAssured.get("http://localhost:8084/projects");
		System.out.println(resp.getContentType());
		System.out.println(resp.getTime());
		System.out.println(resp.statusCode());
		
		ValidatableResponse validate = resp.then();
		validate.assertThat().contentType("application/json");
		validate.assertThat().assertThat().statusCode(200);
		resp.prettyPrint();
		validate.log().all();
	}

}
