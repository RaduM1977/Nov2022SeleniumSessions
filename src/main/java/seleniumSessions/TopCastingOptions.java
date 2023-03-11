package seleniumSessions;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TopCastingOptions {

	public static void main(String[] args) {
		
		//1. browser specific: can NOT be used for the cross browser
//		ChromeDriver driver  =  new ChromeDrver(); chrome
//		FireforDriver driver1 = new FirefoxDriver(); firefox
//		WebDriver driver = new WedDriver(); --> we can NOT create the object of an Interface
		
		//2. WD = new CD() - valid top casting - recommended - local execution 
//		WebDriver drive = new ChromeDriver();
		
		//3. SC = new new CD() - valid but not recommended because of limited methods 
//		SearchContext driver = new ChromeDriver();
		
		//4. RWD = new CD(); - valid top casting - recommended - local execution
//		RemoteWebDriver driver = new ChromeDriver();
		
		//5. WD = new RW(); - valid top casting - recommended --> used for remote execution(AWS) - Selenium Grid
//		WebDriver driver = new RemoteWebDriver(remoteAddress,capabilities);
		
		//6.SC = new RWD(); - valid but not recommended because of limited methods  
//		SearchContext driver = new RemoteWebDriver(remoteAddress,capabilities);
		
		//WebDriver driver = new Webdriver(); --> can NOT create object of an interface
		
		
		
		
	}

}
