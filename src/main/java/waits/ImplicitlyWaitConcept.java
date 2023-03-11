package waits;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitlyWaitConcept {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS); // sel 3.x deprecated method 
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// sel 4.x
		
		//******global wait: 10 secs --> it will be applied for all the elements by default
		// implicitly wait goes with the driver for all the elements
		//FE(find element) --> imp wait will be applied automatically
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		driver.findElement(By.id("input-email")).sendKeys("naveen@gmail.com");//10 -> 5 = 5
		driver.findElement(By.id("password")).sendKeys("naveen@1234");//10 ->2 = 8
		driver.findElement(By.xpath("//button[@value='Login']")).click();//10-6 = 4
		
		//e4 -- 10 
		//e4 -- 10
		//e5 -- 10
		
		//home page: 20 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));// sel 4.x
		//global wait: 20 secs
		//e7 e8 e9 -- 20 secs
		
		//login page: 20 secs --> 10 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// sel 4.x
		
		//register: 5 secs:
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// sel 4.x
		
		//login:
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// sel 4.x
		
		//forgot password page : 0 secs -- nullify of imp wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));// sel 4.x
		
		//********** in the framework never use implicitly wait recently may be taking out
		
		//works only for webElements: svg,iframe,WEs
		//it does not support non web elements: title,url,alerts-js
		
		//cvpres/playwrite --> auto wait 
		// cy vs selenium --> Selenium is faster
		

	}

}
