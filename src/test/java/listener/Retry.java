package listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	
	int min =0;
	int max =1;

	public boolean retry(ITestResult res) {
	
		if(min<=max){
			
			System.out.println("Retrying testcase : " + res.getName());
			System.out.println("Retrying counter :  "+ (min+1));
			min++;
			return true;
			
		}
		
		return false;
	}

	}
