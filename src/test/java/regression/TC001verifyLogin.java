package regression;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC001verifyLogin {
	ExtentReports report;
	ExtentTest test;

	@Test
	public void verifyLogin() {

		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\driver\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		report = new ExtentReports("C:\\Users\\ghaur\\eclipse-workspace\\hastycart\\report1.html");
		test = report.startTest("VERIFY SIGNIN PAGE");
		String homePageUrl = "http://zero.webappsecurity.com/";
		driver.get(homePageUrl);
		test.log(LogStatus.INFO, "home page is opened");
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "window is maximized");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement signInButton = driver.findElement(By.id("signin_button"));
		signInButton.click();
		test.log(LogStatus.INFO, "Sign in button is clicked");
		driver.quit();
		report.endTest(test);
		report.flush();
	
	}

}
