package datadriventesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC001verifyLoginReadFromExcel {

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
		public Object[][] passdata() throws IOException{
			// specify the file location
			File src = new File ("C:\\Users\\ghaur\\eclipse-workspace\\automationtesting\\src\\test\\resources\\exceldata\\testData.xlsx");
			//load the file
			FileInputStream fis = new FileInputStream(src);
			//load workbook from excel file
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			//loading the sheet 1
			XSSFSheet sheet = wb.getSheetAt(0);
			int rowCount = sheet.getLastRowNum();
			System.out.println(rowCount);
			
			int rows = rowCount + 1;
			System.out.println(rows);
			
			Object [][] data = new Object[rows][2];
			for (int i = 1; i <rows; i++) {
				data[i][0]=sheet.getRow(i).getCell(0).getStringCellValue();
				data[i][0]=sheet.getRow(i).getCell(1).getStringCellValue();
			}
			return data;
		}
}
