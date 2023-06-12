package jsonParsingExample;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;

public class JsonParsingExample {

	@Test
	public void jsonParsing(){
		SoftAssert st=new SoftAssert();
		JsonPath js = new JsonPath(Files.JsonFile());
		
		//1. print number of courses returned by API
		int size = js.getInt("courses.size()");
		System.out.println("Total courses return by api="+size);
		st.assertEquals(size, 3,"comparing total number of courses returned by api");
		
		//2. print purchase amount
		int totalpurchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println("Total purchase amount ="+totalpurchaseAmount);
		st.assertEquals(totalpurchaseAmount, 910);
		st.assertAll();
		
		//3. print title of first course
		String firstcourse = js.getString("courses[0].title");
		System.out.println("First course title="+firstcourse);
		
		//4. print all courses title and their respective prices
		System.out.println("--------------- print all courses title and their respective prices--------------------");
		for(int i=0;i<js.getInt("courses.size()");i++){
			System.out.println("Title="+js.getString("courses["+i+"].title")+"==="+"price="+js.getInt("courses["+i+"].price"));
		}
		//5. print number of copies sold by RPA courses
		int totalcopies_rpa_sold = js.getInt("courses[2].copies");
		System.out.println("Number of copies sold by RPA courses="+totalcopies_rpa_sold);
		
		//6.verify if sum of all course price matches with purchase amount
		System.out.println("--------verify if sum of all course price matches with purchase amount-------------");
		int ActualTotalpurchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println("Actual total amount displayed ="+ActualTotalpurchaseAmount);
		
		int Total=0;
		for(int j=0;j<js.getInt("courses.size()");j++){
			Total=Total+(js.getInt("courses["+j+"].price") *js.getInt("courses["+j+"].copies") );
		}
		System.out.println("Total amount after addition="+Total);
		
		if(Total ==ActualTotalpurchaseAmount){
			System.out.println("Total price displayed is correct");
		}else {
			System.out.println("Total price displayed is not  correct");
		}
	}
}
