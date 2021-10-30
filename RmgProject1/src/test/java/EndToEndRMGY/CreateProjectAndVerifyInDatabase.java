package EndToEndRMGY;


import org.testng.annotations.Test;

import com.POJO.Class.ProjectLibrary;

import GenricUtils.BaseAPIClass;
import GenricUtils.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class CreateProjectAndVerifyInDatabase extends BaseAPIClass {
	
	@Test
	
	public void createprojectAndVarifyIndatabase() throws Throwable
	{
		//create a project throw API 
		ProjectLibrary pLib = new ProjectLibrary("shobha","Firefox "+jLib.getRandomNumber(), "Created",45);
		
				Response res = given()
				.contentType(ContentType.JSON)
				.body(pLib)
				.when()
				.post(EndPoints.addProject);
				
				res.then().log().all();
				
				
				//capture the expected data
				String expData = rLib.getJsonData(res,"projectName");
				System.out.println(expData);
				
				//varify it in database
				String query = "select * from project";
				String actData = dLib.executeQueryAndGetData(query,4, expData);
				
				
				//validate
				Assert.assertEquals(actData, expData);
				System.out.println("sucessful");
				
				
		
		
	}

}
