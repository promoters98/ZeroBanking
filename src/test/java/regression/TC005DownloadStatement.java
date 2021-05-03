package regression;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TC005DownloadStatement {
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
	public void downloadStatement () {
		driver.findElement(By.id("signin_button")).click();
		// user is logging in
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.id("user_password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.id("online_statements_tab")).click();
		driver.findElement(By.cssSelector("a[href='/bank/online-statements-by-name.html?name=8534567-01-10-12.pdf']")).click();
		driver.navigate().to("chrome://downloads/");
		String bodyText = driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue(bodyText.contains("8534567-01-10-12.pdf"), "file not found");
	}

	@AfterMethod
	public void logOut() {
		driver.quit();
	}
}
