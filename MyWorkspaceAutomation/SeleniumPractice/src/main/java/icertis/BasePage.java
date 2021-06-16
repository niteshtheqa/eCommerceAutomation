/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package icertis;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author nites
 *
 */
public class BasePage extends Page {
	/**
	 * @param driver
	 */
	public BasePage(WebDriver driver) {
		super(driver);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see basepages.Page#getPageTitle()
	 */
	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see basepages.Page#getWebElement(org.openqa.selenium.By)
	 */
	@Override
	public WebElement getWebElement(By locator) {
		return waitForElement(locator);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see basepages.Page#waitForElement(org.openqa.selenium.By)
	 */
	@Override
	public WebElement waitForElement(By locator) {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return element;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see basepages.Page#waitForPageTitle(java.lang.String)
	 */
	@Override
	public void waitForPageTitle(String title) {
		wait.until(ExpectedConditions.titleContains(title));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qa.basepages.Page#waitForVisibilityOfElement(org.openqa.selenium.By)
	 */
	@Override
	public WebElement waitForVisibilityOfElement(By locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		return element;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qa.basepages.Page#clickOnElement(org.openqa.selenium.By)
	 */
	@Override
	public void clickOnElementJS(By locator) {
		js.executeScript("arguments[0].click();", waitForVisibilityOfElement(locator));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qa.basepages.Page#sleep(long)
	 */
	public void sleep(long mili) {
		try {
			Thread.sleep(mili);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see icertis.Page#nextWindow()
	 */
	@Override
	public WebDriver nextWindow() {
		setParentWindow(driver.getWindowHandle());
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		String first_window = iterator.next();

		return driver.switchTo().window(first_window);
	}

	public WebDriver toParentWindow() {

		return driver.switchTo().window(getParentWindow());
	}

}
