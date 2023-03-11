package testNgSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchPageTest {
	
public WebDriver driver;
	
	public boolean doSearch(String search,String product) {
		
		driver.findElement(By.name("search")).clear();
		driver.findElement(By.name("search")).sendKeys(search,Keys.ENTER);
		
		driver.findElement(By.linkText(product)).click();
		
		String productMessage =
				driver.findElement(By.tagName("h1")).getText();
		
		if(productMessage.contains(product)) {
			return true;
		}
		return false;
	}
	
	
	// for multiple data we use data providers
	@DataProvider
	public Object[][] getSearchTestData(){ //[3][2]
		
		//int random = ThreadLocalRandom.current().nextInt();
		return new Object [][]{
			{"macbook","MacBook Air"},
			{"samsung","Samsung SyncMaster 941BW"},
			{"nikon","Nikon D300"},
		};
	}
	
	//test
	@Test(dataProvider = "getSearchTestData")
	public void searchTest(String search, String product ) {
		System.out.println(search+ " : "+ product );
		Assert.assertTrue(doSearch(search,product));
	}
	
	
	//before and after method 
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
