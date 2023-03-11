package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementRefExceptionWithFEs {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");//v1
		
		List<WebElement> firstFooterLinks = driver.findElements(By.xpath("//footer//a"));
		
		for(int i =0;i<firstFooterLinks.size();i++) {
			firstFooterLinks.get(i).click();//v1  --> StaleElementReferenceException because of the WebElement id is different 
			//v2 - DOM
			//v3 - DOM
			
			//Thread.sleep(3000);
			driver.navigate().back();
			Thread.sleep(2000);
			System.out.println(firstFooterLinks.get(i).getText());
		
			firstFooterLinks = driver.findElements(By.xpath("//footer//a"));//v2 v3
			
			
		}
		
		//staleElementException:  click(),back(),forward(),refresh()
	}

}
