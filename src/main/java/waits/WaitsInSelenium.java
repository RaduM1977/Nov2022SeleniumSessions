package waits;

public class WaitsInSelenium {

	public static void main(String[] args) {
		
			
		//script -- sync -----------------> app
		//script -- synchronization ------> slow/fast/very slow
		
		//********* types of waits:
		//1. static wait: Thread.sleep(5000) --> pause for 5 secs --> this is a JAVA feature 
		
		//2. dynamic wait: 10 secs --> if the element is found in 2 secs --> the other 8 secs will be ignored
		
				//2.a:  Implicitly Wait: -> global wait for all the elements, not working for nonElements 
		
				//2.b:  Explicit Wait:  -> ON a specific element + polling/interval time + non webElements
						//i. WebDriverWait
						//ii. FluentWait
		
		//WebDriverWait(Class) --> FluentWait(Class) --> Wait(Interface) : --> until(method) - no body because it belongs in the Wait Interface
								//Overridden in until() {} it will be implemented in the FluentWait
									//other methods{}
		
		// to zoom the page in the DOM we put in the console the following JS method

	}

}
