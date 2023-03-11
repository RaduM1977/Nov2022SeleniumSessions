package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import seleniumSessions.utils.JavaScriptUtil;

public class ScrollIntoViewConcept {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		WebElement ele = driver.findElement(By.xpath("//h2[.='Trending deals']"));
		
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		
		//***scroll
		//jsUtil.scrollIntoView(ele);
		
		//*** different types of click:
		//click() -- UI --> click on the middle of the ele
		//actions ->click -- move to element  --> click on the middle of the element 
		//js click --> click from DOM back end (not recommended for automation)
		
		WebElement bestSeller = driver.findElement(By.linkText("Best Sellers"));

		//click with JS
		jsUtil.clickElementByJS(bestSeller);
		
		//we can use JS to SendKeys too but not recomended  
	}

}
