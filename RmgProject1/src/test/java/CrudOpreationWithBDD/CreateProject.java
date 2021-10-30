package CrudOpreationWithBDD;

import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProject {
	
	@Test
	
	public void createProjectUsingBDD ()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "shobha");
		jobj.put("projectName", "Byjus_project");
		jobj.put("status", "completed");
		jobj.put("teamSize", 10);
		
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		
		
		.when()
		.post("http://localhost:8084/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
		

}
}