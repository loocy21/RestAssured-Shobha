package Assignment;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class RMG_API_Project_11 {
	
@Test
	
	public void CreatetheprojectWithStatusCompleted() {


	HashMap map = new HashMap();
	{
		map.put ("createdBy", "rmg");
		map.put ( "createdOn", "02/06/2021");
		map.put("projectId", "04");
		map.put("projectName", "ola");
		map.put("status", "created");
		map.put ( "teamSize", 99);

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
