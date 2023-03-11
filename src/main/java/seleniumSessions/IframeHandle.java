package seleniumSessions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeHandle {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		
		//page
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//click the image 
		driver.findElement(By.xpath("//img[@title='vehicle-registration-forms-and-templates']")).click();
		
		Thread.sleep(2000);
		//Homework: fill out the form
		
		//frame 
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'frame-one')]")));
		
		driver.findElement(By.id("RESULT_TextField-2")).sendKeys("2010");
		driver.findElement(By.id("RESULT_TextField-3")).sendKeys("Honda");
		driver.findElement(By.id("RESULT_TextField-4")).sendKeys("Civic");
		driver.findElement(By.id("RESULT_TextField-5")).sendKeys("White");
		driver.findElement(By.id("RESULT_TextField-6")).sendKeys("85954");
		driver.findElement(By.id("RESULT_TextField-7")).sendKeys("1213OIWEWPOIENDSMND139298319");
		driver.findElement(By.id("RESULT_TextField-8")).sendKeys("John Doe");
		driver.findElement(By.id("RESULT_TextField-9")).sendKeys("123 Main Str");
		driver.findElement(By.id("RESULT_TextField-10")).sendKeys("Unit 12");
		driver.findElement(By.id("RESULT_TextField-11")).sendKeys("Chicago");
		
		driver.findElement(By.id("RESULT_RadioButton-12")).sendKeys("Illinois");
		
		driver.findElement(By.id("RESULT_TextField-13")).sendKeys("60640");
		driver.findElement(By.id("RESULT_TextField-14")).sendKeys("312 986 0992");
		driver.findElement(By.id("RESULT_TextField-15")).sendKeys("anyemail@email.com");
		driver.findElement(By.id("FSsubmit")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		
		//do not forget to come back to the main page from the iframe/frame
		//also you can switch between frames with frame()
		//also you can check if you are outside of the frame
		driver.switchTo().defaultContent();

	}

}
