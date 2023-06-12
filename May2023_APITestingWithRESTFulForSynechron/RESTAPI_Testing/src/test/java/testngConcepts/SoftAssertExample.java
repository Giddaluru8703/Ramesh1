package testngConcepts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertExample {

	@Test
	public void testCase1(){
		SoftAssert st=new SoftAssert();
		int Expstatus=200;
		int Actstatus=404; // REST api 
		
		System.out.println("A");
		st.assertEquals(Actstatus, Expstatus,"comparing status code for post api request");
		System.out.println("B");
		
		
		st.assertAll();
		System.out.println("C");
}
}