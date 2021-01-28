package com.demo.registration.RegistrationForm;

import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * 
 * @author khushii
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UniqueEmail {
	@Test
	public void addUser() {
		// request object
		RestAssured.baseURI = "http://localhost:9000";

		RequestSpecification httpPostRequest = RestAssured.given();

		// header-type
		httpPostRequest.header("Content-Type", "application/json");
		Response postResponce = httpPostRequest.request(Method.GET, "/users");

		// print responce in console window
		String responceBody = postResponce.getBody().asString();
		System.out.println("responce body is" + responceBody);

		// validation
		int statusCode = postResponce.getStatusCode();
		System.out.println(statusCode);
		assertEquals(201, statusCode);

	}
	

 
}