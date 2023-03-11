package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		

		driver = new ChromeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By emailId = By.id("input-email");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@value='Login']");
		
		
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));//sel 4.x
//	
//		//find the WebElement with the explicit wait
//		WebElement email_ele = wait.until(ExpectedConditions.presenceOfElementLocated(emailId));
//		
//		
//		//use to find the element with explicit wait
//		email_ele.sendKeys("testing@gmail.com");

		
		
		//use to find the element with explicit wait until method 
		waitForElementPresence(emailId,10).sendKeys("test@gmail.com");
		//waitForElementVisible();
		getElement(password).sendKeys("test@123");
		getElement(loginBtn).click();
		
		//document.body.style.zoom = '10.5'
		//document.body.style.zoom = '50%'
	}
	
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public static WebElement waitForElementPresence(By locator,int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return  wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}
	
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page and visible.
	 * Visibility means that the element is not only displayed
	 * but also has a height and width that is greater than 0.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	
	public static WebElement waitForElementVisible(By locator,int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static  WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	

}
