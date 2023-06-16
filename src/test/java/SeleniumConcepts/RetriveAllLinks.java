package SeleniumConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RetriveAllLinks {
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

		driver.get("https://www.opencart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Retrive all links
		// List<WebElement> li = driver.findElements(By.xpath("//a"));
		List<WebElement> li = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links=" + li.size());

		for (int i = 0; i < li.size(); i++) {
			if (!li.get(i).getText().isEmpty())
				System.out.println(li.get(i).getText());
		}

	}

}
