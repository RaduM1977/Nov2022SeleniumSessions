package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalLinks {

	static WebDriver driver;
	
	public static void main(String[] args) {
		//throw new NoSuchElementException(); we use the NSE from Selenium 
		
		// find all links on the page 
		// print the total links on the page 
		// print the text of each link 
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		//find all the links on the page
		List<WebElement> linksList = driver.findElements(By.tagName("a"));// --> the tag name for links is a
		
		// print the total links on the page 
		int linksCount = linksList.size();
		System.out.println("total links: " + linksCount);
		
		
		// print the text of each link 
		//avoid the blank text
		//get total blank links count ?? -- count Homework
		
//		for(int i =0;i < linksCount;i++) {
//			String text = linksList.get(i).getText();
//			if(text.length()>0) { // it will not print the blank links
//				System.out.println(i+ " : " + text);
//			}
//		}
		
		// for each loop 
		//print the index too
		
		int blankCount =0;
		int count =0;
		for(WebElement e : linksList) {
			String text = e.getText();
				if(text.length()>0) { // condition for not blank text --> if text link is not display(blank),then the length() of the String is 0
					System.out.println(count + " : " + text);
					count++;
				}else {
					blankCount++;
				}
					//count++;
				
		}
		
		System.out.println("the number of blank links are: "+ (linksCount - count));
		System.out.println("the number of blank links are: "+ blankCount);
		
		driver.quit();
		
		
	
	//Homework : 
	// https://classic.crmpro.com/
	//find all the p elements and count them 
		
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/");
		
		int countP = 0;
		
		List<WebElement> pList = driver.findElements(By.tagName("p"));
		int numberOfP = pList.size();
		System.out.println(numberOfP);
		
		for(WebElement e : pList) {
			System.out.println(countP + " : " + e.getText());
			countP++;
		}
		
		
	}
}
