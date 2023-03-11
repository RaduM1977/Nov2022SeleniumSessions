package testNgSessions;

import org.testng.annotations.Test;

public class InvocationCount {

	
	//you can do a performance test ex: load test 
	//it will run 10 times 
	@Test(invocationCount = 10)
	public void createUSerTest() {
		System.out.println("create user");
	}
	
	
	
}
