package SeleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AlertDemo {
	WebDriver driver;
	String Browser = "edge";

	@Test
	public void testCase1() throws Throwable {
		SoftAssert st = new SoftAssert();
		if (Browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver(); // openBrowser
		else if (Browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if (Browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// click on signin
		driver.findElement(By.name("proceed")).click();
		// Alert
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert text=" + alert.getText());
		st.assertEquals(alert.getText(), "Please enter a valid user name for rediff");
		alert.accept(); // ok button
		// alert.dismiss(); //cancel button
		driver.findElement(By.id("login1")).sendKeys("tester");

		st.assertAll();
	}

}
