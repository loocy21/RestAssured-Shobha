package ParametersAndAuthantication;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class PathParameter {
	@Test
	
	public void pathParameter()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		given()
		.pathParams("projID", "TY_PROJ_404")
		
		.when()
		.get("/projects/{projID}")
		
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
		
		
	}

}
