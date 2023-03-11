package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindowHandle {

	public static void main(String[] args) {
		

		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String parentWindowId = driver.getWindowHandle();
		
		//switch to a new blank  Tab/window
		driver.switchTo().newWindow(WindowType.TAB); // Selenium 4.x
		driver.switchTo().newWindow(WindowType.WINDOW); // Selenium 4.x
		
		//enter the url in the new tab/window
		driver.get("https://www.google.com");
		System.out.println("child window title: " + driver.getTitle());
		
		driver.close();//close the child window 
		// do not use .quit() until the end of the work otherwise we get the follow exception
		// driver.quit(); --> .NoSuchSessionException
		
		driver.switchTo().window(parentWindowId);	
		System.out.println("parent window title: " + driver.getTitle());
		
			
		//random pop-up: can NOT handle --> used in PROD
		//QA /Stage/Test  --> block these pop ups by the DevTeam
		
		
		

	}

}
