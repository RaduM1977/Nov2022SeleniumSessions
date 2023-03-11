package waits;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
	
		
		//FluentWait is a class child of the Wait Interface
		
		//WebDriverWait -extends-> FluentWair -> extends-> Wait
		
		//WebDriverWait is the extension of the FluentWait
		driver = new ChromeDriver();
		
		driver.get("https://www.freshworks.com");
		
		By freeTrial = By.cssSelector("a[title='Free Trial']");
		
		
		//if we do not provide the polling time by default will try every 500 milliseconds
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//				.withTimeout(Duration.ofSeconds(10))
//				//you can add which exception to ignore 
//				.ignoring(NoSuchElementException.class)
//				.ignoring(StaleElementReferenceException.class)
//				.pollingEvery(Duration.ofSeconds(2))// 5 times --  default time is  500 milliseconds 
//					// 0 seconds will be checking continually until the Duration.ofSeconds expires on the total timeout
//				.withMessage("....element is not found on the page ...");
//		
//		WebElement freeTrialElement = wait.until(ExpectedConditions.presenceOfElementLocated(freeTrial));
//		freeTrialElement.click();
	
		waitForElementPresenceWithFluentWait(10,2,freeTrial).click();
		
		
	}
	
	
	public static WebElement  waitForElementPresenceWithFluentWait(int timeOut,int pollingTime,By locator) {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.withMessage(".....element is not found on the page ...");
		
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	
	public static void  waitForAlertWithFluentWait(int timeOut,int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.ignoring(NoAlertPresentException.class)
				
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.withMessage("....Alert is not found on the page ...");
		
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	
}
