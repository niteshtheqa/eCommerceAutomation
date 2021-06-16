/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package icertis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author nites
 *
 */
public class Doc extends BasePage {

	/**
	 * @param driver
	 */
	public Doc(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By accept = By.id("accept");
	private By reject = By.id("reject");

	/**
	 * @return the accept
	 */
	public By getAccept() {
		return accept;
	}

	/**
	 * @return the reject
	 */
	public By getReject() {
		return reject;
	}

	public void acceptTermsAndCons() {
		getWebElement(getAccept()).click();
	}

	public void rejectTermsAndCons() {
		getWebElement(getReject()).click();
	}
	public void navigateToParentWindow() {
		toParentWindow();
	}
}
