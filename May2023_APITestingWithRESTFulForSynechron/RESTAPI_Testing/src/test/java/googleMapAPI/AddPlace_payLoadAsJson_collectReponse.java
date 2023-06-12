package googleMapAPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class AddPlace_payLoadAsJson_collectReponse {
	
	//given() ---> input data--->queryparameter, headers,body
	//when()---> httprequest,resource
	//Then()---> adding assertions and view results
	
	@Test
	public void addplace() throws Throwable{
		System.out.println("--------------------------------------AddPlace----------------------------------------------");
		SoftAssert st=new SoftAssert();
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		String response = RestAssured.given().log().all().queryParam("key", "qaclick123")
		                               .header("Content-Type","application/json")
		                               .body(new String(Files.readAllBytes(Paths.get("Input.json"))))
		                             
		                   .when().post("/maps/api/place/add/json")
		                   .then().log().all().assertThat().statusCode(200)
		                   .body("status", Matchers.equalTo("OK"))
		                   .body("scope", Matchers.equalTo("APP"))
		                   .header("Server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();

		System.out.println(response);
		JsonPath js = new JsonPath(response) ;   
		String status = js.getString("status");
		st.assertEquals(status, "OK");
		String place_id = js.getString("place_id");
		System.out.println("place id ="+place_id);
		
		
		System.out.println("--------------------------------------GetplaceInfo----------------------------------------------");
		
		RestAssured.given().log().body().queryParam("key", "qaclick123")
		.queryParam("place_id", place_id)
		.when().get("/maps/api/place/get/json")
		.then().log().body().assertThat().statusCode(200);
		
		System.out.println("-------------------------------------updateplace----------------------------------------------");
		
		RestAssured.given().log().body().queryParam("key", "qaclick123")
		                                                  .header("Content-Type","application/json")
		                                                  .body("{\r\n" + 
		                                                  		"\"place_id\":\""+place_id+"\",\r\n" + 
		                                                  		"\"address\":\"88, jayanagar Bangalore\",\r\n" + 
		                                                  		"\"key\":\"qaclick123\"\r\n" + 
		                                                  		"}\r\n" + 
		                                                  		"")
		                                                  .when().put("/maps/api/place/update/json")
		                                                  .then().log().body().assertThat().body("msg", Matchers.equalTo("Address successfully updated"))
		                                                  .statusCode(200);
		

		System.out.println("--------------------------------------GetplaceInfo----------------------------------------------");
		
		RestAssured.given().log().body().queryParam("key", "qaclick123")
		.queryParam("place_id", place_id)
		.when().get("/maps/api/place/get/json")
		.then().log().body().assertThat().statusCode(200);
		
		System.out.println("--------------------------------------Deleteplace----------------------------------------------");
		
		RestAssured.given().log().body().queryParam("key", "qaclick123").headers("Content-Type","application/json")
		.body("{\r\n" + 
				"    \"place_id\":\""+place_id+"\"\r\n" + 
				"}\r\n" + 
				"")
		.when().delete("/maps/api/place/delete/json")
		.then().log().all().assertThat().body("status", Matchers.equalTo("OK"));
		
System.out.println("--------------------------------------GetplaceInfo----------------------------------------------");
		
		RestAssured.given().log().body().queryParam("key", "qaclick123")
		.queryParam("place_id", place_id)
		.when().get("/maps/api/place/get/json")
		.then().log().body().assertThat().statusCode(200);
		st.assertAll();
	}

}//hot key to collect return type--->ctrl+1+Enter
