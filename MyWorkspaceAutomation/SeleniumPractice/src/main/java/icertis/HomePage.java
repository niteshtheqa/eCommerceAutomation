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
public class HomePage extends BasePage {

	/**
	 * @param driver
	 */
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By termsAndCon = By.id("toc-link");
	private By myDoc = By.id("mydocpdf");

	/**
	 * @return the termsAndCon
	 */
	public By getTermsAndCon() {
		return termsAndCon;
	}

	/**
	 * @return the myDoc
	 */
	public By getMyDoc() {
		return myDoc;
	}

	public Doc clickOnTermsAndConditions() {
		getWebElement(termsAndCon).click();
		nextWindow();
		return getInstance(Doc.class);
	}

	public void downloadDocument() {
		getWebElement(getMyDoc());
	}

	public void landOnNextWindow() {
		nextWindow();
	}

	public Error getDocWithoutTermsAndCons() {
		getWebElement(getMyDoc()).click();
		nextWindow();
		return getInstance(Error.class);
	}
	

}
