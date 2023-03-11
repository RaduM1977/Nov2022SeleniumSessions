package seleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserMultipleWindowsHandle {
	
	

	public static void main(String[] args) throws Exception {
		
	// the attribute responsible for the new window browser is: 
		
		//    target="_blank" --> open in a new window
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		String parentWindowId = driver.getWindowHandle();
		
		Thread.sleep(2000);
		
		WebElement twiterElement = driver.findElement(By.xpath("//a[contains(@href,'twitter.com')]"));
		WebElement fbElement = driver.findElement(By.xpath("//a[contains(@href,'facebook')]"));
		WebElement youTubeElement = driver.findElement(By.xpath("//a[contains(@href,'youtube')]"));
		WebElement linkedInElement = driver.findElement(By.xpath("//a[contains(@href,'linkedin')]"));
		
		twiterElement.click();
		fbElement.click();
		youTubeElement.click();
		linkedInElement.click();
		
		Set<String> handles = driver.getWindowHandles();
		
		//iterator is used for the collection which does not maintain the index order
		Iterator<String> iterator = handles.iterator();// points above the first element of the Set
	
		
		while(iterator.hasNext()) {
			String windowId = iterator.next();
			driver.switchTo().window(windowId);
			System.out.println(driver.getCurrentUrl());
			
			Thread.sleep(1500);
			
			if(!windowId.equals(parentWindowId)) {
				driver.close();
			}
			
		}
		
		driver.switchTo().window(parentWindowId);
		System.out.println("parent window url: " + driver.getCurrentUrl());
		
		//Homework: go to each child window one time and close it before moving to the next --> no loop
		System.out.println("====== Homework open and close each ==========");
		
		//Open and close twitter
		twiterElement = driver.findElement(By.xpath("//a[contains(@href,'twitter.com')]"));
		twiterElement.click();
		handles = driver.getWindowHandles();
		
		Iterator<String> it = handles.iterator();
		it.next();
		String childHandle =it.next();
		driver.switchTo().window(childHandle);
		Thread.sleep(3000);
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		driver.close();
		driver.switchTo().window(parentWindowId);
		
		//Open and close FB:
		fbElement.click();
		handles = driver.getWindowHandles();
		
		it = handles.iterator();
		it.next();
		childHandle =it.next();
		driver.switchTo().window(childHandle);
		Thread.sleep(3000);
		
		url = driver.getCurrentUrl();
		System.out.println(url);
		
		driver.close();
		driver.switchTo().window(parentWindowId);
		
		//Open and close YouTube:
		youTubeElement.click();
		handles = driver.getWindowHandles();
		
		it = handles.iterator();
		it.next();
		childHandle =it.next();
		driver.switchTo().window(childHandle);
		Thread.sleep(3000);
		
		url = driver.getCurrentUrl();
		System.out.println(url);
		
		driver.close();
		driver.switchTo().window(parentWindowId);
		
		
		//Open and close linkedIn:
		linkedInElement.click();
		handles = driver.getWindowHandles();
		
		it = handles.iterator();
		it.next();
		childHandle =it.next();
		driver.switchTo().window(childHandle);
		Thread.sleep(3000);
		
		url = driver.getCurrentUrl();
		System.out.println(url);
		
		driver.close();
		driver.switchTo().window(parentWindowId);

	}

}
