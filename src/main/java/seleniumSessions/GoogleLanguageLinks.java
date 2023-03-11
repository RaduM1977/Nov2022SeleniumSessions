package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleLanguageLinks {


	static WebDriver driver;

	public static void main(String[] args) {
		

		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
//		List<WebElement> bottomLinks = driver.findElements(By.xpath("//div[@jscontroller='NzU6V']/div/a"));
//		
//		System.out.println(bottomLinks.size());
//		
//		for(WebElement e: bottomLinks) {
//			String text = e.getText();
//			System.out.println(text);
//			if(text.equals("Terms")) {
//				e.click();
//				break;
//			}
//		}
		
		By footerLinks = By.xpath("//a[@class='pHiOh']");
		
		List<WebElement> links = getLinksList(footerLinks);
		for(WebElement e : links) {
			System.out.println(e.getText());
		}
	}
	

	
	//1. method() Click on specific language link
	//2. method() return the list of language links 
	//3. method - create a method to capture the list of google footer links 
	
	public static List<WebElement> getElements(By locator ) {
		return driver.findElements(locator);
	}
	
	public static void clickLink(By locator, String linkText) {
		
		List<WebElement> links = getLinksList(locator);
		
		//System.out.println(links.size());
		for(WebElement e : links) {
			String text = e.getText();
			if(text.equals(linkText)) {
				e.click();
			}
		}
	}
	
	public static List<WebElement> getLinksList(By locator) {
		
		List<WebElement> links = getElements(locator);
		
		//System.out.println(links.size());
		return links;
	}
	
	
}
