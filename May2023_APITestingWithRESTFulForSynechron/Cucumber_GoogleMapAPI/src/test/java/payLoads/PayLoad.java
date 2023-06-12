package payLoads;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Properties;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojoClasses.AddPlace_RequestPojo;
import pojoClasses.Location;
import testBase.TestBase;

public class PayLoad {
	public static PrintStream log;
	public static Properties prop;
	public static RequestSpecification req;
	public static ResponseSpecification res;
	public static AddPlace_RequestPojo pcr;
	public static RequestSpecification given_requestspecification;
	public static Response when_response;
	public static ValidatableResponse then_validationspec;
	
	public static void addPlacePayLoad(){
		 pcr=new AddPlace_RequestPojo();
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
		
	}
}
