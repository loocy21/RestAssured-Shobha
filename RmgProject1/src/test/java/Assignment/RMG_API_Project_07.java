package Assignment;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class RMG_API_Project_07 {
	
@Test
	
	public void createtheprojectwithJsonFile() {


	HashMap map = new HashMap();
	{
		map.put ("createdBy", "shobha");
		map.put ( "createdOn", "28/10/2021");
		map.put("projectId", "RMG_Project_02");
		map.put("projectName", "rmgProject");
		map.put("status", "completed");
		map.put ( "teamSize", 33);
	

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
