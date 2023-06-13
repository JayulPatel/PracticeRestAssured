package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GetAndPostExamples {

	
	
	//@Test()
	public void testGet() {
		
		baseURI = "https://reqres.in/api";
		given().
		  get("/users?page=2").
		then().
		  statusCode(200).
		body("data[3].first_name", equalTo("Byron")).
		body("data.first_name", hasItems("Byron", "Lindsay"));
		  //.log()
		  //.all();
			
	}
	
	@Test()
	public void testPost() {
		
		//Map<K, V> = Map<Key, Value>
		// TYPE 1
		
//		Map<String, Object> map =new HashMap<String, Object>();
//		
//		map.put("name", "Jayul");
//		map.put("sirname", "Patel");
//		map.put("job", "Engineer");
//		
//		System.out.println(map);

//		
//		JSONObject request = new JSONObject(map);
//		System.out.println(request.toJSONString());
		
		
		
		//TYPE 2
		Map<String, Object> map =new HashMap<String, Object>();
		
		JSONObject request = new JSONObject();
        request.put("name", "Jayul");
        request.put("sirname", "Patel");
        request.put("job", "Engineer");
		
		System.out.println(request.toJSONString());
		
		
		baseURI ="https://reqres.in/api";
		
		given().
		header("Content-Type","applicationn/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		   body(request.toJSONString()).
		when().
		   post("/users").
		then().
		   statusCode(201)
		   .log()
		   .all();
		
	}
}
