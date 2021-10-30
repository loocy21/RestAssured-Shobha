package Assignment;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class RMG_API_Project_12 {
	
@Test
	
	public void updatetheproject() {


	HashMap map = new HashMap();
	{
		map.put ("createdBy", "rmg");
		map.put ( "createdOn", "08/06/2021");
		map.put("projectId", "06");
		map.put("projectName", "ola");
		map.put("status", "completed");
		map.put ( "teamSize", 133);

	//request specification
	given()
	.contentType(ContentType.JSON)
	.body(map)
	
	
	//actual request
	.when()
	.put("http://localhost:8084/projects/RMG_Project_02")
	
	//validation
	.then()
	.assertThat()
	.statusCode(200)
	.contentType(ContentType.JSON)
	.log().all();


	
	

}
}
}
