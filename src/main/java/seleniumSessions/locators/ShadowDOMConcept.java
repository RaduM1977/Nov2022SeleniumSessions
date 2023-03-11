package seleniumSessions.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOMConcept {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		

		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
		Thread.sleep(3000);
		
		//driver.findElement(By.id("pizza")).sendKeys("veg pizza");
		
		//browser --> page --> shadowDOM(1) --> shadowDOM(second shadow DOM) --> input element
		
		//******* we need to find the JS path in the DOM because their is no method to go in the shadow DOM
		//put in the console the JS path and copy it in the js.executeScript  add the return  plus cast to WebElement 
		
		//convert to JS the driver and than create the WebElement by casting the executeScript --> copy the js path from the Console
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement pizza= (WebElement) js.executeScript("return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#app2\").shadowRoot.querySelector(\"#pizza\")");
		
		pizza.sendKeys("veg pizza");
	}

}
