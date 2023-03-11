package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrameHandle {

	public static void main(String[] args) {
		
		
	WebDriver driver = new ChromeDriver();
		

		driver.get("https://selectorshub.com/iframe-scenario/");
		
		//nested iframes
			//f1 -- ele
				//f2 -- ele
					//f3 -- ele
		
		
		//switch one more level inside of the second 
		driver.switchTo()
		.frame("pact1")
			.switchTo().frame("pact2")
				.findElement(By.id("jex")).sendKeys("PQR");//goes to frame 2
		//driver.findElement(By.id("jex")).sendKeys("PQR");
		
		
//		
//		//switch to the first frame
//		driver.switchTo().frame("pact1");
//		driver.findElement(By.id("inp_val")).sendKeys("abc");
//		
//		//switch one more level inside of the second 
//		driver.switchTo().frame("pact2");
//		driver.findElement(By.id("jex")).sendKeys("PQR");
//		
//		//switch to the parent frame 
//		driver.switchTo().parentFrame(); //sel 4.x
//		
//		// we can use also:
//		//driver.switchTo().frame("pact1");
//		
//		driver.findElement(By.id("inp_val")).sendKeys("ABC - new");
//		
//		//switch to the immediate frame and then to the frame inside of the second
//		driver.switchTo().frame("pact2");
//		
//		//Switch to the third level frame
//		driver.switchTo().frame("pact3");
//		driver.findElement(By.id("glaf")).sendKeys("Naveen");
//		
//		//we have to go up 2 times 
//		driver.switchTo().parentFrame();//sel 4.x --> f2
//		driver.switchTo().parentFrame();//sel 4.x --> f1
//		//driver.switchTo().defaultContent();//going to the page 
//		driver.findElement(By.id("inp_val")).sendKeys("ABC-- last");
//		
//		//this method is going out of the frame/s to the page 
//		driver.switchTo().defaultContent();
//		
//		
//		//sales force has nested frames 
		
		
	}

}
