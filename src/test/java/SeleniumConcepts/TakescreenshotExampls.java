package SeleniumConcepts;

import java.io.File;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.assertthat.selenium_shutterbug.core.Shutterbug;

public class TakescreenshotExampls {
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

		// TakescreenShot

		// File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// FileHandler.copy(f, new File("Testpic.png"));
		// Shutterbug.shootPage(driver).withName("TestpicWiths").save();
		// Shutterbug.shootPage(driver, Capture.FULL).withName("Fullscreen").save();
		WebElement logo = driver.findElement(By.xpath("/html/body/header/a[2]/img"));
		// Shutterbug.shootElement(driver, logo).withName("ExpLogo").save();
		boolean results = Shutterbug.shootElement(driver, logo)
				.equals(ImageIO.read(new File("screenshots\\ExpLogo.png")));
		st.assertEquals(results, true);

		st.assertAll();
	}

}
