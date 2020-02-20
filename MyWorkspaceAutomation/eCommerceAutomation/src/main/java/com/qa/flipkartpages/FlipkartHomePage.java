/**
*author Nitesh Wayafalkar
 * @Project
 * 
 */
package com.qa.flipkartpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.basepages.BasePage;
import com.qa.objectrepo.Electronics;
import com.qa.objectrepo.HomePageRepo;
import com.qa.objectrepo.Mobiles;

/**
 * @author nitesh
 *
 */
public class FlipkartHomePage extends BasePage {

	HomePageRepo homePageRepo = new HomePageRepo(driver);
	Mobiles mobiles = new Mobiles(driver);
	private By apple = By.xpath("//li[@class='_1KCOnI _3ZgIXy']//a[@title='Apple' and contains(text(),'Apple')]");

	/**
	 * @return the apple
	 */
	public By getApple() {
		return apple;
	}

	/**
	 * @param driver
	 */
	public FlipkartHomePage(WebDriver driver) {
		super(driver);
	}

	public Mobiles navigateToMobiles() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mouseHoverOnElement(homePageRepo.getElectronicsLink());

		waitForVisibilityOfElement(getApple()).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getInstance(Electronics.class).getInstance(Mobiles.class);
	}

}
