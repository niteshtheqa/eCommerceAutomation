/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package icertis;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author nites
 *
 */
public class TestClass extends BaseTest {

	@Test(description = " Happy Path: Click on terms and conditions. In the new window, click I Accept. Now go back to the first window, and click on download MyDoc.pdf. Check if PDF document is downloaded.", priority = 1)
	public void testHappyPath() {
		Doc doc = page.getInstance(HomePage.class).clickOnTermsAndConditions();
		doc.acceptTermsAndCons();
		doc.navigateToParentWindow();
		page.getInstance(HomePage.class).downloadDocument();

	}

	@Test(description = "Directly click on download MyDoc.pdf. Check if this resulted in the appropriate 403 error page", priority = 2)
	public void testNoToc() {

		Error error = page.getInstance(HomePage.class).getDocWithoutTermsAndCons();
		Assert.assertEquals(error.printErrorMessage(), "You do not have permission to do that");

	}

	@Test(description = "Click on terms and conditions. Go to the new window, click I do not Accept. Now go back to the original window and click on download MyDoc.pdf. Check if this resulted in the appropriate 403 error page.", priority = 3)
	public void testNoAccept() {
		Doc doc = page.getInstance(HomePage.class).clickOnTermsAndConditions();
		doc.rejectTermsAndCons();
		doc.navigateToParentWindow();
		page.getInstance(HomePage.class).downloadDocument();
		
	}
}
