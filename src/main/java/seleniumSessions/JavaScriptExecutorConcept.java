package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import seleniumSessions.utils.JavaScriptUtil;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) throws InterruptedException {
		

		//in javaSript --> document.title --> it will give us the title 
		//history.go(0)
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com");
		
		
		//JavascriptExecuter is an interface which cast the driver 
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		
//		//we use the executeScript method to run the JS code
//		//the return type in the Console is String so we need top convert toString() 
//		String title = js.executeScript("return document.title").toString();
//		System.out.println(title);
//		
//		js.executeScript("alert ('hi, this is an alert')");
//		
//		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
//		

		
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		String title = jsUtil.getTitleByJS();
		System.out.println(title);
		
		
		//generating the alert when giving a demo or when we are debugging 
		//jsUtil.generateAlert("this is my js alert ... we are on amazon home page");
		//jsUtil.generateConfirmPopUp("are you syre?");
		
		jsUtil.refreshBrowserByJS();
		
		//driver.get("https://classic.freecrm.com/");
		
		//capture the text of all the elements on the page -> use for contains 
//		String pageText = jsUtil.getPageInnerText();
//		System.out.println(pageText);
		
		// THOSE COULD BE ADD TO THE SANITY TESTING  -->  document.documentElement.innerText -> document = DOM; documentElement = each element; innerText = the text

//		if(pageText.contains("Deal Pipeline")) System.out.println(true);
//		if(pageText.contains("UNLIMITED CAMPAIGNS")) System.out.println(true);
		
		//Flash an element
//		WebElement element = driver.findElement(By.name("username"));
//		jsUtil.drawBorder(element);
//		
//		jsUtil.flash(element);
		
//		jsUtil.scrollPageDown();
//		Thread.sleep(2000);
//		jsUtil.scrollPageUp();
//		Thread.sleep(2000);
//		jsUtil.scrollPageDown();
//		Thread.sleep(2000);
//		jsUtil.scrollPageUp();
//		Thread.sleep(2000);
//		jsUtil.scrollPageDownMiddlepage();
		
//		// print the text of all the elements 
//		String text = driver.findElement(By.tagName("html")).getText();
//		System.out.println(text);
		
		//it will give us the title 
		String newTitle = driver.findElement(By.tagName("title")).getText();
		System.out.println(newTitle);
		
		newTitle = driver.findElement(By.xpath("//title")).getText();
		System.out.println(newTitle);
		
	}

}
