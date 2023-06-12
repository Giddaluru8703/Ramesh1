package testngConcepts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertExample {
	@Test
	public void testCase1(){
		int Expstatus=200;
		int Actstatus=404; // REST api 
		
		System.out.println("A");
		try{
		Assert.assertEquals(Actstatus, Expstatus);
		}catch(Throwable t){
			System.out.println(t.getMessage());
		}
		System.out.println("B");
	}
	
}
