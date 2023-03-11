package testNgSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginPageNegativeTest {
	
	public WebDriver driver;
	
	
	
	
	public boolean doLogin(String userName, String password) {
		
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(userName);
		
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(password);
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String errorMessage =
				driver.findElement(By.cssSelector(".alert.alert-danger.alert-dismissible")).getText();
		
		if(errorMessage.contains("Warning: No match for E-Mail Address and/or Password.")) {
			return true;
		}
		return false;
	}
	
	
	
	
	//data driven approach --> data can be kept in the excel and with Apache poi we can retrive the data 
	@DataProvider
	public Object[][] getLoginNegativeData() {
		
		// TestNg understands only Object[][]
		return new Object[][] {//[4][2] 
			
			{"asada@gmail.com","tset@123"},
			{"ahjshje@mail.com","testnot@1234"},
			{"adasdad","testnot@1234"},
			{"asada@gmail.com","987gy"},
			
		};
		
	}
	
	// this is called parameterization of test cases 
	// for multiple data we use data providers
	@Test(dataProvider = "getLoginNegativeData", priority =1)
	public void loginTest(String userName, String password) { // the test will run 4 times 
		
		//Assert.assertTrue(doLogin("asada@ffsfdmsmafd","qwe2e2e234"));
		
		boolean flag = doLogin(userName,password);
		Assert.assertTrue(flag);
	}
	
	
	
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}
	
	@AfterMethod
	public void tearDown() {
//		driver.quit();
	}
	
	//HOMEWORK
	//search key and one a type of product  --> 2 columns search and the unit searching 

}
