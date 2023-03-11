package seleniumSessions.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomCSSSelector {
	
	

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login");
		
		//By.cssSelector("");
		
		//in css if we have:
		// ********** #id
		
		//#input-firstname --> css selector
		//input[@id='#input-firstname'] --> xpath selector
		
		By fn = By.cssSelector("#input-firstname");
		
		
		//********tag#id
		//input#input-firstname --> css locator but faster 
		
		//******** class we use .
		//.className
		//.form-control
		//.login-email
		
		//************ tag.className
		//input.form-control
		//input.login-email
		
		//********.c1.c2.c3...cn
		//  .form-control.private-form__control.login-email
		
		//********** tag.c1.c2.c3...cn
		// input.form-control.private-form__control.login-email
		
		//tag.c3.c1.c2...cn
		//  input.login-email.form-control 
		
		
		
		//******** we can combine #id and .class ***********
		// tag#id.class
		// tag.class#id
		// #id.class
		// .class#id
		
		// #username.login-email.form-control 
		// .login-email.#username
		//input.login-email#username
		//input#username.login-email
		
		//********** tag.c1.c2.c3...cn#id
		//input#username.login-email.form-control 
		//input.login-email.form-control#username 
		
		// ******* other attributes:
		
		//  ********tag[attribute ='value]*********
		//  input[type='text'] --> css      //input[@type='value'] -->xpath
		//  input[placeholder='First Name']
		
		// when used a class with multiple values you need to use all the values in both css and xpath locators
		//  input[class='login-email'] --> css -- 0
		//input[@class='login-email'] --> xpath -- 0
		
		//input[contains(@class='login-email')] --> 1 --> xpath
		// input[class='form-control private-form__control login-email'] --> 1 --> css
		
		
		//***** multiple attributes: and []
		// tag[atribute1 = 'value'][attribute2 ='value'][atribute3 = 'value']
		
		// input[type ='text'][name='firstname'][palceholder ='First Name'] --> css
		//input[@type ='text' and @name='firstname' and @palceholder ='First Name'] --> xpath
		
		
		
		//***** tag#id[attribute ='value'] *********
		//   input#input-firstname[placeholder='First Name']
		//   input#input-firstname[placeholder='First Name'][type='text']
		//   input#input-firstname[placeholder='First Name'][type='text'].form-control
		
		
		// ******** css does NOT use text() --> not supported in CSS
		//   h1[text()='Register Account'] only xpath because the css does NOT support text 
		
		
		//***** contains: -->  *= used with  dynamic elements attributes
		//  tag[attribute *='value']
		//  input[placeholder *='First']
		//  input[class *='login-email']
		
		//******** starts-with: -->  ^=    --> used with  dynamic elements attributes
		//   tag[attribute^='value']
		//   input[placeholder ^='First']
		//   input[id ^='naveen_']
		
		//*********  ends-with: --> $= --> used with  dynamic elements attributes
		//  tag[attribute $='value']
		//  input[placeholder $='Name']
		
		
		
		// ****** parent to child: *******
		
		//    parent tag child tag --> it goes to grand- child --> indirect + direct child elements 
		//    div.private-form__input-wrapper input#username
		//    select#Form_getForm_Country option
		
		// ******** parent tag > child tag > child tag --> only to direct child elements
		
		// form#Form_getForm > select -- 0 --> direct child element
		// form#Form_getForm select -- 1 --> indirect + direct child elements
		
		//  form#hs-login > div --> 8 elemensts
		//  form#hs-login  div  --> 20 elements 
		
		
		
		//******* child  to parent: backward traversing? --> NOT available 
		// preceding sibling  --> NOT available 
		
		
		
		
		
		//  ********  OR is , in css: unique feature of CSS
		//  input#username,button#loginBTN,input#password,button#ssoBtn --> it will take all the elements which meet the Criteria
		//  img[title='naveenopencart'],input[name='search']
		
		//FEs(css).size() --> 3
		// used to check the elements are displayed 
		int  importantFieldsCount = driver.findElements(By.cssSelector("input#username,button#loginBTN,input#password,button#ssoBtn")).size();
		
		if(importantFieldsCount == 3) {
			System.out.println("PASS");
		}
		
	
		
		//******** not in CSS --> :not() <-- syntax:
		//  form-control private-form__control login-email
		//  form-control private-form__control login-password m-bottom-3
		
		//  input.form-control:not(input[name='search']) --> exclude the last one after the not()
		//  input.form-control:not(input[name='search'],input[name='firstname']) -- > exclude one more 
		
		
		
		//********* indexing in css:
		//  select#Form_getForm_Country > option:first-child --> better to use this one 
		//  select#Form_getForm_Country > option:last-child
		
		//  select#Form_getForm_Country > option:first-of-type
		//  select#Form_getForm_Country > option:last-of-type
		
		// ********** with-out tag first child
		//  select#Form_getForm_Country > :first-child
		//  select#Form_getForm_Country > :first-of-type
		
		// ******** get the specific position -->  nth-of-type:
		// select#Form_getForm_Country > option:nth-of-type(133)
		// select#Form_getForm_Country > option:nth-of-type(12) it could find the months
		// select#Form_getForm_Country > :nth-of-type(133)
		
		
		//**********   			xpath 			vs 					css:
//		1. syntax:     			complex								simple
//		2. ***text():			Yes									NO
//		3. AND:					Yes									Yes
//		4. OR:					Yes 								Yes, comma
//		5. forward:				Yes									Yes
//		6. ***backword:			Yes 								No
//		7. forward sibling:		Yes 								Yes
//		8. **Backword sibling: 	Yes 								No
//		9. **NOT:				No									Yes
//		10. index:				Yes									Yes
//		11. capture groupwith():  	Yes									No
//		12. performance:		Good								Good
//		13. startsWith:			Yes									Yes
//		14. contains:			Yes 								Yes
//		14. *****ends-with:			No									Yes
//		15. webtable:			easy								limited
		
		
		//**** sibling:
		//  label[for='input-email']+ input  --> 1 IMMEDIATE sibling
		//  div.private-form__input-wrapper ~ div --> all forward sibling
		
		
		
		//SVG
		//ShadowDOM
		//Graphs
	}

}
