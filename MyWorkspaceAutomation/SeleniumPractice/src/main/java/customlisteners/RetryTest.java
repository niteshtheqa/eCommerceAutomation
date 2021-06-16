/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package customlisteners;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author nites
 *
 */
public class RetryTest {
	@Test
	public void doLogin() {
		System.out.println("Executing doLogin test");
	}

	@Test
	public void doLogin1() {
		Assert.fail("failed");
	}
}
