package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class TestsOnLocalAPI {
	
	//@Test()
	public void get() {
		
		baseURI = "http://localhost:3000";
		
		given().
		  get("/users").
		then().
		  statusCode(200).
		  log().all();	
	}
	
	
	@Test()
	public void Post() {
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Rajendra");
		request.put("lastName", "Patel");
		request.put("SubjectId", "1");
		
		baseURI = "http://localhost:3000";
		
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		   body(request.toJSONString()).
		when().
		   post("/users").
		then().
		   statusCode(201);

	}

}
