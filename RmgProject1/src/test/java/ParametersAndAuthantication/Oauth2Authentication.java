package ParametersAndAuthantication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2Authentication {
	@Test
	
	public void oauth()
	{
		Response res = given()
		.formParam("client_id", "SDET_21_Automation")
		.formParam("client_secret", "b3a400ea7c75b09661d80246eeaaf734")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://example.com")
		.formParam("code","authorization_code")
		
		
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		
		//res.then().log().all();
		String Token = res.jsonPath().get("access_token");
		System.out.println(Token);
		
		//create a new request to access the token
		
		given()
		.auth()
		.oauth2(Token)
		.pathParam("USER_ID","2413")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
	
		.then().log().all();
		
	
		
		
		
		
		
	}

}
