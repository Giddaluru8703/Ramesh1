
package SeleniumConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookLogin {

	String url = "https://www.facebook.com/create/";

	@Test

	public void Demo_Login() throws InterruptedException {
		// OPEN BROWSER 
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		Thread.sleep(3000);
		driver.manage().window().maximize();
	
		driver.findElement (By.xpath ("//*[contains(text(),'Create new account')]")).click();
		driver.findElement (By.xpath ("//input[@name='firstname']")).sendKeys("GRS");
		
		
		driver.findElement (By.xpath ("//input[@name='lastname']")).sendKeys("Babu");
		driver.findElement (By.xpath ("//input[@name='reg_email__']")).sendKeys("GRS_99@gmail.com");
		
		 Select list = new Select(driver.findElement (By.xpath ("//select[@id='month']")));

		 List<WebElement> dropdown_list = list.getOptions();

		 for (int i = 0; i < dropdown_list.size(); i++) {

		   String dropdown_value = dropdown_list.get(i).getText();

		   System.out.println("dropdown values are " + dropdown_value);

		 }
		
	}
}
