package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import seleniumSessions.utils.BrowserUtil;
import seleniumSessions.utils.ElementUtil;

public class RegPageTest {

	public static void main(String[] args) {
		
		String browserName = "chrome";
		
		// the utils classes we make them non static for parallel testing 
		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.initDriver(browserName);
		
		brUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		String title = brUtil.getPageTitle();
		System.out.println(title);
		
		//by locators with By reference variables with OR object repository
		
		
		By firstName = By.id("input-firstname");// return By reference 
		By lastName = By.id("input-lastname");
		By email = By.id("input-email");
		By telephone = By.id("input-telephone");
		By password = By.id("input-password");
		By confirmPassword  = By.id("input-confirm");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		
		eleUtil.doSendKeys(firstName, "Amrita");
		eleUtil.doSendKeys(lastName, "Singh");
		eleUtil.doSendKeys(email, "Amrita@gmail.com");
		eleUtil.doSendKeys(telephone, "312.567.5476");
		eleUtil.doSendKeys(password, "Amrita@123");
		eleUtil.doSendKeys(confirmPassword, "Amrita@123");

	}

}
