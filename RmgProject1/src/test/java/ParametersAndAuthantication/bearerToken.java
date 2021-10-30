package ParametersAndAuthantication;

import java.util.HashMap;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class bearerToken {
	@Test
	
	public void bearerToken()
	
	{
		HashMap map = new HashMap();
		map.put("name", "REST-BEARER-TOKEN");
		
		given()
		.auth()
		.oauth2("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")
		.body(map)
		
		.when()
		.post("https://api.github.com/users/repos")
		
		.then().log().all();
	}

}
