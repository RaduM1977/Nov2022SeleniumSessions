package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverTest {

	public static void main(String[] args) {
		
		/*
		 
		  before Selenium 4.6.0 at 4.5.3 we need to have the exe file:
		  

		if the properties were not set up we get the following exception:
		 
		Exception in thread "main" java.lang.IllegalStateException:
		  The path to the driver executable The path to the driver executable must be set by the webdriver.chrome.driver system property; for more information, 
		  see https://chromedriver.chromium.org/. The latest version can be downloaded from https://chromedriver.chromium.org/downloads
		  
			to set the path we need to go online and download the ChromeDriver.exe file and then setProperty
			
		mac:						key									path
			System.setProperty("webdriver.chrome.driver", "/Users/radum/Downloads/chromedriver"); // the path of the chromeDriver
		
		windows:
			System.setProperty("webdriver.chrome.driver", "c:\\Users\\radum\\Downloads\\chromedriver.exe"); // the path of the chromeDriver
			
			
			
			From Selenium manager - 4.6.0 and up
			Webdrivermanager - bonigarcia 
			
			
			github --> Selenium HQ /selenium --> java --> src --> open source --> remote --> remoteWebdriver --> chromiumDriver 
		 */
		
		
		WebDriver driver = new ChromeDriver();
		
		// SearchContext Interface is the parent of WebDriver Interface which is the parent of RemoteDriver class
	}

}
