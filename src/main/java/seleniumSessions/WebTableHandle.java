package seleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandle {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		//initialize the driver 
		driver = new ChromeDriver();
		
		driver.get("https://classic.freecrm.com/");
		Thread.sleep(2000);
		
		//login to the application 
		driver.findElement(By.name("username")).sendKeys("newautomation");
		driver.findElement(By.name("password")).sendKeys("Selenium@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Thread.sleep(2000);
		//we switch to the right frame
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.linkText("CONTACTS")).click(); //-->we put what is in the page not in the DOM
		
		//driver.findElement(By.xpath("//a[text()='Ali khan']/parent::td/preceding-sibling::td/input[@type='checkbox']")).click();
		
		selectUser("deepti gupta");
		//Thread.sleep(1000);
		selectUser("Ali khan");
		selectUser("Romi singh");
		
		String cName = getUserCompanyName("Ali khan");
		System.out.println(cName);
		
		cName = getUserCompanyName("deepti gupta");
		System.out.println(cName);
		
		cName = getUserCompanyName("Romi singh");
		System.out.println(cName);
		
		String emailName = getUserEmail("Ali khan");
		System.out.println(emailName);
		
		List<String> userPhones = getUserPhones("Ali khan");
		System.out.println(userPhones);
		
		String user = getUser("Ali khan");
		System.out.println(user);
		
		
	}

	//driver.findElement(By.xpath("//a[text()='deepti gupta']/parent::td/preceding-sibling::td/input[@type='checkbox']")).click();
	// this is dynamic xpath 
	public static void selectUser(String userName) {
		driver.findElement(By.xpath("//a[text()='"+userName+"']/parent::td/preceding-sibling::td/input[@type='checkbox']")).click();

	}
	
	
	public static String getUserCompanyName(String userName) {
		return driver.findElement(By.xpath("//a[text()='"+userName+"']/parent::td/following-sibling::td/a[@context='company']"))
		.getText();
	}
	
	public static String getUserEmail(String userName) {
		return driver.findElement(By.xpath("//a[text()='"+userName+"']/parent::td/following-sibling::td/a[contains(text(),'@') and contains(text(),'.') and contains(@href,'mail')]"))
		.getText();
	}
	
	public static List<String> getUserPhones(String userName) {
		
		List<String> phones = new ArrayList<String>();
		List<WebElement> listOfPhones = driver.findElements(By.xpath("//a[text()='Ali khan']/parent::td/following-sibling::td/span[@context='phone']"));
		for(WebElement e: listOfPhones) {
			phones.add(e.getText());
		}
		return phones;
		
	}
	
	public static String getUser(String userName) {
		return driver.findElement(By.xpath("//a[text()='"+userName+"']")).getText();
	}
	
}
