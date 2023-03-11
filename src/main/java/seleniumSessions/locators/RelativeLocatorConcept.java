package seleniumSessions.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

//static method import
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocatorConcept {

	public static void main(String[] args) throws InterruptedException {
		

		/* sel4.x  relative locators
		 * 		above 
		 * near
		 * left		right
		 * 		below
		
		 * 
		 */
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.aqi.in/dashboard/canada");
		
		Thread.sleep(2000);
		
		WebElement ele = driver.findElement(By.partialLinkText("Whitehorse, Canada"));
		
		//use the RelativeLocator class and with() method and the tag name and the base element
		
		//driver.findElement(RelativeLocator.with(By.tagName("p")).toLeftOf(ele)).getText(); --> with out the static import
		
		//*****toRightOf(webElement):
		String rightIndex = driver.findElement(with(By.tagName("p")).toRightOf(ele)).getText();
		System.out.println(rightIndex);//66
		
		//****** toRightTo(WebElement):
		String leftRank = driver.findElement(with(By.tagName("p")).toLeftOf(ele)).getText();
		System.out.println(leftRank);//2
		
		//***** above(WebElement):
		String aboveCity = driver.findElement(with(By.tagName("p")).above(ele)).getText();
		System.out.println(aboveCity);//Westmount, Canada
		
		//****** below(WebElement):
		String belowCity = driver.findElement(with(By.tagName("p")).below(ele)).getText();
		System.out.println(belowCity);//Prince George, Canada
		
		//******* near(WebElement):
		String nearCity = driver.findElement(with(By.tagName("p")).near(ele)).getText();
		System.out.println(nearCity);//Whitehorse, Canada
		
		//Homework:  on naveen automation
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		WebElement emailTextField = driver.findElement(By.xpath("//label[.='E-Mail Address']"));
		driver.findElement(RelativeLocator.with(By.id("input-email")).below(emailTextField)).sendKeys("naveen");
		
		String header = driver.findElement(RelativeLocator.with(By.tagName("h2")).near(emailTextField)).getText();
		System.out.println(header);
		
		
		
	}

}
