package googleMapAPI;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class AddPlace {
	
	//given() ---> input data--->queryparameter, headers,body
	//when()---> httprequest,resource
	//Then()---> adding assertions and view results
	
	@Test
	public void addplace(){
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		RestAssured.given().log().all().queryParam("key", "qaclick123")
		                               .header("Content-Type","application/json")
		                               .body(PayLoadMethods.payLoadForAddplace())
		                             
		                   .when().post("/maps/api/place/add/json")
		                   .then().log().all().assertThat().statusCode(200)
		                   .body("status", Matchers.equalTo("OK"))
		                   .body("scope", Matchers.equalTo("APP"))
		                   .header("Server", "Apache/2.4.41 (Ubuntu)");


		                               
		
	}

}
