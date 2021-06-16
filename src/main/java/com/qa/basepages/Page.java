package com.qa.basepages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */

/**
 * @author nites
 *
 */
public abstract class Page {

	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public Actions actions;
	public Wait<WebDriver> fluentWait;

	public Page(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver, 15);
		js = (JavascriptExecutor) this.driver;
		actions = new Actions(this.driver);
		fluentWait = new FluentWait<WebDriver>(this.driver).withTimeout(50, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(Exception.class)
				.withMessage("Element is not found due to timeout exception....");
	}

	public abstract String getPageTitle();

	public abstract WebElement getWebElement(By locator);

	public abstract WebElement waitForElement(By locator);

	public abstract List<WebElement> waitForListOfElements(By locator);

	public abstract void waitForPageTitle(String title);

	public abstract WebElement waitForVisibilityOfElement(By locator);

	public abstract WebElement waitForElementWithFluentWait(By locator);

	public abstract void clickOnElementJS(By locator);

	public abstract void mouseHoverOnElement(By locator);

	public abstract void scrollOnPageUntilElementFound(WebElement element);

	public abstract void sleep(long mili);

	public <T extends BasePage> T getInstance(Class<T> pageClass) {
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}