package SeleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SelectDemo {
	WebDriver driver;
	String Browser = "chrome";

	@Test
	public void testCase1() throws Throwable {
		SoftAssert st = new SoftAssert();
		if (Browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver(); // openBrowser
		else if (Browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if (Browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();

		driver.get("https://www.timesjobs.com/candidate/register.html?pageFlow=TJ_HOME");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// select
		WebElement sel = driver.findElement(By.id("curLocation"));

		Select s = new Select(sel);
		// s.selectByIndex(10);
		 s.selectByValue("198663");
		//s.selectByVisibleText("Chennai");

		driver.findElement(By.id("curLocation")).sendKeys("Delhi");

	}

}
