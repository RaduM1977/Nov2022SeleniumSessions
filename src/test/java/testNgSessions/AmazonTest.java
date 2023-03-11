package testNgSessions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest extends BaseTest{
	
	
	//this approach is better with stable application , sanity test or less tcs or less navigation 
	//the end user is using this approach 
	
	//this is not a good practice --> Not valid format 
	
//	@Test
//	public void amazanPageTest() {
//		
//		System.out.println("checking title...");
//		String title = driver.getTitle();
//		System.out.println("page title: " + title);
//		Assert.assertEquals(title, "Amazon.com. Spend less. Smile more.");
//		
//		System.out.println("checking search ...");
//		boolean flag = driver.findElement(By.id("twotabsearchtextbox")).isDisplayed();
//		Assert.assertTrue(flag);
//		
//		System.out.println("checking help ...");
//		boolean flag1 = driver.findElement(By.linkText("Help")).isDisplayed();
//		Assert.assertTrue(flag1);
//	}
	
	
	
	//tcs - test cases should be independent
	//good for the regression tcs and for more tcs and 
	
	// AAA rule --> Arrange,Act and Assert
	
	// 1 tc --> 1 assert rule 
	
	@Test(priority = 1)
	public void titleTest() {
		//driver.get("http://www.amazom.com"); --> moved to BaseTest
		String title = driver.getTitle();
		System.out.println("page title: " + title);
		Assert.assertEquals(title, "Amazon.com. Spend less. Smile more.");
	}
	
	@Test(priority = 2)
	public void searchExistTest() {
		boolean flag = driver.findElement(By.id("twotabsearchtextbox")).isDisplayed();
		Assert.assertTrue(flag);
	}
	
	
	//it will run in alphabetical order this will go first 
	@Test(priority = 3)
	public void isHelpExistTest() {
		boolean flag = driver.findElement(By.linkText("Help")).isDisplayed();
		Assert.assertTrue(flag);
	}
	

	
}
