package waits;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumSessions.utils.ElementUtil;

public class WaitForWindow {

	public static void main(String[] args) {
		

		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	
		
		By twiter= By.xpath("//a[contains(@href,'twitter.com')]");
		
		//wait for the page to load and the element to be clickable
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.clickWhenReady(10, twiter);
		
		
		
		//wait for the new window to load and then switch
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2)); //wait until the number of windows to be (in our case 2 )
		
		
		
		
		//get the window ids
		Set<String> handles = driver.getWindowHandles();
		
		//Iterator used for non index collection 
		Iterator<String> it = handles.iterator();
		String parentWindowId = it.next();
		System.out.println("parent window id : " + parentWindowId);
		String childWindowId = it.next();
		System.out.println("child window id : "+ childWindowId);
		
		//switching to child window:
		driver.switchTo().window(childWindowId);
		System.out.println("child window url: " + driver.getCurrentUrl());
		
		//********* close the child window with .close() method
		driver.close(); // close the child window
		
		// ************* switch to the parent window :
		//driver.switchTo().window(nameOrHandle)) --> VERY important to switch the driver to the parent window
		driver.switchTo().window(parentWindowId);
		System.out.println("parent window url: " + driver.getCurrentUrl());
		
		
		//close all the windows
		driver.quit();
		
		

	}

}
