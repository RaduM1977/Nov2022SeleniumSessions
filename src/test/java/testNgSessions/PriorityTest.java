package testNgSessions;

import org.testng.annotations.Test;

public class PriorityTest {
	
	//if the same priority on 2 tests than the alphabetical order will take place
	//0 or negative will be executed first 
	//the non priority tests will run first and then the order of priority
	
	@Test()
	public void a_test() {
		System.out.println("a test");
	}

	@Test()
	public void b_test() {
		System.out.println("b test");
	}
	
	@Test()
	public void c_test() {
		System.out.println("c test");
	}
	
	@Test(priority = 1)
	public void d_test() {
		System.out.println("d test");
	}
	
	@Test(priority = 2)
	public void e_test() {
		System.out.println("e test");
	}
}
