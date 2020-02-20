/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package com.qa.objectrepo;

import org.openqa.selenium.WebDriver;

import com.qa.basepages.BasePage;
import com.qa.flipkartpages.FlipkartHomePage;

/**
 * @author nites
 * @param <Mobiles>
 *
 */
public class Electronics extends BasePage {

	FlipkartHomePage flipkartHomePage = new FlipkartHomePage(driver);

	/**
	 * @param driver
	 */
	public Electronics(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	protected Mobiles mobiles;
	protected MobileAccessories mobileAccessories;
	protected SmartWearableTech smartWearableTech;
	protected HealthCareAppliances healthCareAppliances;
	protected Laptops laptops;
	protected DesktopPCs desktops;

	

}
