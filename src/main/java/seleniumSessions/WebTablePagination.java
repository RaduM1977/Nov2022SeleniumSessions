package seleniumSessions;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WebTablePagination {
	
	static WebDriver driver;
	
	static int count;
	
	static int numberOfPages =0;

	public static void main(String[] args) throws InterruptedException {
	
		driver = new ChromeDriver();
		
		driver.get("https://selectorshub.com/xpath-practice-page/");
	
		
		Thread.sleep(3000);
		
		
		
		
		//Using Actions class to sendKeys:
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.cssSelector(""));
		
		//different way to sendKeys for with Actions class
		action.moveToElement(ele).sendKeys("cvsvsdv").build().perform();
		action.sendKeys("xfvsdvsdg").build().perform();
		action.moveToElement(ele).click().sendKeys("efewfwef").build().perform();
		action.moveToElement(ele).pause(Duration.ofSeconds(10)).click().build().perform();
		
		
		
		
		//single selection:
		
		while(true) {
			
			//WebElement next = driver.findElement(By.linkText("Next"));
			
			if(driver.findElements(By.xpath("//td[text()='India']")).size() > 0) {
				selectCountry("India");
				break;
				
				
			}
			else {
				
				//pagination logic
				WebElement next = driver.findElement(By.linkText("Next"));
				
				//isEnabled may not work
				if(next.getAttribute("class").contains("disabled")) {
					System.out.println("pagination is over.... country not found ....");
					break;
				}
				
				next.click();
				Thread.sleep(1000);
			}
//			next.click();
//			Thread.sleep(1000);	
			
		}
		
		
		//multiple selections:
		while(true) {
			
			
			if(driver.findElements(By.xpath("//td[text()='India']")).size() > 0) {
				numberOfPages++;
				selectCountries("India");
				
			}
			//pagination logic
			WebElement next = driver.findElement(By.linkText("Next"));
			if(next.getAttribute("class").contains("disabled")) {
				System.out.println("pagination is over....");
				break;
			}
			
			next.click();
			Thread.sleep(1000);
			
		}
		System.out.println("Total times country showed up: " +count);
		
		
		
		
		while(true) {
			
		}

	}
	
	//========== methods =============
	
	
	//select one country
	
	private static void selectCountry(String countryName) {
		driver.findElement(By.xpath("//td[text()='"+countryName+"']/preceding-sibling::td/input[@type='checkbox']")).click();
		
	}
	
	
	//select multiple country
	
	private static void selectCountries(String countryName) {
		List<WebElement> countries = driver.findElements(By.xpath("//tbody[@class='row-hover']//td[@class='column-5']"));
		List<WebElement> allCheck =driver.findElements(By.xpath("//tbody[@class='row-hover']//td[@class='column-5']/preceding-sibling::td/input[@type='checkbox']"));
		int pageCount =0;
		for(int i =0;i<countries.size();i++) {
			String text = countries.get(i).getText();
			if(text.equals(countryName)) {
				allCheck.get(i).click();
				pageCount++;
			}
		}
		System.out.println("Count by page: "+numberOfPages+" : " + pageCount);
		count+=pageCount;
	}
	

}
