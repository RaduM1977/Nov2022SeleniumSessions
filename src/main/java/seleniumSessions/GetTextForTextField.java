package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextForTextField {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		WebElement firstName = driver.findElement(By.id("input-firstname"));
		firstName.sendKeys("NaveenAutomation");
		
		
		//to retrive the text inputed text we use the getAttribute("value")
		String name = firstName.getAttribute("value");
		System.out.println(name);
		
		
		// we can NOT we will get an illegalArgumentException --> Keys to send should be a not null CharSequence
		WebElement lastName = driver.findElement(By.id("input-lastname"));
		lastName.sendKeys(null);//illegalArgumentException
		
		//placeholder is the blur information on the input field 
		
		
		
	}

}
