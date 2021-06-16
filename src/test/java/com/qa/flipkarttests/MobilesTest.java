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
import com.qa.objectrepo.Electronics;
import com.qa.objectrepo.Mobiles;

/**
 * @author nites
 *
 */
public class MobilesTest extends BaseTest {
	@Test(priority = 1, enabled = false)
	public void verifyMobilePageTitle() {
		String mobilePageTitle = page.getInstance(FlipkartLoginPage.class)
				.doFlipkartLogin("8983661435", "I@Mitengg2611").getInstance(FlipkartHomePage.class).navigateToMobiles()
				.getInstance(Electronics.class).getInstance(Mobiles.class).getPageTitle();
		assertEquals(mobilePageTitle,
				"Apple Products Store Online - Buy Apple Products Online at Best Price in India | Flipkart.com");
	}

	@Test(priority = 2, enabled = false)
	public void verifyMobilePageHeader() {
		Mobiles mobiles = page.getInstance(FlipkartLoginPage.class).doFlipkartLogin("8983661435", "I@Mitengg2611")
				.getInstance(FlipkartHomePage.class).navigateToMobiles().getInstance(Electronics.class)
				.getInstance(Mobiles.class);
		String mobileHeader = mobiles.getMobilePageHeader();
		assertEquals(mobileHeader, "Apple Store");
	}

	@Test(priority = 3, enabled = true)
	public void verifySelectMobile() {
		Mobiles mobiles = page.getInstance(FlipkartLoginPage.class).doFlipkartLogin("8983661435", "I@Mitengg2611")
				.getInstance(FlipkartHomePage.class).navigateToMobiles().getInstance(Electronics.class)
				.getInstance(Mobiles.class);
		mobiles.selectIphone7Plus();

	}
}
