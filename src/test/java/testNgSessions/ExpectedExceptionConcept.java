package testNgSessions;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {
	
	//u can make all the tests pass even with exception
	@Test(expectedExceptions = ArithmeticException.class) // do not put Exception.class the code doesn't look professional and all the tests will pass
	public void loginTest() {
		System.out.println("login test");
		int i = 9/0; //ArithmeticException
	}

}
