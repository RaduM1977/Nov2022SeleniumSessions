package testNgSessions;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class RegistrationPageTest {
	
	public WebDriver driver;
	
	public boolean doRegister(String fn,String ln,String email,String phone,String password ) {
		
		driver.findElement(By.id("input-firstname")).clear();
		driver.findElement(By.id("input-firstname")).sendKeys(fn);
		
		driver.findElement(By.id("input-lastname")).clear();
		driver.findElement(By.id("input-lastname")).sendKeys(ln);
		
		
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(email);
		
		driver.findElement(By.id("input-telephone")).clear();
		driver.findElement(By.id("input-telephone")).sendKeys(phone);
		
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(password);
		
		driver.findElement(By.id("input-confirm")).clear();
		driver.findElement(By.id("input-confirm")).sendKeys(password);
		
		driver.findElement(By.name("agree")).click();
		
		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		
		
		
		
		String confirmationMessage =
				driver.findElement(By.tagName("h1")).getText();
		
		if(confirmationMessage.contains("Your Account Has Been Created!")) {
			return true;
		}
		return false;
	}
	
	
	// for multiple data we use data providers
	@DataProvider
	public Object[][] getRegTestData(){ //[3][5]
		
		int random = ThreadLocalRandom.current().nextInt();
		return new Object [][]{
			
			{"Gigel","Becali","becali"+random+"@gmail.com","12312312","gigi@"+random+""},
			{"Marinel","Dragnea","marinel"+random+"@gmail.com","1239897","marinel@"+random+""},
			{"Aurel","Boga","aurel"+random+"@gmail.com","12312312","aurel@"+random+""},
		};
	}
	
	//test
	@Test(dataProvider = "getRegTestData",priority = 2)
	public void registerTest(String fn, String ln,String email,String phone, String password) {
		System.out.println(fn+ln+email+phone+password);
		Assert.assertTrue(doRegister(fn,ln,email,phone,password));
	}
	
	
	//before and after method 
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
