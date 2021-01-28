package com.demo.registration.RegistrationForm;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * 
 * @author khushii
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Firstname {

	@Test
	public void firstName() {
		// base uri for every api
		RestAssured.baseURI = "http://localhost:9000";

		// sending a request
		RequestSpecification httpGetRequest = RestAssured.given();

		// Recieving the responce
		Response response = httpGetRequest.request(Method.GET, "/users");

		// validation code using soft assert
		SoftAssert softAssert = new SoftAssert();
		JsonPath jsonPath = response.getBody().jsonPath();
		System.out.println("json path finder" + jsonPath);

	}
}
