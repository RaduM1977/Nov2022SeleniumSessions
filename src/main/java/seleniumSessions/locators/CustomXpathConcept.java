package seleniumSessions.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpathConcept {
	

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		//xpath: address of the element in html DOM:
		
		//1. absolute xpath: /html/body/header/div/div/div[2]/div/input
		
		//2. relative Xpath: custom path
		
		//formula: 
		//tagName[@attributeName='attributeValue']
		//input[@id='input-email']
		
		//======== and:
		//tagName[@attributeName='attributeValue' and @attributeName='attributeValue']
		//input[@id='input-email' and @placeholder='E-Mail Address']
		//input[@type='text' and @name='email' and @id='input-email']
		
		
		//tag
		//input
		//a -- 81 Homework find the links with the xpath
		//img
		
		//============ OR:
		//input[@type='text' or @type='email']
		
		//============ xpath with text(): --> text is not an attribute, it is the text content of the element
		// do NOT use @text ... we use text() function
		
		/*
		tag[text()='value']
		h2[text()='Returning Customer']
		h2[text()='New Customer']
		a[text()='My Account']
		*/
		
		By newCus = By.xpath("//h2[text()='New Customer']");
		
		//check My Account links is present on the page -- two times
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		By myAccount = By.xpath("//a[text()='My Account']");
		int myAccountCount = driver.findElements(myAccount).size();
			if(myAccountCount == 2) {
				System.out.println("Pass");
			}
			
		driver.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By forgetPass = By.xpath("//a[text()='Forgotten Password']");
		
		int forgetPassCount = driver.findElements(myAccount).size();
			if(forgetPassCount == 2 ) {
				System.out.println("PASS");
			}
		

		
		//============= text() with attribute:
		//tag[@attr='value' and text()='value')]
		//h1[@class='h0-80' and text()='Love your software']
		
		//a[@class='list-group-item' and text()='Register']
		//a[text()='Register' and @class='list-group-item']
			
		//tag[@attr1='value' and @attr2='value' and text()='value']
		//a[text()='Register' and @class='list-group-item' and @href]	
		
		
		//a[@href] -81 links in naveen webpage
		
		//p[text()='Freshworks makes ridiculously easy-to-use marketing, sales, support and IT solutions.']
		
		//=============== contains() with attribute:
		//tag[contains(@attributeName,'value')]
		//input[contains(@placeholder,'E-Mail')]
		//input[contains(@placeholder,'Address')]
		
		// those are different xpath between contains and attribute name :
		//input[contains(@id,'input-email')]
		//input[@id='input-email']
		
		//============= contains() with one attribute and use another attribute without contains();
		//tag[contains(@attributeName,'value') and @attributeName ='value']
		//input[contains(@placeholder,'E-Mail') and @name='email']
		//input[contains(@placeholder,'E-Mail') and @name='email' and @type='text']
		
		//================= dynamic id/attribute: by refreshing the DOM
		//<input id = firstname_123>
		//<input id = firstname_456>
		//<input id = firstname_897>
		//By.id("firstname_123");-->NOT the right xpath
		//input[contains(@id,'firstname_')] --> right --> use the constant part
		
		
		//============= contains() with text(): =================
		//tagName[contains(text(),'value')]
		//p[contains(text(),'marketing, sales, support')]
		//h2[contains(text(),'50,000 companies')]
		//a[contains(text(),'Amazon')]
		
		//============= contains() with text() and contains() with attribute:
		//tagName[contains(text(),'value' and contains(@atributeName,'value')]
		//a[contains(text(),'Science') and contains(@href,'amazon.science')]
			
		
		//============= contains() with text() and attribute with NOT contains():
		//tagName[contains(text(),'value' and @atributeName,'value']
		//a[contains(text(),'Science') and @class='nav_a']
		
		//============= starts-with():
		//tagName[starts-with(text(),'value')]
		//a[starts-with(text(),'Amazon')]
		//small[starts-with(text(),'Free CRM has powerful call tracking')]
			
		//input[starts-with(@aria-labelledby,'UIFormControl') and @type='email']
			
		//a[starts-with(@href,'https://naveenautomationlabs.com/')]
		
		//****** ends-with() in xpath?? --> Not supported anymore 
			
			
			
			
		
		//****position/index in xpath: --> we can use position() and last() --> NOT like java the index in DOM starts from 1
			
		// (//input[@class='form-control'])[2]
		By.xpath("(//input[@class='form-control'])[2]");
		
		// (//input[@class='form-control'])[position()=1]
		// (//input[@class='form-control'])[6]
		// we can find the last element by using the last() --> function
		// (input[@class='form-control'])[last()] or (//input[@class='form-control'])[last()-2]
		
		// footer help link in Amazon : -->
		// ((//div[contains(@class,'navFooterLinkCol')])[last()]//a)[last()]
		// ((//div[contains(@class,'navFooterLinkCol')])[last()]//a)[last()-1]
		String actualHelp = driver.findElement(By.xpath("((//div[contains(@class,'navFooterLinkCol')])[last()]//a)[last()]")).getText();
		
		//************* class in locator: className, xpath, css
		
		//input[@class='form-control private-form__control login-password m-bottom-3']  --> valid for xpath
		//input[@class='login-email'] --> not valid for xpath
		
		By.className("form-control private-form__control login-password m-bottom-3"); // not valid for className-- only ONE class 
		By.className("login-email"); //--> valid with className 
		By.xpath("//input[contains(@class,'login-email')]"); // --> valid with xpath with contains() function
		
		
		//***** parent to child:
		
		// parent/child --> direct
		//parent//child --> direct + indirect
		
		//***** child to parent:
		// Backward traversing in xpath: /../../../../../../../../../..
		
		
		
		//siblings:
		//input[@id='input-email']/preceding-sibling::label
		driver.findElement(By.xpath("//input[@id='input-email']/preceding-sibling::label")).getText(); // this can be an automation test case -> What is the label of this element
		
		//label[@for='input-email']/following-sibling::input[@name='email']
		
		
		//Dynamic tables:
		
		//a[contains(text(),'Ali khan']/../preceding-sibling::td/input[@type='checkbox']
		//a[contains(text(),'Romi singh']/parent::td/preceding-sibling::td/input[@type='checkbox']
		//a[text()='deepti gupta']/parent::td/preceding-sibling::td/input[@type='checkbox']
		
		//   (//a[contains(text(),'Ali khan']/parent::td/following-sibling::td)[position()=1]/a
		//   or
			//a[text()='Ali khan']/parent::td/following-sibling::td//a[@context='company']
		
		// to find the phone numbers of this field
		//a[contains(text(),'Ali khan']/parent::td/following-sibling::td/span
		
		//******** ancestor :
		//span[text()='Jordan Hermann']/../../../following-sibling::td//span
		//span[text()='Jordan Hermann']/ancestor::td/following-sibling::td//span
		//  (//span[text()='Jordan Hermann']/ancestor::td/following-sibling::td//span)[2]
		

		
		
		
//		Naveen Automation Labs OpenCart : https://naveenautomationlabs.com/opencart/
//
//			Automation Book Store: https://automationbookstore.dev/
//
//			Automation Test Store: https://automationteststore.com/
//
//			DemoBlaze: https://www.demoblaze.com/
//
//			DemoQA: https://demoqa.com/
//
//			ParaBank: https://parabank.parasoft.com/parabank/index.htm
//
//			SelectorsHub: https://selectorshub.com/xpath-practice-page/
//
//			Selenium Test Pages: https://testpages.herokuapp.com/styled/index.html
//
//			Swag Labs: https://www.saucedemo.com/
//
//			The Internet: https://the-internet.herokuapp.com/
//
//			UI Test Automation Playground: http://uitestingplayground.com/
//
//			XYZ Bank: https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
		
		
		// login information for free.crm
		//groupautomation/Selenium@12345
		//newautomation/Selenium@12345
		
		
		
		// code for selecting the country and then the state :
		
//		for(int i=0; i<countrylist.size(); i++) {
//			System.out.println(countryList.get(i).getText());
		
//			countrylist.get(i).click();
//			
//			stateList = driver.findElements(statelocator);
		
//			for(WebElement e : stateList) {
//				System.out.println(e.getText());
//			}
//		}
		
		
		
		//* wild card 
		
		//*[@id='input-firstname'] --> 100 
		//input[@id='input-firstname'] --> 10 (only 10 have input) so this is faster --> 1
		
		
		
	}

}
