package seleniumSessions.Homework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountTextElementsInRegistration {
	
 static WebDriver driver;

	public static void main(String[] args) {
		
		//Homework: of the text fields in nanveen automation = 6
		
				driver = new ChromeDriver();
				
				//another way to find the xpath --> //form//input[@placeholder]
				driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
				
				List<WebElement> totalTextField = driver.findElements(By.xpath("//form//input[@placeholder]"));
				
				System.out.println("The number of text fields on registration form is : " + (totalTextField.size()));
				
				
				
				driver.close();
	}

}
