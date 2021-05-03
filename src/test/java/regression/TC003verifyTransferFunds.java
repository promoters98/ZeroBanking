package regression;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC003verifyTransferFunds {
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
	public void transferFunds() {
		driver.findElement(By.id("signin_button")).click();
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.id("user_password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
		// user is transferring $100 funds from savings account to checking account
		driver.findElement(By.cssSelector("li[id='transfer_funds_tab']")).click();
		driver.findElement(By.id("tf_fromAccountId")).click();

		WebElement transferFrom = driver.findElement(By.id("tf_fromAccountId"));
		Select s = new Select(transferFrom);
		s.selectByIndex(2);

		WebElement transferTo = driver.findElement(By.id("tf_toAccountId"));
		Select t = new Select(transferTo);
		t.selectByIndex(1);
		
		driver.findElement(By.id("tf_amount")).sendKeys("100");
		driver.findElement(By.id("tf_description")).sendKeys("transfer $100 from Savings to Checking account");
		driver.findElement(By.id("btn_submit")).click();
		driver.findElement(By.id("btn_submit")).click();
		String transferSuccessMessage = driver.findElement(By.cssSelector("div[class='alert alert-success']")).getText();
		System.out.println("Transfer Success Message: " + transferSuccessMessage.trim());
	}

	@AfterMethod
	public void logOut() {
		// user is logging out
		driver.findElement(By.className("icon-user")).click();
		driver.findElement(By.id("logout_link")).click();
		driver.quit();
	}

}
