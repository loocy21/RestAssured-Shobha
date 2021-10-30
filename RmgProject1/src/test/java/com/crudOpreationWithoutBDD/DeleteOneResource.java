package com.crudOpreationWithoutBDD;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteOneResource {
	
	public void delete() {
		 Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_802");
		ValidatableResponse validate = resp.then();
		validate.assertThat().contentType("application/json");
		validate.assertThat().assertThat().statusCode(204);
		
		validate.log().all();
	}
	}


