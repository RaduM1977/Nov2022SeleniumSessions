package testNgSessions;

import org.testng.annotations.Test;

public class TestDependency {
	
	
	//bad practice to create dependencies between tests because in the parallel mode it may not work
	@Test
	public void searchTest() {
		System.out.println("searchTest");
		//int i =9/0;
	}
	
	@Test(dependsOnMethods = "searchTest")
	public void addToCartTest() {
		System.out.println("addToCart");
		int i =9/0;
	}
	
	@Test(dependsOnMethods = "addToCartTest")
	public void makePayment() {
		System.out.println("makePayment");
	}

}
