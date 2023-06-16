package SeleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Tolltipmsg {

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

		driver.get("https://www.drikpanchang.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Tooltipmsg
		String tooltipmsg = driver.findElement(By.xpath("/html/body/div[3]/div[3]/a[1]/img")).getAttribute("alt");
		System.out.println("Tool tip msg=" + tooltipmsg);
	}
}
