package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandle {

	public static void main(String[] args) {
	
		//how to handle frames 
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		
		// if we want to find the total number of frames on the page
		int totalFrames = driver.findElements(By.tagName("frame")).size();//8
		System.out.println(totalFrames);

		//driver.switchTo().frame(2); --> not recommended
		
		// we look at the name or the id of the frame --> if those are not available we can use the WebElement of frame/iframe
		
		//driver.switchTo().frame("main");
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='top.html']")));
		
		String header = driver.findElement(By.tagName("h2")).getText();
		System.out.println(header);
		
		// the driver has to return to the main page
		driver.switchTo().defaultContent(); // goes to the main page directly
		
		// two types of frames:
		// frame 
		// iframe --> security of the web element 
		
		//nested frames 
		
	}

}
