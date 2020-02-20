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
public class HomePageRepo extends BasePage {

	/**
	 * @param driver
	 */
	public HomePageRepo(WebDriver driver) {
		super(driver);

	}
	
	protected Electronics electronics;
	protected TvAndAppliances tvAndAppliances;
	protected Men men;
	protected Women women;
	protected BabyAndKids babyAndKids;
	protected HomeAndFurniture homeAndFurniture;
	protected SportBooksAndMore sportsBooksAndMore;
	protected OfferZone offerZone;
	
	protected By electronicsLink = By.xpath(".//span[contains(text(),'Electronics')]");
	
	
	
	
	
	
	/**
	 * @return the electronics
	 */
	public By getElectronicsLink() {
		return electronicsLink;
	}
	/**
	 * @return the tvAndAppliances
	 */
	public TvAndAppliances getTvAndAppliances() {
		return tvAndAppliances;
	}
	/**
	 * @return the men
	 */
	public Men getMen() {
		return men;
	}
	/**
	 * @return the women
	 */
	public Women getWomen() {
		return women;
	}
	/**
	 * @return the babyAndKids
	 */
	public BabyAndKids getBabyAndKids() {
		return babyAndKids;
	}
	/**
	 * @return the homeAndFurniture
	 */
	public HomeAndFurniture getHomeAndFurniture() {
		return homeAndFurniture;
	}
	/**
	 * @return the sportsBooksAndMore
	 */
	public SportBooksAndMore getSportsBooksAndMore() {
		return sportsBooksAndMore;
	}
	/**
	 * @return the offerZone
	 */
	public OfferZone getOfferZone() {
		return offerZone;
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	

}
