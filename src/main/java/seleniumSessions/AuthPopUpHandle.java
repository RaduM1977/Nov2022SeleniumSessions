package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthPopUpHandle {

	public static void main(String[] args) {

		
		
	WebDriver driver = new ChromeDriver();
		
			//we enter the username and the password in the URl after https://userName:Password@URL(domain name) the username and password should NOT have @
			
	//this is not a JS pop-up 
	
	String username ="admin";
	String password = "admin";
	
	// Do not use in the password or username the @
		
	    //https://the-internet.herokuapp.com/digest_auth
		//driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		driver.get("https://"+username+":"+password+"@"+"the-internet.herokuapp.com/basic_auth");

	}

}
