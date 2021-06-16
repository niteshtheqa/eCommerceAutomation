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
public class Error extends BasePage {

	/**
	 * @param driver
	 */
	public Error(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By errorMessage = By.id("error");

	/**
	 * @return the errorMessage
	 */
	public By getErrorMessage() {
		return errorMessage;
	}
	
	
	
	public String printErrorMessage() {
		return getWebElement(getErrorMessage()).getText();
	}
	
	
}
