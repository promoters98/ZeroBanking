package datadriventesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC001verifyLogin {

	@Test (dataProvider = "logindata")
	public void verifyLogin (String uname, String pword) {

		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\driver\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String homePageUrl = "http://zero.webappsecurity.com/";
		driver.get(homePageUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		driver.findElement(By.id("signin_button")).click();
		driver.findElement(By.id("user_login")).sendKeys(uname);
		driver.findElement(By.id("user_password")).sendKeys(pword);
		driver.findElement(By.name("submit")).click();
		driver.getCurrentUrl();
		String expectedURL = "http://zero.webappsecurity.com/bank/account-summary.html";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(expectedURL, actualURL);
		driver.quit();
		
	}
	
		@DataProvider(name="logindata")
		public Object[][] passdata(){
		//create 2D array name data with 3 rows and 2 column
		Object[][] data = new Object[3][2];
		//we have input data 	
		data[0][0]="username";
		data[0][1]="password";
		
		data[1][0]="manager";
		data[1][1]="password1";	
		
		data[2][0]="admin";
		data[2][1]="password1";
		return data;
		}

}
