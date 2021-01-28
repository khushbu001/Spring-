package com.demo.registration.RegistrationForm;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegistrationFormApplicationTests {
	/**
	 * 
	 */
	@Test
	public void checkUsersInfo() {
		RestAssured.baseURI = "http://localhost:9000";
		// request object
		RequestSpecification httpRequest = RestAssured.given();

		// Response object
		Response response = httpRequest.request(Method.GET, "/users");
		String responceBody = response.getBody().asString();

		// validation code
		Assert.assertTrue(responceBody.contains("firstName"));
		Assert.assertTrue(responceBody.contains("lastName"));
		Assert.assertTrue(responceBody.contains("email"));
		Assert.assertTrue(responceBody.contains("password"));
		Assert.assertTrue(responceBody.contains("contact"));

		JsonPath jsonPathEvaluator = response.jsonPath();

		String firstName = jsonPathEvaluator.get("firstName");

		// Validate if the specific JSON element is equal to expected value
		Assert.assertTrue(firstName.equalsIgnoreCase("khushbu"));

		String s = response.getContentType();
		System.out.println(s);
		int code = response.getStatusCode();
		assertEquals(200, code);

		Headers allHeaders = response.headers();
		for (Header header : allHeaders) {
			System.out.println(header.getName() + " " + header.getValue());
		}
	}

}
//Making post request with authentication or leave blank if you don't have credentials like: basic("","")
//Response response = given().authentication().preemptive().basic({username}, {password})
//.spec(requestSpec).when().post(restAPIUrl);