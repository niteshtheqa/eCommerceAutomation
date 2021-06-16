/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package com.qa.flipkarttests;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

import com.qa.basetest.BaseTest;
import com.qa.flipkartpages.FlipkartHomePage;
import com.qa.flipkartpages.FlipkartLoginPage;

/**
 * @author nites
 *
 */
public class FlipkartLoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		String loginPageTitle = page.getInstance(FlipkartLoginPage.class).getLoginPageTitle();
		String expectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		assertEquals(loginPageTitle, expectedTitle);
	}

	@Test(priority = 2)
	public void verifyLoginPageHeaderTest() {
		String loginPageHeader = page.getInstance(FlipkartLoginPage.class).getLoginPageHeader();
		String expectedHeader = "Plus";
		assertEquals(loginPageHeader, expectedHeader);

	}

	@Test(priority = 3)
	public void verifyDoLoginTest() {
		FlipkartHomePage flipkartHomePage = page.getInstance(FlipkartLoginPage.class).doFlipkartLogin("8983661435",
				"I@Mitengg2611");
		String username = page.getInstance(FlipkartLoginPage.class).getLoggedInUser();

		assertEquals(username, "Nitesh");
	}
}
