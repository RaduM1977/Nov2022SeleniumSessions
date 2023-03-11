package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose {

	public static void main(String[] args) {
		
		//SID -- session id --> numeric value
		
		WebDriver driver = new ChromeDriver(); //SID 123
		driver.get("https://www.google.com");//SID 123
		String title = driver.getTitle();//SID 123
		System.out.println(title);//SID 123 Google
		System.out.println(driver.getCurrentUrl());//SID 123
		
		//driver.quit();//SID 123
		// after the quit() the SID = null
		////NoSuchSessionException: Session ID is null. using WebDriver after calling quit()
		
		
		driver.close(); // invalid session id(same SID 123) but it will not be in the server anymore 
		//NoSuchSessionException: invalid session id.
		
		
		// to solve the problem we have the launch browser(initialize the driver) again
		driver = new ChromeDriver();//new session ID = 456
		driver.get("https://www.google.com"); ///SID = 456
		System.out.println(driver.getTitle());//SID = 456
		

		//.close()  			vs 					.quit()
		//invalid Session Id 				Session Id is null
	}

}
