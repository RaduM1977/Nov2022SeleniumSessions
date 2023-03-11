package seleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CricInfoTable {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		
		driver.get("https://www.espncricinfo.com/series/sa20-2022-23-1335268/mi-cape-town-vs-pretoria-capitals-20th-match-1343960/full-scorecard");
		Thread.sleep(2000);
		
		String wkName = getWicketTakername("Will Jacks");
		System.out.println(wkName);
		
		wkName = getWicketTakername("Rilee Rossouw");
		System.out.println(wkName);
		
		List<String> willJScoreList = getScoreCard("Will Jacks");
		System.out.println(willJScoreList);
		

	}
	
	//span[text()='Will Jacks']/ancestor::td/following-sibling::td//span/span
	public static String getWicketTakername(String batsManName) {
		
		return driver.findElement(By.xpath("//span[text()='"+batsManName+"']/ancestor::td/following-sibling::td//span/span")).getText();
	}

	public static List<String> getScoreCard(String playerName) {
		
		List<WebElement> scoreList =driver.findElements(By.xpath("//span[text()='"+playerName+"']/ancestor::td/following-sibling::td[contains(@class,'ds-text-right')]"));
		
		List<String> playerScoreList = new ArrayList<String>();
		
		for(WebElement e: scoreList) {
			String text = e.getText();
			playerScoreList.add(text);
		}
		return playerScoreList;
		
	}
}
