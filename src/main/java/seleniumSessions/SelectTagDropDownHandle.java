package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectTagDropDownHandle {
	static WebDriver driver;
	

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial");
		
		
		

//		//dropdown --> htmlTag => select tag
//		//use Select class in Selenium
		
//		WebElement country_ele = driver.findElement(country);
//		
//		Select select = new Select(country_ele);
//		
//		//select by index
//		//select.selectByIndex(5);//Andora
//		
//		//select by value
//		//select.selectByValue("Belgium");//Belgium --> you have to use the value attribute 
//		
//		//select by visible text:
//		select.selectByVisibleText("India"); // India --> you have to use the visible text(text of the option)
//		

		By country = By.id("Form_getForm_Country");
		
		doSelectDropDownByIndex(country,5);//Andora is at the the index 5th
		Thread.sleep(1000);
		
		doSelectDropDownByValue(country,"Belgium"); // Belgium --> you have to use the value attribute 
		Thread.sleep(1000);
		
		doSelectDropDownByVisibleText(country,"India"); // India --> you have to use the visible text(text of the option)
		
		
	
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doSelectDropDownByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public static void doSelectDropDownByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	
	public static void doSelectDropDownByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}
}
