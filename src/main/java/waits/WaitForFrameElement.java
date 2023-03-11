package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForFrameElement {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		//how to handle frames with explicit wait
		
				driver = new ChromeDriver();
				driver.get("http://www.londonfreelance.org/courses/frames/index.html");
				
				// wait for the frame to be available and switch to it 
//				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("main"));
				
				
				// using the explicit wait and method to switch the frame
				//waitForFrameAndSwitchToItByIDOrName(10,"main");
				
				 waitForFrameAndSwitchToItByFrameElement(10,driver.findElement(By.xpath("//frame[@src='top.html']")));
				
				// manipulate elements in the frame 
				String header = driver.findElement(By.tagName("h2")).getText();
				System.out.println(header);
				
				//switch to the main page
				driver.switchTo().defaultContent();
	}
	
	//utils methods 
	
	public static void waitForFrameAndSwitchToItByIDOrName(int timeOut,String idOrName) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(idOrName));
	}
	
	public static void waitForFrameAndSwitchToItByIndex(int timeOut,String index) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
	}
	
	public static void waitForFrameAndSwitchToItByFrameElement(int timeOut, WebElement frameElement ) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}
	
	public static void waitForFrameAndSwitchToItByFrameLocator(int timeOut, By frameLocator ) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}
	
	
	
}
