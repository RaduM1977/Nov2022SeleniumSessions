package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DisableTextFieldAndButtonEnterValue {

	public static void main(String[] args) {
		
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html");
//		
//		
//		//for disablesd fields we will get --> ElementNotInteractableException: element not intractable
//		WebElement password = driver.findElement(By.id("pass"));// this is disabled
//		password.sendKeys("test@123");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://register.freecrm.com/register/");
		
		WebElement submit_btn = driver.findElement(By.id("submitButton"));
		
		String disabledText = submit_btn.getAttribute("disabled");
		System.out.println(disabledText);
		
		submit_btn.click();//elementClickInterceptedException
		
		
	}

}
