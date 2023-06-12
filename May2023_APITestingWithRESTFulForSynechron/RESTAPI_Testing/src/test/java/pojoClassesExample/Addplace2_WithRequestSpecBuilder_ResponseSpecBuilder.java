package pojoClassesExample;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;

@Test
public class Addplace2_WithRequestSpecBuilder_ResponseSpecBuilder {
	public void addplace() throws Throwable{
		System.out.println("--------------------------------------AddPlace----------------------------------------------");
		SoftAssert st=new SoftAssert();
		
		Pojoclass2 pcr=new Pojoclass2();
		Location l=new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		pcr.setLocation(l);
		pcr.setAccuracy(50);
		pcr.setName("SKN Tech Solutions");
		pcr.setPhone_number("9972278770");
		pcr.setAddress("88,jayanagar ,Bangalore");
		ArrayList<String> ar=new ArrayList<String>();
		ar.add("IT solution");
		ar.add("Service providers");
		pcr.setTypes(ar);
		pcr.setWebsite("SKNtechsolutios.org");
		pcr.setLanguage("English");
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
	Pojoclass1 pc = RestAssured.given().log().all().queryParam("key", "qaclick123")
		                               .header("Content-Type","application/json")
		                               .body(pcr)
		                             
		                   .when().post("/maps/api/place/add/json")
		                   .then().log().all().assertThat().statusCode(200)
		                   .body("status", Matchers.equalTo("OK"))
		                   .body("scope", Matchers.equalTo("APP"))
		                   .header("Server", "Apache/2.4.41 (Ubuntu)").extract().response().as(Pojoclass1.class);
	
	String place_id = pc.getPlace_id();
	String scope = pc.getScope();
	String reference = pc.getReference();
	String id = pc.getId();
	String status = pc.getStatus();
	System.out.println(scope);
	System.out.println(reference);
	System.out.println(id);
	System.out.println(status);
	System.out.println(place_id);

}
}