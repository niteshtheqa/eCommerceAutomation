/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package com.qa.basepages;

import java.util.List;

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
	 * @see
	 * com.qa.basepages.Page#waitForElementWithFluentWait(org.openqa.selenium.By)
	 */
	@Override
	public WebElement waitForElementWithFluentWait(By locator) {
		WebElement element = fluentWait.until(ExpectedConditions.elementToBeClickable(locator));
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
	 * @see com.qa.basepages.Page#mouseHoverOnElement(org.openqa.selenium.By)
	 */
	@Override
	public void mouseHoverOnElement(By locator) {

		int X = waitForElement(locator).getLocation().getX();
		int Y = waitForElement(locator).getLocation().getY();
		System.out.println(X + "   :  " + Y);
		String strJavaScript = "var element = arguments[0];"
				+ "var mouseEventObj = document.createEvent('MouseEvents');"
				+ "mouseEventObj.initEvent( 'mouseover', true, true );" + "element.dispatchEvent(mouseEventObj);";
		js.executeScript(strJavaScript, waitForVisibilityOfElement((locator)));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		actions.moveToElement(waitForVisibilityOfElement((locator)), X, Y).build().perform();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qa.basepages.Page#waitForElements(org.openqa.selenium.By)
	 */
	@Override
	public List<WebElement> waitForListOfElements(By locator) {
		List<WebElement> lists = driver.findElements(locator);
		return lists;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qa.basepages.Page#scrollOnPageUntilElementFound(org.openqa.selenium.By)
	 */
	@Override
	public void scrollOnPageUntilElementFound(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true)", element);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qa.basepages.Page#sleep(long)
	 */
	@Override
	public void sleep(long mili) {
		try {
			Thread.sleep(mili);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
