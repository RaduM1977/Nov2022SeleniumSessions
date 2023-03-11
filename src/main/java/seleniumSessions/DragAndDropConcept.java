package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcept {

	public static void main(String[] args) {
	

		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		
		WebElement sourceEle = driver.findElement(By.id("draggable"));
		WebElement targetEle = driver.findElement(By.id("droppable"));
		
		Actions action = new Actions(driver);
		
		//builder pattern --> it will work without the build() but use build and perform
		
//		action   --> performs 3 actions 
//			.clickAndHold(sourceEle) --> 1 action
//				.moveToElement(targetEle) --> 1 action
//					.release() --> 1 action
//						.build().perform();
		
		
		
		action.dragAndDrop(sourceEle,targetEle).build().perform();
		

	}

}
