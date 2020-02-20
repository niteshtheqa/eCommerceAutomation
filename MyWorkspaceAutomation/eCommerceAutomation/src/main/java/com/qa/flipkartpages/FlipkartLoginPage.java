/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package com.qa.flipkartpages;

import org.openqa.selenium.WebDriver;

import com.qa.basepages.BasePage;
import com.qa.objectrepo.LoginPageRepo;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

/**
 * @author nites
 *
 */
public class FlipkartLoginPage extends BasePage {
	LoginPageRepo loginPageRepo = new LoginPageRepo(driver);

	/**
	 * @param driver
	 */
	public FlipkartLoginPage(WebDriver driver) {
		super(driver);

	}

	public String getLoginPageHeader() {
		return waitForElement(loginPageRepo.getHeader()).getText();
	}

	public String getLoginPageTitle() {
		return loginPageRepo.getPageTitle();
	}
	
	public String getLoggedInUser() {
		return waitForElementWithFluentWait(loginPageRepo.getUser()).getText();
	}

	public FlipkartHomePage doFlipkartLogin(String username, String password) {
		//waitForElementWithFluentWait(loginPageRepo.getCrossLoginWindow()).click();
		waitForElementWithFluentWait(loginPageRepo.getLoginLink());
		waitForElement(loginPageRepo.getUsername()).sendKeys(username);
		waitForElement(loginPageRepo.getPassword()).sendKeys(password);
		waitForElement(loginPageRepo.getLoginBtn()).click();

		return getInstance(FlipkartHomePage.class);
	}
}
