package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Totalimages {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		List<WebElement> imagesList = driver.findElements(By.tagName("img"));
		
		System.out.println(imagesList.size());//19
		
		//if the findElements() did not find anything it will return an empty list (zero) 0 --> it will not throw any exceptions
		
		//command + shift + o --> import the classes/interfaces
		
		//Homework: of the text fields in nanveen automation = 7
		
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		driver.findElements(By.className("form-control"));
		
		//FE 	vs     FEs
		//-----------------------------------------
		//WE      	List<WebElements>
		//NSE     	empty list --> size =0;
		//action  	no action ca be perform
		
	}

}
