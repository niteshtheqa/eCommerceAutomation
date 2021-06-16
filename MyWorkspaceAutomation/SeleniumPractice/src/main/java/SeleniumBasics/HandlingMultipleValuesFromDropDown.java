package SeleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingMultipleValuesFromDropDown {

	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("https://www.wikipedia.org/");

		
		
		List<WebElement> values = driver.findElements(By.tagName("option"));

		int size = values.size();

		System.out.println(size);

		for (int i = 0; i < size; i++) {
			System.out.println(i+"==>  "+values.get(i).getText());
		}

		driver.close();

	}

}
