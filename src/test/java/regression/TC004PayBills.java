package regression;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC004PayBills {

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
	public void payBills() {
		driver.findElement(By.id("signin_button")).click();
		// user is logging in
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.id("user_password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("Pay Bills")).click();

		WebElement selectPayee = driver.findElement(By.id("sp_payee"));
		Select s = new Select(selectPayee);
		s.selectByValue("sprint");

		WebElement fromAccount = driver.findElement(By.id("sp_account"));
		Select t = new Select(fromAccount);
		t.selectByIndex(2);

		driver.findElement(By.id("sp_amount")).sendKeys("25");
		driver.findElement(By.id("sp_date")).click();
		driver.findElement(By.linkText("25")).click();
		System.out.println("25th of August 2020 is selected as payment date");
		driver.findElement(By.id("sp_description")).sendKeys("Pay $25 to Sprint on 25th of August 2020");
		driver.findElement(By.id("pay_saved_payees")).click();
		String actualAlertMessage = driver.findElement(By.id("alert_content")).getText();
		String expectedAlertMessage = "The payment was successfully submitted.";
		Assert.assertEquals(expectedAlertMessage, actualAlertMessage);
		System.out.println("This text is displayed in notification: " + actualAlertMessage);
	}
	
	@AfterMethod
	public void logOut() {
		driver.findElement(By.className("icon-user")).click();
		driver.findElement(By.id("logout_link")).click();
		driver.quit();
	}
}
