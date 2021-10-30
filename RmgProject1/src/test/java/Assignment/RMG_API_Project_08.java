package Assignment;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class RMG_API_Project_08 {
	
@Test
	
	public void createtheprojectwithkeyValuePairform() {


	HashMap map = new HashMap();
	{
		map.put ("createdBy", "sanjeeb");
		map.put ( "createdOn", "29/10/2021");
		map.put("projectId", "RMG_Project_11");
		map.put("projectName", "rag");
		map.put("status", "completed1");
		map.put ( "teamSize", 66);
	

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
