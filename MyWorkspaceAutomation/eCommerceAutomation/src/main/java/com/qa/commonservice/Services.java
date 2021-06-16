/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package com.qa.flipkart.commonservice;

import org.openqa.selenium.By;

import com.qa.flipkartpages.Cart;

/**
 * @author nites
 *
 */
public interface Services {

	Cart addToCart(By locator);

	void proceedToPay();

	void filterItemsByBrandName(String brandName);

	void filterItemsByPrice(int price);

	void filterItemsBySize(String size);

	void deliveryAddress();

	void serchItemsByName(String itemName);

	void serchItemsByCategory(String category);

}
