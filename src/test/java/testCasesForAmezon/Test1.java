package testCasesForAmezon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test1 {
	WebDriver driver;
	String Browser = "edge";

	@Test
	public void Testcase1() {
		SoftAssert st = new SoftAssert();
		if (Browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver(); // openBrowser
		else if (Browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if (Browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// click on dontchange
		driver.findElement(By.xpath("//*[@id=\"nav-main\"]/div[1]/div/div/div[3]/span[1]/span/input")).click();
		// click on todaysdeal
		WebElement todaysdeal = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[1]"));
		todaysdeal.click();
		// select mens watches checkbox
		driver.findElement(By.xpath("//*[@id=\"grid-main-container\"]/div[2]/span[3]/ul/li[34]/label/input")).click();
		// Thread.sleep(5000);
		// click on first item
		driver.findElement(By.xpath("//*[@id=\"grid-main-container\"]/div[3]/div/div[1]/div/div/a/div/div/img"))
				.click();
		// click on first item in the sublist
		driver.findElement(By.xpath("//*[@id=\"octopus-dlp-asin-stream\"]/ul/li[1]/span/div/div[1]/a/div")).click();
		// click on add2cart
		driver.findElement(By.id("add-to-cart-button")).click();
		// verifysucessmsg
		try {
			String text = driver.findElement(By.xpath("//*[@id=\"NATC_SMART_WAGON_CONF_MSG_SUCCESS\"]/span")).getText();
			System.out.println("Actual text =" + text);
			st.assertEquals(text, "Added to Cart");
		} catch (Throwable t) {
			String text = driver.findElement(By.xpath("  //*[@id=\"attachDisplayAddBaseAlert\"]/div/h4")).getText();
			System.out.println("Actual text =" + text);
			st.assertEquals(text, "Added to Cart");
		}
		// closeBrowser
		driver.quit();
		st.assertAll();
		// driver.close(); //Current tab or window
	}

}
