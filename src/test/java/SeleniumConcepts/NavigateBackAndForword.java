package SeleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NavigateBackAndForword {
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

		driver.get("https://www.rediff.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		System.out.println("Home page Title =" + driver.getTitle());
		// click on signin
		driver.findElement(By.linkText("Sign in")).click();
		Thread.sleep(3000);
		System.out.println("Login page Title =" + driver.getTitle());
		// Login
		driver.navigate().back(); // home page
		Thread.sleep(3000);
		driver.navigate().forward(); // Login
		Thread.sleep(3000);
		driver.findElement(By.id("login1")).sendKeys("tester");
		Thread.sleep(3000);
		// driver.navigate().refresh();
		driver.get(driver.getCurrentUrl());

		driver.navigate().to("https://www.amazon.com/");
		driver.navigate().back();

//	driver.manage().deleteAllCookies();

		// Group commenting --->ctrl+shift+/
		// Group uncommenting --->ctrl+shift+\
	}

}
