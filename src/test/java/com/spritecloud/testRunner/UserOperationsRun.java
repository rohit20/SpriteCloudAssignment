package com.spritecloud.testRunner;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.mortbay.log.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;


import static io.restassured.RestAssured.*;

public class UserOperationsRun {

//	Verify user is able to create new user
	@Test(priority = 1)
	public void createUser() {
		Map<String, Object>map = new HashMap<String,Object>();
		map.put("id", 1000);
		map.put("username", "rohit");
		map.put("firstName", "Mr");
		map.put("lastName", "Wadhwa");
		map.put("email", "rohit@gmail.com");
		map.put("password", "123@");
		map.put("phone", 1253682901);
		map.put("userStatus", 1);

		System.out.print(map);

		JSONObject request = new JSONObject(map);

		given().
		header("Content-Type", "application/json").
		contentType(ContentType.JSON).
		header("accept", "application/json").
		body(request.toJSONString()).
		when().
		post("https://petstore.swagger.io/v2/user").
		then().
		statusCode(200). 	
		log().body();
		Log.info("User is created");
	}
	
//	Verify user is able to get details

	@Test(priority = 2)
	public void getUser01() {
		Response response = get("https://petstore.swagger.io/v2/user/rohit");
		int statusCode = response.getStatusCode();
		System.out.println(response.getBody().asString());
		System.out.println(statusCode);
		System.out.println(response.asString());
		System.out.println(response.getTime());
		System.out.println(response.getHeaders());
		System.out.println(response.getHeader("accept"));
		System.out.println(response.getHeader("content-type"));
		Assert.assertEquals(statusCode, 200);


	}
//	Verify user is able to get details2
	@Test(priority=3)
	public void getUser02() {
		given().
		header("content-type","application/json").
		header("accept","application/json").
		get("https://petstore.swagger.io/v2/user/rohit").
		then().
		statusCode(200).
		body("id", equalTo(1000)).
		body("firstName", equalTo("Mr")).
		log().all();
	}
//	Verify user is able to update user details
	@Test(priority=4)
	public void updateUser() {
		Map<String, Object>map = new HashMap<String,Object>();
		map.put("id", 1000);
		map.put("username", "rohit");
		map.put("firstName", "Mr new");
		map.put("lastName", "Wadhwa2");
		map.put("email", "rohi2t@gmail.com");
		map.put("password", "123@");
		map.put("phone", 1253682901);
		map.put("userStatus", 1);

		System.out.print(map);

		JSONObject request = new JSONObject(map);	
		given().
		header("Content-Type", "application/json").
		contentType(ContentType.JSON).
		header("accept", "application/json").
		body(request.toJSONString()).
		when().
		put("https://petstore.swagger.io/v2/user/rohit").
		then().
		statusCode(200). 	
		log().body();
		Log.info("User is Updated");
	}

//	Verify user is able to delete user 
	@Test (priority=5)	
	public void deleteUser() { 
		Response response =delete("https://petstore.swagger.io/v2/user/rohit"); 
		int statusCode =response.getStatusCode(); 
		Assert.assertEquals(statusCode, 200);
		System.out.println(response.getBody().asString());		
		System.out.println(statusCode); System.out.println(response.asString());
		System.out.println(response.getTime());
		System.out.println(response.getHeaders());
		System.out.println(response.getHeader("accept"));
		System.out.println(response.getHeader("content-type"));
		Response res = get("https://petstore.swagger.io/v2/user/rohit");
		statusCode=res.getStatusCode(); 
		Assert.assertEquals(statusCode, 404);
	}

}
