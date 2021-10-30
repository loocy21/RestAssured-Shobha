package Assignment;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class RMG_API_Project_10 {
	
@Test
	
	public void CreatetheprojectWithStatusOngoing() {


	HashMap map = new HashMap();
	{
		map.put ("createdBy", "rmg");
		map.put ( "createdOn", "1/11/2021");
		map.put("projectId", "02");
		map.put("projectName", "zomato");
		map.put("status", "comleted");
		map.put ( "teamSize", 1);

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
