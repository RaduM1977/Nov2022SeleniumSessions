package seleniumSessions.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import seleniumSessions.utils.ElementUtil;

public class LocatorConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		// In Selenium --> all the elements on the web page are called WebElements
		
		
		//Create a WebElement + perform action(click,sendKeys,getText,isDisplay...) -->it is a 2 steps process
		
		// Create a WebElemenr: need a locator
		
		//DOM ---> Document Object Model
		/*
		 <input --> html tag
		 <type ="submit"
		 img src = "path" --> atrubute and value
		 a href = "http//
		 */
		driver = new ChromeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//8 locators(methods) in the By class to find the web element
		
		//1. id locator:
		
		//1st
//		driver.findElement(By.id("input-email")).sendKeys("naveen@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("naveen@123");
		
		//2nd
//		WebElement emailId = driver.findElement(By.id("input-email"));
//		WebElement password = driver.findElement(By.id("input-password"));
//		
//		emailId.sendKeys("naveen@gmail.com");
//		password.sendKeys("naveen@123");
//		
		
		//3rd --> By locator
		//object repository
//		By emailId = By.id("input-email"); --> object repository
//		By password = By.id("input-password"); --> object repository
//		
//		WebElement eId = driver.findElement(emailId);
//		WebElement pwd = driver.findElement(password);		
//		
//		eId.sendKeys("naveen@gmail.com");
//		pwd.sendKeys("naveen@123");

		
		//4th --> By locator + generic method() for WebElement 
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		getElement(emailId).sendKeys("naveen@gmail.com");
//		getElement(password).sendKeys("naveen@123");
		
		//5th --> By locator + generic methods() for WebElement and actions
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		
//		doSendKeys(emailId,"naveen@gmail.com");
//		doSendKeys(password,"naveen@123");
		
		//6th: By locator + generic methods() for WebElement and actions in a ElementUtil class
		By emailId = By.id("input-email");
		By password = By.id("input-password");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(emailId, "naveen@gmail.com");
		eleUtil.doSendKeys(password, "naveen@123");
		
		//Homework : practice on a different webPage all those 6 approaches 
		
		driver.get("http://demo.sentrifugo.com/index.php/index");
		
		//1st 
//		driver.findElement(By.id("username")).sendKeys("naveen@gmail.com");
//		driver.findElement(By.id("password")).sendKeys("naveen@123");
		
		//2nd
//		WebElement userId = driver.findElement(By.id("username"));
//		WebElement userPassword = driver.findElement(By.id("password"));
//		
//		userId.sendKeys("naveen@gmail.com");
//		userPassword.sendKeys("naveen@123");
	
		//3rd -by locator 
//		By user = By.id("username");
//		By userPass = By.id("password");
//		
//		
//		WebElement eUser = driver.findElement(user);
//		WebElement eUserPassword = driver.findElement(userPass);
//		
//		eUser.sendKeys("naveen@gmail.com");
//		eUserPassword.sendKeys("naven@123");
		
		//4th locator and method for webElement 
//		By user = By.id("username");
//		By userPass = By.id("password");
//		
//		getElement(user).sendKeys("naveen@gmail.com");
//		getElement(userPass).sendKeys("naven@123");
		
		//5th locator and methods for WebElement and for action
//		By user = By.id("username");
//		By userPass = By.id("password");
//		
//		doSendKeys(user,"naveen@gmail.com");
//		doSendKeys(userPass,"naven@123");
		
		//6th locator + methods from ElementUtil class
		By user = By.id("username");
		By userPass = By.id("password");
		
		ElementUtil element = new ElementUtil(driver);
		element.doSendKeys(user, "naveen@gmail.com");
		element.doSendKeys(userPass, "naveen@123");

		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}	
	
	public static void doSendKeys(By locator,String value) {
		getElement(locator).sendKeys(value);
	}
	
	
	

}
