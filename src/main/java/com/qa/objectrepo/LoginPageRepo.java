/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package com.qa.objectrepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.basepages.BasePage;

/**
 * @author nites
 *
 */
public class LoginPageRepo extends BasePage {
	/**
	 * @param driver
	 */
	public LoginPageRepo(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	protected By crossLoginWindow = By.cssSelector("button._2AkmmA._29YdH8");
	protected By loginLink = By.cssSelector("a._3Ep39l");
	protected By username = By.xpath("//input[@type='text' and @class='_2zrpKA _1dBPDZ']");
	protected By password = By.xpath("//input[@type='password' and @class='_2zrpKA _3v41xv _1dBPDZ']");
	protected By loginBtn = By.xpath("//button[@type='submit']/ancestor::div[@class='_1avdGP']");
	protected By header = By.cssSelector("span._2Ky4Ru");
	private By user = By.xpath("//div[@class='_2aUbKa' and contains(text(),'Nitesh')]");

	/**
	 * @return the username
	 */
	public By getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(By username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public By getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(By password) {
		this.password = password;
	}

	/**
	 * @return the crossLoginWindow
	 */
	public By getCrossLoginWindow() {
		return crossLoginWindow;
	}

	/**
	 * @return the loginLink
	 */
	public By getLoginLink() {
		return loginLink;
	}

	/**
	 * @return the loginBtn
	 */
	public By getLoginBtn() {
		return loginBtn;
	}

	/**
	 * @return the header
	 */
	public By getHeader() {
		return header;
	}

	/**
	 * @return the user
	 */
	public By getUser() {
		return user;
	}



	
}
