/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package com.qa.flipkarttests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.qa.basetest.BaseTest;
import com.qa.flipkartpages.FlipkartHomePage;
import com.qa.flipkartpages.FlipkartLoginPage;

/**
 * @author nites
 *
 */
public class FlipkartHomePageTest extends BaseTest {

	FlipkartHomePage flipkartHomePage;

	@Test(priority =1 ,enabled = false)
	public void verifyHomePageTitle() {
		flipkartHomePage = page.getInstance(FlipkartLoginPage.class).doFlipkartLogin("8983661435", "I@Mitengg2611");
		String loginPageTitle = page.getInstance(FlipkartHomePage.class).getPageTitle();
		String expectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		assertEquals(loginPageTitle, expectedTitle);
	}

	@Test(priority =2,enabled = false)
	public void verifyHomePageHeader() {
		flipkartHomePage = page.getInstance(FlipkartLoginPage.class).doFlipkartLogin("8983661435", "I@Mitengg2611");
		String username = page.getInstance(FlipkartLoginPage.class).getLoggedInUser();

		assertEquals(username, "Nitesh");
	}

	@Test(priority =3)
	public void verifyUserNavigateToElectronicsPageTest() {
		flipkartHomePage = page.getInstance(FlipkartLoginPage.class).doFlipkartLogin("8983661435", "I@Mitengg2611");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		page.getInstance(FlipkartHomePage.class).navigateToMobiles();
	}

}
