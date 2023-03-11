package seleniumSessions;





import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SignatureActions {

	public static void main(String[] args) throws InterruptedException {
		

		WebDriver driver = new ChromeDriver();
		driver.get("https://signature-generator.com/draw-signature/");
		
		//to freeze the DOM go  to Source and press fn+f8 to freeze the page 
		
	Thread.sleep(2000);
	
	WebElement canvas = driver.findElement(By.id("signature-pad"));
	
	Actions action = new Actions(driver);
	
	// we can create the signature object from the Action interface
	Action signature = action.click(canvas)   // it will click at the middle of the canvas
			.moveToElement(canvas, 3, 3)  // move the element 
			.clickAndHold(canvas)   // click and hold the element 
			.moveByOffset(50, -50)  // move by the x and y 
			.moveByOffset(-100, 50)
			.moveToElement(canvas, -200, -50)
			.moveByOffset(50, -50)
			.moveByOffset(3, 3)
			
			.release(canvas) // release at the end 
			.build();
			
			/*
			 *   -     
			 *   y    - x +
			 *   +
			 */
	
			signature.perform();
			
			//************ to freeze the DOM go  to Source and press fn+f8 to freeze the page **********

	}

}
