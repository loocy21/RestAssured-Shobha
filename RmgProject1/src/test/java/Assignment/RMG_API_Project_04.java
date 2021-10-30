package Assignment;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class RMG_API_Project_04 {
	
@Test
	
	public void createtheprojectwithXMLFormate() {


	HashMap map = new HashMap();
	{
		map.put ("createdBy", "rmg");
		map.put ( "createdOn", "28/10/2021");
		map.put("projectId", "RMG_Project_01");
		map.put("projectName", "rmgProject");
		map.put("status", "created");
		map.put ( "teamSize", 10);
	

	//request specification
	given()
	.contentType(ContentType.XML)
	.body(map)
	
	
	//actual request
	.when()
	.post("http://localhost:8084/addProject")
	
	//validation
	.then()
	.assertThat()
	.statusCode(201)
	.contentType(ContentType.TEXT)
	.log().all();

}
}
}
