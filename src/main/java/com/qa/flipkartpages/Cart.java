/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package com.qa.flipkartpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.basepages.BasePage;

/**
 * @author nites
 *
 */
public class Cart extends BasePage{

	/**
	 * @param driver
	 */
	public Cart(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	private By saveForLaterBtn = By.xpath("//div[contains(text(),'Save for later')]");
	private By removeItemBtn = By.xpath("//div[contains(text(),'Remove')]");
	private By addQunatity = By.xpath("//button[text()='+']");
	private By reduceQuantity = By.xpath("//div[@class='_3cto0P _2Mq1yq']//button[1]");
	
	
	
	/**
	 * @return the saveForLaterBtn
	 */
	public By getSaveForLaterBtn() {
		return saveForLaterBtn;
	}

	/**
	 * @return the removeItemBtn
	 */
	public By getRemoveItemBtn() {
		return removeItemBtn;
	}

	/**
	 * @return the addQunatity
	 */
	public By getAddQunatity() {
		return addQunatity;
	}

	/**
	 * @return the reduceQuantity
	 */
	public By getReduceQuantity() {
		return reduceQuantity;
	}

	public void saveForLaterItem() {
		
	}
	
	public void removeItem() {
		
	}

}
