package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderAction {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/slider/default.html");
		
		WebElement slider = driver.findElement(By.id("slider"));
		
		//slider.click();
		
		int width = slider.getSize().getWidth();
		System.out.println(width);//1184
		
		//for negative element it will move to the left location
		Actions act = new Actions(driver);
		//act.moveToElement(slider,(width/2)-30,0).click().build().perform();
		
		//it will move with out using the click()
		act.clickAndHold(slider).moveByOffset(width/2-30, 0).build().perform();
		
		
	}

}
