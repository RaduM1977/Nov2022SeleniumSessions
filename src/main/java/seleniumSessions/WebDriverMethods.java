package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethods {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		//methods():
		
		driver.get("http://www.amazon.com");
		
		driver.manage().window().maximize();
		//driver.manage().window().fullscreen(); --> for bigger screens or very big
		// when u do manual testing you clear the cookies and cache 
		
		driver.manage().deleteAllCookies();// to clear the temporary memory --> good practice for manual testing
		
		//get the current URL
		String url = driver.getCurrentUrl(); // return a String 
		System.out.println(url);
		
		if(url.contains("www.amazon.com")) {
			System.out.println("PASS");
		}
		
		//get the page source page 
		String pgSrc = driver.getPageSource();
		
		System.out.println(pgSrc);
		
		if(pgSrc.contains("NAVYAN")){
			System.out.println("PASS");
		}
		
		driver.quit();

	}

}
