package com.crudOpreationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjects {
	@Test
	
	public void GetAllProjects (){
		
		//send the request
		Response res = RestAssured.get("http://localhost:8084/projects");
		//print the responce
		System.out.println(res.getContentType());
		System.out.println(res.prettyPrint());
		System.out.println(res.prettyPeek());
		//System.out.println(res.asString());
	}

}
