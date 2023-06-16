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

public class AutoSuggestElement {
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

		driver.get("https://www.yahoo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Enter bang in search box
		driver.findElement(By.id("ybar-sbq")).sendKeys("bang");
		// Auto suggestion
		List<WebElement> li = driver.findElements(By.xpath("//*[@id=\"ybar-sf\"]/div[1]/div/div/ul/li/span[1]"));
		for (WebElement x : li) {
			// System.out.println(x.getText());
			if (x.getText().equalsIgnoreCase("Bangkok Airways")) {
				x.click();
				break;
			}
		}
	}

}
