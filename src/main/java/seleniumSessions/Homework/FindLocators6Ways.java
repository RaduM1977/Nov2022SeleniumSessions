package seleniumSessions.Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seleniumSessions.utils.BrowserUtil;
import seleniumSessions.utils.ElementUtil;

public class FindLocators6Ways {
	
	static WebDriver driver;

	public static void main(String[] args) {

		String browserName = "chrome";

		// Homework : practice on a different webPage all those 6 approaches
		BrowserUtil browserUtil = new BrowserUtil();
		driver = browserUtil.initDriver(browserName);

		driver.get("http://demo.sentrifugo.com/index.php/index");

		// 1st
//		driver.findElement(By.id("username")).sendKeys("naveen@gmail.com");
//		driver.findElement(By.id("password")).sendKeys("naveen@123");

		// 2nd
//		WebElement userId = driver.findElement(By.id("username"));
//		WebElement userPassword = driver.findElement(By.id("password"));
//		
//		userId.sendKeys("naveen@gmail.com");
//		userPassword.sendKeys("naveen@123");

		// 3rd -by locator
//		By user = By.id("username");
//		By userPass = By.id("password");
//		
//		
//		WebElement eUser = driver.findElement(user);
//		WebElement eUserPassword = driver.findElement(userPass);
//		
//		eUser.sendKeys("naveen@gmail.com");
//		eUserPassword.sendKeys("naven@123");

		// 4th locator and method for webElement
//		By user = By.id("username");
//		By userPass = By.id("password");
//		
//		getElement(user).sendKeys("naveen@gmail.com");
//		getElement(userPass).sendKeys("naven@123");

		// 5th locator and methods for WebElement and for action
//		By user = By.id("username");
//		By userPass = By.id("password");
//
//		doSendKeys(user, "naveen@gmail.com");
//		doSendKeys(userPass, "naven@123");

		// 6th locator + methods from ElementUtil class
		By user = By.id("username");
		By userPass = By.id("password");

		ElementUtil element = new ElementUtil(driver);
		element.doSendKeys(user, "naveen@gmail.com");
		element.doSendKeys(userPass, "naveen@123");
		
		//browserUtil.closeBrowser();

	}
	
	public static WebElement getElement(By locator) {
		 return driver.findElement(locator);
	}
	
	public static void doSendKeys(By locator, String value) {
		 getElement(locator).sendKeys(value);
	}

}
