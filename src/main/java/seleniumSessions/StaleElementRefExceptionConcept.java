package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementRefExceptionConcept {

	public static void main(String[] args) {
		

		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");//DOM -->v1
		
		WebElement fn = driver.findElement(By.id("input-email"));// v1
		fn.sendKeys("naveen@gmail.com");//v1
		
		driver.navigate().refresh(); //DOM --> v2
		
		//we reinitialize the element to not get the staleElementException
		// after refresh() we need to recreate the elements on that page 
		fn = driver.findElement(By.id("input-email")); //v2
		fn.sendKeys("gurjeet@gmail.com");        //StaleElementReferenceException
		
		
	}

}
