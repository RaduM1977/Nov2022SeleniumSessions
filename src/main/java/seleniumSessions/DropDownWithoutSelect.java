package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownWithoutSelect {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial");

		//By country = By.id("Form_getForm_Country"); // NOT good because it will give us only one element!!
		
		By options = By.xpath("//select[@id='Form_getForm_Country']/option"); //we need all the options on the select tag
		
		List<WebElement> optionsList = driver.findElements(options);
		System.out.println(optionsList.size());
		
		for(WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
				if(text.equals("India")) {
					e.click();
					break;
				}
		}
		// Homework: create a utility class for not using Select class
		//find application with Select based drop down and use select 2-3 application 
		
		selectDropDownOptionWithoutSelect(options,"Romania");
	}

	
	public static  List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static void selectDropDownOptionWithoutSelect(By locator,String text) {
		List<WebElement> optionList =  getElements(locator);
		
		for(WebElement e : optionList) {
			String actualText = e.getText();
			if(actualText.equals(text)) {
				e.click();
				break;
			}
		}	
	}
}
