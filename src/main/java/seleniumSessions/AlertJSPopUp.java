package seleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertJSPopUp {

	public static void main(String[] args) throws InterruptedException {
		

		//JS alert -> alert, prompt, confirm
			// 1.auth pop up
			// 2.browser window pop up/advertising pop up
			// 3.file upload pop up 
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//driver.findElement(By.xpath("//button[text() = 'Click for JS Alert']")).click();
		//NoAlertPresentException: no such alert
		
		
//		Thread.sleep(3000);
		
//		Alert alert = driver.switchTo().alert();
//		String text = alert.getText();
//		System.out.println(text);

		
		
		//alert.accept();
		
		//alert.dismiss(); // esc on the keyboard 

		
		//******** confirm alert :
		
//		driver.findElement(By.xpath("//button[text() = 'Click for JS Confirm']")).click();
	  //NoAlertPresentException: no such alert --> if not exception
		
//		Thread.sleep(3000);
		
		//***** create an object alert
//		Alert alert = driver.switchTo().alert();
		
		//***** getText()
//		String text = alert.getText();
//		System.out.println(text);

		
		// alert.accept(); --> click on Ok
		// alert.dismiss(); --> click on Cancel
		
		//*********** prompt alert:
		//driver.findElement(By.xpath("//button[text() = 'Click for JS Prompt']")).click();
		////NoAlertPresentException: no such alert --> if the alert is not open
		//Thread.sleep(3000);
		
		
		//Alert alert = driver.switchTo().alert();
		//alert.sendKeys("Naveen");
		//alert.accept();
		 
		// ***** how do you recognize a JS:
		// > no url,
		// > you can NOT inspect,
		// > only one text field,
		// > only one pop up at the time,
		// > usually on the middle of the page 
		
		
		
		
		//HOMEWORK : rediff.com --> login  --> deal with the alert
		//https://mail.rediff.com/cgi-bin/login.cgi
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		//Test Scenario --> test the login functionality with empty username and password
		//TC -> Given the above website:https://mail.rediff.com/cgi-bin/login.cgi, 
		//when entering empty username and password, 
		//then we should get a pop up with the message "Please enter a valid user name"
		
		driver.findElement(By.xpath("//input[@value='Sign in']")).click();
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		alert.accept();
		if(actualText.equals("Please enter a valid user name")){
			System.out.println("PASS");
		}else {
			System.out.println("FAILED");
			
			
		}
		
		//Test Scenario --> test the login functionality with random username and empty password
				//TC -> Given the above website:https://mail.rediff.com/cgi-bin/login.cgi, 
				//when entering random username and empty password, 
				//then we should get a pop up with the message "Please enter your password"
		
		//enter username
		driver.findElement(By.xpath("//input[@name='login']")).sendKeys("anything");
		
		//click login btn
		driver.findElement(By.xpath("//input[@value='Sign in']")).click();
		
		//switch to the JS alert
		alert = driver.switchTo().alert();
		
		//get the alert text
		actualText = alert.getText();
		
		//close the alert
		alert.accept();
		
		//validate the answer
		if(actualText.equals("Please enter your password")){
			System.out.println("PASS");
		}else {
			System.out.println("FAILED");
		
		}
		
	}
 }
