package waits;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForJSAlertPopUp {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.findElement(By.xpath("//button[text() = 'Click for JS Alert']")).click();
		//NoAlertPresentException: no such alert
		
		
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		//we create the object of Alert --> if we create the object for Alert this way no need for switchTo() --> Selenium is doing internal
//		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//		
//		System.out.println(alert.getText());
//		alert.accept();
		
		
//		Alert alert = driver.switchTo().alert();
//		String text = alert.getText();
//		System.out.println(text);

		//alert.accept();
		
		//alertSendKeys(10,"naveen");
		acceptAlert(10);
		
		
		

	}
	
	public static Alert waitForAlertPresence(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		//we create the object of Alert --> no need to create this object with switchTo()
		return  wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static String getAlertText(int timeOut) {
		return waitForAlertPresence(timeOut).getText();
	}
	
	public static void acceptAlert(int timeOut) {
			waitForAlertPresence(timeOut).accept();
	}
	
	public static void dismissAlert(int timeOut) {
		waitForAlertPresence(timeOut).dismiss();
	}
	
	public static void alertSendKeys(int timeOut,String value) {
		waitForAlertPresence(timeOut).sendKeys(value);
	}
	
	
	

}
