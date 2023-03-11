package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToElementConcept {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
//		driver.get("http://mrbool.com/");
		
		//to eliminate spaces we use 
		//a[normalize-space(() = 'Content')]
		
//		WebElement menu = driver.findElement(By.cssSelector("a.menulink"));
		
		//*********create an Actions object for performing the mouse/keyboard actions in Selenium and moveToElement()
		Actions action = new Actions(driver);
		//we need to use build() and perform() to do the action
//		action.moveToElement(menu).build().perform();
//		
		
		
		//click the element after the mouse move over 
//		driver.findElement(By.linkText("COURSES")).click();
		
		
		//Homework:
		driver.get("https://www.spicejet.com/");
		String parentHandle = driver.getWindowHandle();
		
		WebElement addOns = driver.findElement(By.xpath("//div[.='Add-ons']"));
		action.moveToElement(addOns).build().perform();
		
		driver.findElement(By.xpath("//div[.='Zero Cancellation']")).click();
//		Thread.sleep(2000);
//		driver.close();
		
		driver.switchTo().window(parentHandle);
		
		WebElement spiceClub = driver.findElement(By.xpath("//div[.='SpiceClub']"));
		action.moveToElement(spiceClub).build().perform();
		
		WebElement benefitsButton = driver.findElement(By.xpath("//div[contains(text(),'Benefits')]"));

		action.moveToElement(benefitsButton).click(benefitsButton).build().perform();
		
		
		
		
	}

}
