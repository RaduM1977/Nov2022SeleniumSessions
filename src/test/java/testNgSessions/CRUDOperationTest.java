package testNgSessions;

import org.testng.annotations.Test;

public class CRUDOperationTest {
	
	public void createUser() {
		System.out.println("create user");
	}
	
	public void getUser() {
		System.out.println("get user");
	}

	public void updateUser() {
		System.out.println("update user");
	}

	public void deleteUser() {
		System.out.println("delete user");
	}
	
	
	//this is the right way in the framework
	//every test has an independent work flow 
	//each test has to run independent from each other 
	
	@Test
	public void createUserTest() {
		createUser();//post
	}
	
	@Test
	public void getUserTest() {
		createUser();//post 
		getUser();//get
	}
	
	@Test
	public void updateUserTest() {
		createUser();//post -- 123
		getUser();//get  -- 123
		updateUser();//put
		getUser();//get
		
	}

	@Test
	public void deleteUserTest() {
		createUser();//post
		getUser();//get
		deleteUser();//delete
		getUser();//get
		
	}
	
	//the user id is hard coded and it is not a good practice 
//	@Test
//	public void getUserTesting(){
//		int userId = 123;//hard coded user id 
//		QA environment --- stage (may be a different user id )  -- dev -- UAT -- PROD
//		getUser(userId);
//		//
//	}
}
