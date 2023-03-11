package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForTitleAndUrl {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		System.out.println(driver.getTitle()); // loading.... checking ....
		
		driver.findElement(By.linkText("Forgotten Password")).click();
		
		
		//********* they are 2 methods contains() and is()
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.titleContains("Password?"));
		
		String title = waitForTitleContainsAndFetch(10,"Password?");
		
		if(title.contains("Forgot Your Password?")) {
			System.out.println("PASS");
		}
		
		driver.get("https://www.amazon.com/");
		driver.findElement(By.linkText("Mobiles")).click();
		
		//we call the boolean method 
		if(waitForURLContains(10,"mobile-phones")) {
			System.out.println("URL is correct");
		}
		else {
			System.out.println("URL is in-correct");
		}
		
	}

	
	//titleContains()
	public static String waitForTitleContainsAndFetch(int timeOut, String titleFractionValue) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.titleContains(titleFractionValue));
		return driver.getTitle();
	}
	
	
	//titleIs()
	public static String waitForTitleAndFetch(int timeOut, String titleValue) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.titleIs(titleValue));
		return driver.getTitle();
	}
	
	
	
	
	//urleContains()
	public static String waitForURLContainsAndFetch(int timeOut, String urlFractionValue) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.urlContains(urlFractionValue));
		return driver.getCurrentUrl();
	}
	
	//urlToBe()
	public static String waitForURLIsAndFetch(int timeOut, String urlValue) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.urlToBe(urlValue));
		return driver.getCurrentUrl();
	}
	
	//urlContains return which is boolean
	public static boolean waitForURLContains(int timeOut, String urlFractionValue) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.urlContains(urlFractionValue));
		
	}
	
}
