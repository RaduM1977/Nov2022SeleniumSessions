package seleniumSessions.locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SVGElement {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://petdiseasealerts.org/forecast-map");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'map-instance')]")));
		
		// **** svg elements locator
		////*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='regions']//*[name()='path']
		
		String svgXpath = "//*[local-name()='svg' and @id='map-svg']//*[name()= 'g' and @id='regions']//*[name()='path']";
		
		//command+shift+2 to directly assign a variable
		List<WebElement> statesList = driver.findElements(By.xpath(svgXpath));
		
		System.out.println(statesList.size());
		
		//create an Actions object to perform the click
		Actions action = new Actions(driver);
		
		for(WebElement e : statesList) {
			String stateName = e.getAttribute("name");
			System.out.println(" "+stateName);
			
			if(stateName.equals("Florida")) {
				Thread.sleep(2000);
				
				int x = e.getSize().getWidth();
				int y = e.getSize().getHeight();
				System.out.println(x + " : " + y);
				
				//System.out.println((x/2-40) + " : " + y/2);
				System.out.println((x*1/4) + " : " + y/2);
				
				// using actions class to click the Florida state
				//action.moveToElement(e,(x/2)-40, 0).click().build().perform();
				action.moveToElement(e,x*1/4, 0).click().build().perform();
				break;
			}
			
		}
		//the right expath for flipkart
		//*[local-name()='svg']//*[name()='g' and @fill-rule='evenodd']
		
		
		//HomeWork: print all the regions of Maryland

		List<WebElement> extendedMapElements = driver.findElements(By.xpath("//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @class='subregion']//*[name()='path']"));
		
		System.out.println(extendedMapElements.size());
		for(WebElement e : extendedMapElements) {
			System.out.println(e.getAttribute("name"));
			
			
			//element.click() --> will happened at the middle of the element all the time 
			
				
		}
		
		
	}

	
	//Parameterized method with contains text :
	
	public static void containsText(String name ) {
		String xpath = "//*[contains(text(),'"+name+"')]";
		
	}
}
