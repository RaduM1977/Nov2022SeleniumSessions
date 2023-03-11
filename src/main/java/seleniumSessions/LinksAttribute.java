package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksAttribute {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
			
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		
		
		By links = By.tagName("a");
		By images = By.tagName("img");
		
		
		// get all the links 
//		List<WebElement> linksList = getElements(links);
//		System.out.println("the total number of links are --> " + linksList.size());
//		
//		for( WebElement e : linksList) { // veers scraping  --> scrapping the data
//			String hrefVal = e.getAttribute("href");
//			String linkText = e.getText();
//			System.out.println(hrefVal + " ----> " + linkText);
//		}
		
		//get all the images 
//		List<WebElement> imageList = getElements(images);
//		System.out.println("total images --> " + imageList.size());
//		
//		for(WebElement e :imageList) {
//			String scrVal = e.getAttribute("src");
//			System.out.println(scrVal);
//		}
		
		getElementAttributes(images,"src");
		getElementAttributes(links,"href");
		
		
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static void getElementAttributes(By locator, String attrName) {
		List<WebElement> eleList = getElements(locator);
		
		for(WebElement e : eleList) {
			String attrVal = e.getAttribute(attrName);
			System.out.println(attrVal);
		}
		
	}
	
}
