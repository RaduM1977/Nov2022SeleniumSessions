package seleniumSessions;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickHandle {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		WebElement ele = driver.findElement(By.xpath("//span[text()='right click me']"));
		
		Actions action = new Actions(driver);
		
		//context click
		//action.contextClick().build().perform(); --> it will click the left upper corner of the page because there is the starting point 
														// or where the mouse is located on the screen
		
		action.contextClick(ele).build().perform();
	
		
		List<WebElement> rightEles = driver.findElements(By.cssSelector("ul.context-menu-list span"));
		System.out.println(rightEles.size());
		
		for(WebElement e : rightEles) {
			String text = e.getText();
			System.out.println(text);
			if(text.equals("Copy")) {
				e.click();
				Alert alert = driver.switchTo().alert();
				System.out.println(alert.getText());
				alert.accept();
				break;
			}
			
		}
		
		
		
		//Homework:  Click all the buttons and get the message 
		Thread.sleep(2000);
		
		for(WebElement e : rightEles) {
			
			// contextClick(right click)
			action.contextClick(ele).build().perform();
			
			//click each element on the contextClick
			e.click();
			Thread.sleep(1000);
			// handle the alert 
			Alert alert = driver.switchTo().alert();
			
			//print the test of the alert
			String alertText = alert.getText();
			System.out.println(alertText);
			
			//accept the alert
			alert.accept();
		
			
			
		}
		
		
	}

}
