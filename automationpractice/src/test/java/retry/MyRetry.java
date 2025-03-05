package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetry implements IRetryAnalyzer{
	
	private int retryCount=0;
	private static final int maxRetry=3;
	public boolean retry(ITestResult result) {
		if(retryCount<maxRetry) {
			retryCount++;
			return true;
		}
		return false;
	}
}
