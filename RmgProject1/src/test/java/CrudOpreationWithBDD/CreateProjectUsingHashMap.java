package CrudOpreationWithBDD;

import static io.restassured.RestAssured.given;


import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class CreateProjectUsingHashMap {
	@Test
	
	public void CreateProjectUsingHashMap()
	{
	
	HashMap map = new HashMap();
	map.put("createdBy", "pankaj");
	map.put("projectName", "swiggy");
	map.put("status", "completed");
	map.put("teamSize", 10);
	
	//request specification
	given()
	.contentType(ContentType.JSON)
	.body(map)
	
	
	//actual request
	.when()
	.post("http://localhost:8084/addProject")
	
	//validation
	.then()
	.assertThat()
	.statusCode(201)
	.contentType(ContentType.JSON)
	.log().all();

}
}
