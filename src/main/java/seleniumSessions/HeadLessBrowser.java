package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadLessBrowser {

	public static void main(String[] args) {
		

		//browser is not visible 
		//headless - testing is happening behind the scene
		//faster then the normal mode and it runs behind the scene and you can do other things on your computer 
		
		//sanity test cases is fine but for some complex html DOM cases may not work 
		
		ChromeOptions co = new ChromeOptions();
		//co.setHeadless(true);
		
		//another option 
		//co.addArguments("--headless");
		
		//Incognito mode 
		co.addArguments("--incognito");
		
		
		// we can use both arguments 
		WebDriver driver = new ChromeDriver(co); // Supply the co in the driver
		
		driver.get("https://naveenautomationlabs.com/opencart/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		driver.quit();

		
	
		
	}

}
