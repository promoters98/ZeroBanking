package regression;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC002verifyAddPayee {
	WebDriver driver;

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\driver\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void login() {
		driver.findElement(By.id("signin_button")).click();
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.id("user_password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
		// user is adding payee
		driver.findElement(By.linkText("Pay Bills")).click();
		driver.findElement(By.linkText("Add New Payee")).click();
		driver.findElement(By.id("np_new_payee_name")).sendKeys("BusyQA");
		driver.findElement(By.id("np_new_payee_address")).sendKeys("Many addresses in GTA, ON A1A1A1");
		driver.findElement(By.id("np_new_payee_account")).sendKeys("010123012345");
		driver.findElement(By.id("np_new_payee_details")).sendKeys("This is a test payee");
		driver.findElement(By.id("add_new_payee")).click();
		String addPayeeText = driver.findElement(By.id("alert_content")).getText();
		System.out.println("Add New Payee Alert Text: " + addPayeeText);
		System.out.println("'BusyQA' is added as new payee");
	}

	@AfterMethod
	public void quitBrowser() {
		driver.quit();
	}
}
