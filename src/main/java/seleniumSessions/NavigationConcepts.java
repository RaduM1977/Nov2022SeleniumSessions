package seleniumSessions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationConcepts {

	public static void main(String[] args) throws MalformedURLException {
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		System.out.println(driver.getTitle());
		
		// we use to when we need to create the object of the URL rarely in this format 
		driver.navigate().to(new URL("https://www.amazon.com/"));
		
		//driver.navigate().to("https://www.amazon.com/");
		System.out.println(driver.getTitle());
		
		//browser elements:
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		driver.navigate().refresh();//refresh the page 
		
		//System.out.println(driver.getPageSource());
		
		//driver.quit();//123
		driver.close();//123 
		
		//driver.getTitle() -->close() - sesion id 123 but invalid 
						  //-->quit() - sesion id is null
		
	
	}

}
