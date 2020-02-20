/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package com.qa.objectrepo;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.basepages.BasePage;
import com.qa.flipkart.commonservice.Services;
import com.qa.flipkartpages.Cart;

/**
 * @author nites
 *
 */
public class Mobiles extends BasePage implements Services {
	/**
	 * @param driver
	 */
	public Mobiles(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By apple7Plus = By.xpath(
			".//div[@class='_2tnqd0 _1_l8MX']//img[@alt='iPhone 7 Plus X3 for Store' and @class='_232NW7 dImZt_']");
	private By mobileHeader = By.xpath("//h1[@class='_30P0WS']");
	private By mobileSearchPageHeader = By.xpath(".//h1[contains(text(),'Apple Iphone 7 Plus Mobiles')]");
	private By allIphonesOnPage = By.xpath(".//div[@class='_3wU53n']");
	private By addToCartBtn = By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']");

	/**
	 * @return the appleMobiles
	 */
	public By getApple7Plus() {
		return apple7Plus;
	}

	/**
	 * @return the mobileHeader
	 */
	public By getMobileHeader() {
		return mobileHeader;
	}

	// Methods

	/**
	 * @return the mobileSearchPageHeader
	 */
	public By getMobileSearchPageHeader() {
		return mobileSearchPageHeader;
	}

	/**
	 * @return the allIphonesOnPage
	 */
	public By getAllIphonesOnPage() {
		return allIphonesOnPage;
	}

	/**
	 * @return the addToCartBtn
	 */
	public By getAddToCartBtn() {
		return addToCartBtn;
	}

	public String getMobilePageHeader() {
		return waitForElementWithFluentWait(getMobileHeader()).getText();
	}

	public void selectIphone7Plus() {

		// scrollOnPageUntilElementFound(waitForVisibilityOfElement(getApple7Plus())).click();
		scrollOnPageUntilElementFound(waitForVisibilityOfElement(getApple7Plus()));
		sleep(2000);
		clickOnElementJS(getApple7Plus());
		sleep(2000);
		List<WebElement> alliPhones = waitForListOfElements((getAllIphonesOnPage()));
		alliPhones.get(0).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> wins = windows.iterator();
		String parentWindow = wins.next();
		String childWindow = wins.next();
		driver.switchTo().window(childWindow);

		addToCart(getAddToCartBtn());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qa.flipkart.commonservice.Services#addToCart()
	 */
	@Override
	public Cart addToCart(By locator) {
		waitForVisibilityOfElement(getAddToCartBtn()).click();
		return getInstance(Cart.class);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qa.flipkart.commonservice.Services#proceedToPay()
	 */
	@Override
	public void proceedToPay() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qa.flipkart.commonservice.Services#filterItemsByBrandName(java.lang.
	 * String)
	 */
	@Override
	public void filterItemsByBrandName(String brandName) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qa.flipkart.commonservice.Services#filterItemsByPrice(int)
	 */
	@Override
	public void filterItemsByPrice(int price) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qa.flipkart.commonservice.Services#filterItemsBySize(java.lang.String)
	 */
	@Override
	public void filterItemsBySize(String size) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qa.flipkart.commonservice.Services#deliveryAddress()
	 */
	@Override
	public void deliveryAddress() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qa.flipkart.commonservice.Services#serchItemsByName(java.lang.String)
	 */
	@Override
	public void serchItemsByName(String itemName) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qa.flipkart.commonservice.Services#serchItemsByCategory(java.lang.String)
	 */
	@Override
	public void serchItemsByCategory(String category) {
		// TODO Auto-generated method stub

	}

}
