package seleniumSessions.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClickSendKeys {
	
	static WebDriver driver;
	
	public static void main(String[]args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		By firstname = By.id("input-firstname");
		By lastname = By.id("input-lastname");
		By continueBtn = By.cssSelector("input[type='submit']");
		
		//********  create the Action object --> Do not forget the build().perform()
//		Actions action = new Actions(driver);
//		
//		action.sendKeys(driver.findElement(firstname),"Naveen").build().perform();
//		action.sendKeys(driver.findElement(lastname),"automation").build().perform();
//		action.click(driver.findElement(continueBtn)).build().perform();
		
		//************** if we get the following exceptions we should use the Actions class to click or send data
		//ElementNotInteractableException
		//ElementNotInterceptedException
		
		
		doActionSendKeys(firstname,"Naveen");
		doActionSendKeys(lastname,"Automation");
		doActionsClick(continueBtn);
		
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	

	public static void doActionSendKeys(By locator,String value) {
		Actions action = new Actions(driver);
		action.sendKeys(getElement(locator),value).build().perform();
		
	}
	
	public static void doActionsClick(By locator) {
		Actions action = new Actions(driver);
		action.click(getElement(locator)).build().perform();
	}
	
	
}
