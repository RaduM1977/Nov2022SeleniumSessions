package seleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetElementsFromPageSection {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
	
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		// when we use // indirect association and / direct association
		
//		List<WebElement> panelLinksList = driver.findElements(By.xpath("//aside[@id='column-right']//a"));
//		System.out.println(panelLinksList.size());//13
//		
//		for(WebElement e : panelLinksList) {
//			String text = e.getText();
//			System.out.println(text);
//		}
		
		By rightPanelLinks = By.xpath("//aside[@id='column-right']//a");
		List<String> rightElesList = getElementsTextList(rightPanelLinks);
		
		System.out.println(rightElesList);
		
		System.out.println(rightElesList.contains("Login"));
		System.out.println(rightElesList.contains("Wish List"));
		System.out.println(rightElesList.contains("Newsletter"));
		
		System.out.println("============ links footer ==============");
		
		By footerPanelLinks = By.xpath("//footer//a");
		List<String> footerElemList = getElementsTextList(footerPanelLinks);
		
		System.out.println("======= attributes href in footer =========");
		getElementsAttributeList(footerPanelLinks,"href");
		
	}
	
	
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	
	}
	
	//Homework for the footers and attributes generic method
	public static List<String> getElementsTextList(By locator) {
		
		List<String> eleTextList = new ArrayList<String>();//size = 0
		
		List<WebElement> eleList = getElements(locator);
		
		for(WebElement e : eleList) {
			String text = e.getText();
			System.out.println(text);
			eleTextList.add(text);
		}
		return eleTextList;
	}

	public static List<String> getElementsAttributeList(By locator,String attributeValue) {
		
		List<String> eleAttributeList = new ArrayList<String>();//size = 0
		
		List<WebElement> eleList = getElements(locator);
		
		for(WebElement e : eleList) {
			String attribute = e.getAttribute(attributeValue);
			System.out.println(attribute);
			eleAttributeList.add(attribute);
		}
		return eleAttributeList;
	}
	
	
}
