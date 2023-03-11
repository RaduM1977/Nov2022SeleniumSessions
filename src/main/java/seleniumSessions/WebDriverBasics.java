package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
	
	//1. open the browser: chrome,fireFox
		
		// create an object of ChromeDriver
		// ChromeDriver driver = new ChromeDriver(); // it will open the chrome browser
		
		//WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		
		String browser = "chrome";
		WebDriver driver = null;
		
		//cross browser logic
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
			
		}
		else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
			
		}
		else if(browser.equals("safari")) {
			driver = new SafariDriver();
			
		}
		else if(browser.equals("edge")) {
			driver = new EdgeDriver();
			
		}
		else {
			System.out.println("please pass the right browser ..." + browser);
		}
		

		
	//2. enter URl: 
		driver.get("http://google.com"); // it should have the http/https(protocol is important) --> www. is not important we do not have to use it
		// get() no return type so no need to store the parameter
		
	//3. get the title:
		String actualTitle = driver.getTitle();
		System.out.println("page title : " + actualTitle);
		
		//validate point/checkpoint
		if(actualTitle.equals("Google")) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
		
		//Automation steps(Selenium code)  + validation/assertions = Automation Testing
		
	//4. close the driver
		driver.quit();
		

		// >>>>>>>>>>> Homework  <<<<<<<<<<<<<<<
		//convert with switch case and validate the title of Amazon with contains()
		browser = "firefox";
		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("please pass the right browser ..." + browser);
			break;
		}
		
		driver.get("http://amazon.com");
		
		actualTitle = driver.getTitle();
		System.out.println("page title : " + actualTitle);
		
		if(actualTitle.contains("Amazon")) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
		
		driver.quit();
		
	}

}
