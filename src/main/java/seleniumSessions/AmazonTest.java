package seleniumSessions;

import seleniumSessions.utils.BrowserUtil;

public class AmazonTest {

	public static void main(String[] args) {

		String browserName = "chrome";

		BrowserUtil brUtil = new BrowserUtil();
		brUtil.initDriver(browserName);

		brUtil.launchURL("https://www.amazon.com");

		String actualTitle = brUtil.getPageTitle();
		if (actualTitle.contains("Amazon")) {
			System.out.println("title -- pass");
		} else {
			System.out.println("title -- faild");
		}

		String actualUrl = brUtil.getPageURL();
		if (actualUrl.contains("amazon")) {
			System.out.println("Url -- pass");
		} else {
			System.out.println("Url -- fail");
		}

		brUtil.quitBrowser();

		System.out.println("------ Homework ------");
		// Homework: do the same code for naveen automationlab with chrome,firefox and safari
		
		//chrome:

		browserName = "chrome";

		brUtil = new BrowserUtil();
		brUtil.initDriver(browserName);

		brUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=common/home");

		actualTitle = brUtil.getPageTitle();
		if (actualTitle.contains("naveen")) {
			System.out.println("title -- pass");
		} else {
			System.out.println("title -- faild");
		}

		actualUrl = brUtil.getPageURL();
		if (actualUrl.contains("naveen")) {
			System.out.println("Url -- pass");
		} else {
			System.out.println("Url -- fail");
		}

		brUtil.quitBrowser();
		
		//firefox
		browserName = "firefox";

		brUtil.initDriver(browserName);

		brUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=common/home");

		actualTitle = brUtil.getPageTitle();
		if(actualTitle.contains("naveen")) {
			System.out.println("title - pass");
		}else {
			System.out.println("title - fail");
		}

		actualUrl = brUtil.getPageURL();
		if(actualUrl.contains("naveen")) {
			System.out.println("Url - pass");
		}
		else {
			System.out.println("Url - fail");
		}
		
		brUtil.quitBrowser();
		
		//==============================
		//safari
		browserName = "safari";
		
		brUtil.initDriver(browserName);
		
		brUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
		
		actualTitle = brUtil.getPageTitle();
		if(actualTitle.contains("naveen")) {
			System.out.println("title - Pass");
		}
		else {
			System.out.println("title - Fail");
		}
		
		actualUrl = brUtil.getPageURL();
		if(actualUrl.contains("naveen")) {
			System.out.println("Url - Pass");
		}
		else {
			System.out.println("Url - Fail");
		}
		brUtil.quitBrowser();
	}

}
