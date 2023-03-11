package waits;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitWithFluentFeatures {
	
	static WebDriver driver;


	public static void main(String[] args) {
	
		//WebDriverWait -> extends -> FluentWair -extends-> Wait
		
		//explicit wait with the fluent features
		
		driver = new ChromeDriver();
		driver.get("https://www.freshworks.com");
		
		By freeTrial = By.cssSelector("a[title='Free Trial']");
		
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait.pollingEvery(Duration.ofSeconds(2));
//		wait.ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
//		wait.withMessage("----- element not found -----");
//		
//		wait.until(ExpectedConditions.presenceOfElementLocated(freeTrial)).click();
		
		
		// WebDriverWait with polling time but without the Fluent features 
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10),Duration.ofSeconds(2));
		wait.until(ExpectedConditions.presenceOfElementLocated(freeTrial)).click();
		
	}

}
