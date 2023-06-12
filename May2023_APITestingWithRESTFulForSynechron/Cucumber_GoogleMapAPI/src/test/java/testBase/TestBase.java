package testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import payLoads.PayLoad;
import pojoClasses.AddPlace_RequestPojo;

public class TestBase extends PayLoad{

	
	public static void setUp() throws Throwable{
		prop=new Properties();
		prop.load(new FileInputStream("src\\test\\java\\config\\Global.properties"));
		log=new PrintStream(new FileOutputStream("src\\test\\java\\logFiles\\Logging.txt"));
		
		 req = new RequestSpecBuilder().setBaseUri(prop.getProperty("baseuri"))
		                                          .addQueryParam("key", prop.getProperty("key"))
		                                          .setContentType(ContentType.JSON)
		                                          .addFilter(RequestLoggingFilter.logRequestTo(log))
		                                          .addFilter(ResponseLoggingFilter.logResponseTo(log))
		                                          .build();
	}
	
	public static void tearDown(){
		 res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	}
}
