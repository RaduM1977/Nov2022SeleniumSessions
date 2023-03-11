package seleniumSessions.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvalidLocator {

	public static void main(String[] args) {
		

		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		//******** InvalidSelectorException  vs NoSuchElementException
		
		//driver.findElement(By.xpath("///input[@@@id='name']")).sendKeys("testing");
		//InvalidSelectorException: invalid selector: Unable to locate an element with the xpath expression -->SyntaxError 
		
		//driver.findElement(By.xpath("//input[@id='naveeen']")).sendKeys("testing"); --> NoSuchElementException --> correct syntax but wrong xpath
		
		
		// ******** other exception 
		//NoAlertException
		//NoFrameException
		//NoWindowException

	}

}
