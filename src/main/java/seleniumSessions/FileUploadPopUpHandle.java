package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPopUpHandle {

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		
		
		//it works only if the attribute type='file' is present --> do not click but sendKeys
		
		driver.findElement(By.name("upfile")).sendKeys("/Users/radum/Desktop/usaFlag.png");
		
		//<tag type="file"> --> this is mandatory attribute
		
		//autoIT/Sikuli/Robot(only for windows machine) --> not recommended solution
		
	

	}
	
	

}
