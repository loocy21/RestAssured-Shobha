package CrudOpreationWithBDD;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class GetAllProject {
	
	@Test
	
	public void  GetAllProjects()
	{
		when()
		.get("http://localhost:8084/projects")
		
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
		
	}
	

}
