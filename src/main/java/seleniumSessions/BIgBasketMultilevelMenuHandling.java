package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BIgBasketMultilevelMenuHandling {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
			

			driver.get("https://www.bigbasket.com/");
			
			//angler based application
			//WebElement shopParentEle = driver.findElement(By.cssSelector("a.meganav-shop"));
			
			By l1Cat = By.cssSelector("a.meganav-shop");
			
			selectProductLevel4Handling(l1Cat,"Beverage","Tea","Tea Bags");
			
			//how to inspect angler application: fn + F8 to freeze the screen
			//in DOm in sources create a new JS file debug.js and it will create a new file with this name
			// write --> debugger;
	}

	
	public static void selectProductLevel4Handling(By locator,String l2,String l3,String l4) throws InterruptedException {
		
		WebElement shopParentEle = driver.findElement(locator);
		
		Actions action = new Actions(driver);
		action.moveToElement(shopParentEle).build().perform();
		Thread.sleep(2000);
		
		WebElement l2Ele = driver.findElement(By.linkText(l2));
		action.moveToElement(l2Ele).build().perform();
		Thread.sleep(2000);
		
		WebElement l3Ele = driver.findElement(By.linkText(l3));
		action.moveToElement(l3Ele).build().perform();
		Thread.sleep(2000);
		
		WebElement l4Ele = driver.findElement(By.linkText(l4));
		l4Ele.click();
	
	}
}
