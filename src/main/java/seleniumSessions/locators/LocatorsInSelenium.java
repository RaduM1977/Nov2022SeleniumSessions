package seleniumSessions.locators;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsInSelenium {
	
	
	
		static WebDriver driver;
		
	public static void main(String[] args) {
		// 8 locators:
		// id, name, classname,   xpath, css selector,   linktext, partial linktext,    tagname
		
		driver = new ChromeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//1. id - unique(attribute)
		//driver.findElement(By.id("input-email")).sendKeys("test@gmail.com");

		//2. name: can be duplicate (attribute)
//		driver.findElement(By.name("email")).sendKeys("test@gmail.com");
//		By emailId = By.name("email");
		
		//3. class name(attribute)-->  class locator can have more then one class separate by SPACE
		//class locator can be duplicate not recommended --> use only if it is unique
		driver.findElement(By.className("form-control")).sendKeys("test@gmail.com");
		
		
		
		//4. xpath: is is NOT an attribute. it is an address of the element in HTML DOM
//		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("test@gmail.com");
//		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("test@123");
//		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
//		
//		By emailId = By.xpath("//*[@id=\\\"input-email\\\"]");
//		By password = By.xpath("//*[@id=\"input-password\"]");
//		By loginBtn = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
//		
//		doSendKeys(emailId,"naveen@gmail.com");
//		doSendKeys(emailId,"naveen@123");
//		doClick(loginBtn);
		
		//5. css selector : NOT an attribute 
//		driver.findElement(By.cssSelector("#input-email")).sendKeys("test@gmail.com");
//		driver.findElement(By.cssSelector("#input-password")).sendKeys("test@123");
//		driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input")).click();
	
		// ======= Homework =========
		// use the By method for css
		
//		By emailId = By.cssSelector("#input-email");
//		By password = By.cssSelector("#input-password");
//		By loginBtn = By.cssSelector("#content > div > div:nth-child(2) > div > form > input");
//		
//		doSendKeys(emailId,"test@gmail.com");
//		doSendKeys(password,"#input-password");
//		doClick(loginBtn);
		
		
		//6. linkText: ONLY applicable by links --> htmltag for link is = a --> linktext can be duplicate
		//it is NOT an attribute 
		//driver.findElement(By.linkText("Register")).click();
		
		//By registerLink = By.linkText("Register");
		//doClick(registerLink);
		
		//7. partialLinktext: ONLY for links
		//it is NOT an attribute 
		//Forgotten Password
		//Forgotten UserId
		//driver.findElement(By.partialLinkText("Forgotten")).click();
		
		//8. tagName: htmlTag
		String header = driver.findElement(By.tagName("h2")).getText();
		System.out.println(header);
		
		//getText: links, headers, paragraph, footer
		By payment = By.linkText("Recurring payments");
		String val = doElementGetText(payment);
		System.out.println(val);
		
		//getText: -->  links, headers, paragraph, footer
		//click: --> button, checkboxes, radiobutton, images, links
		//sendKeys:   -->textbox/textfield, dropdown, fileupload
		
		//driver.close();
		
		
		//============= Homework : ===========
		//fill the form with the combination click the agree box and continue on the next page capture the text "your account was created"
		//click: all the links on the website 
		
		//driver = new ChromeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		By firstName = By.id("input-firstname");
		By lastName = By.id("input-lastname");
		By email = By.id("input-email");
		By telephone = By.id("input-telephone");
		By password = By.id("input-password");
		By confirmPassword = By.id("input-confirm");
		
		By check = By.name("agree");
		By continueButton = By.cssSelector("#content > form > div > div > input.btn.btn-primary");
		
		
		doSendKeys(firstName,"Naveen");
		doSendKeys(lastName,"Teacher");
		Random random = new Random();
		int number = random.nextInt(100);
		doSendKeys(email,"mytest" + number +"@gmail.com");
		doSendKeys(telephone,"1.312.364.7634");
		doSendKeys(password,"123@test");
		doSendKeys(confirmPassword,"123@test");
		
		doClick(check);
		doClick(continueButton);
		
		By message = By.tagName("h1");
		String actualMessage = doElementGetText(message);
		if(actualMessage.equals("Your Account Has Been Created!")) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}
		driver.close();
		
	}
	
	//Generic method
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}

	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static String doElementGetText(By locator) {
		return getElement(locator).getText();
	}
}
