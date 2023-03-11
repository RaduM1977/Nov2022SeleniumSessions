package seleniumSessions.locators;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PseudoElementConcept {

	public static void main(String[] args) {
		

		//window.getComputedStyle(document.querySelector("label[for='input-firstname']"), '::before').getPropertyValue('content')
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		JavascriptExecutor js = (JavascriptExecutor)driver; // JavascriptExecutor is an interface and we cast the driver to it 
		
		// how to get the * from the DOM
		// we use only the css locator 
		String script = "return window.getComputedStyle(document.querySelector(\"label[for='input-firstname']\"), '::before').getPropertyValue('content')";
		
		
		//convert toString()
		String mandatoryField = js.executeScript(script).toString();// the return is a JS retrun and it needs to be converted to String
		System.out.println(mandatoryField);
		
		if(mandatoryField.contains("*")) {
			System.out.println("this is a mandatory field");
		}
		

	}

}
