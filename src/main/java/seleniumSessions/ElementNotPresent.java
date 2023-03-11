package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementNotPresent {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		//the element is not present: 2 reasons --> locator is wrong or their is a bug in the application
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		
		By logoImage = By.className("img-responsive11");
		By search = By.name("search");
			
		//we + action --> the exception will come from the findElement 
		boolean flagImg = driver.findElement(logoImage).isDisplayed();// this line will hit the server because of the driver.finfElement -->throw NoSuchElementException
		System.out.println(flagImg);
		
		// FE(findElement) -> throw NoSuchElementException
		
	}

}
