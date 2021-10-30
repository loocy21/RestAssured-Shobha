package Assignment;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class RMG_API_Project_09 {
	
@Test
	
	public void CreatetheprojectWithStatusCreated() {


	HashMap map = new HashMap();
	{
		map.put ("createdBy", "rmg");
		map.put ( "createdOn", "31/10/2021");
		map.put("projectId", "RMG_Project_13");
		map.put("projectName", "byjus");
		map.put("status", "completed2");
		map.put ( "teamSize", 11);

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
}
