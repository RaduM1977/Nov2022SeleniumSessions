package seleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowPopUpHandle {
	
	

	public static void main(String[] args) throws InterruptedException {
		
		
		// the attribute responsible for the new window browser is: target="_blank"
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		Thread.sleep(2000);
		
		WebElement twiterElement = driver.findElement(By.xpath("//a[contains(@href,'twitter.com')]"));
		
		twiterElement.click();
		
		
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
