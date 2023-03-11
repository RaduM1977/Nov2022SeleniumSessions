package seleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTableHandeling {

	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		int headerCount = getTableHeaderCount();
		System.out.println("head count" + headerCount);
		
		int rowCount = getRowCount();
		System.out.println("row count" + rowCount);
		
		
		//table[@id="customers"]/tbody/tr[2]/td[1]
		//table[@id="customers"]/tbody/tr[3]/td[1]
		//table[@id="customers"]/tbody/tr[4]/td[1]
		
		//table[@id="customers"]//tr/td[1]
		
		String beforeXpath = "//table[@id=\"customers\"]/tbody/tr[";
		String afterXpath = "]/td[1]";
		
		for(int row=2; row<=7; row++) {
			
			String xpath = beforeXpath + row + afterXpath;
			System.out.println(xpath);
			String value = driver.findElement(By.xpath(xpath)).getText();
			System.out.println(value);
		}
		
		// find other rows from a static table:
		System.out.println("------- Second colum ---------");
		List<WebElement> firstRow = driver.findElements(By.xpath("//table[@id=\"customers\"]//tr/td[2]"));
		for(WebElement e : firstRow) {
			System.out.println(e.getText());
		}
		
		System.out.println("------- Third colum ---------");
		List<WebElement> secondRow = driver.findElements(By.xpath("//table[@id=\"customers\"]//tr/td[3]"));
		for(WebElement e : secondRow) {
				System.out.println(e.getText());
		}
			
		List<String> columValues = getColumnElements(3);
		System.out.println(columValues);
		
	}

	
	// number of headers in the table --> th
	public static int getTableHeaderCount() {
		return driver.findElements(By.xpath("//table[@id='customers']//th")).size();
	}
	
	// number of rows in the table excluding the th ==> tr
	public static int getRowCount() {
		
		return driver.findElements(By.xpath("//table[@id='customers']//tr")).size()-1;
	}
	
	
	public static List<String> getColumnElements(int colum) {
		List<WebElement> columElements = driver.findElements(By.xpath("//table[@id=\"customers\"]//tr/td["+colum+"]"));
		List<String> columElementText = new ArrayList<String>();
		
		for(WebElement e : columElements) {
			String text = e.getText();
			columElementText.add(text);
		}
		return columElementText;
	}
	
	
}
