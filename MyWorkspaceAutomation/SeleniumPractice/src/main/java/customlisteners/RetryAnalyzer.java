/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package customlisteners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

/**
 * @author nites
 *
 */
@Listeners
public class RetryAnalyzer implements IRetryAnalyzer {

	int limit = 3;
	int maxretryCounter = 1;

	@Override
	public boolean retry(ITestResult result) {
		if (!result.isSuccess()) {
			while (maxretryCounter < limit) {
				System.out.println("Test retry count for" + result.getName() + "==>" + result.getStatus() + "==>"
						+ maxretryCounter);
				maxretryCounter++;

			}
			return false;
		}
		result.setStatus(result.SUCCESS);
		return true;

	}

}
