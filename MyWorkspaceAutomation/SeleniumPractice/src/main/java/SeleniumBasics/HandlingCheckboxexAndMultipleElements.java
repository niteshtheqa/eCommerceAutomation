package SeleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingCheckboxexAndMultipleElements {

	public static void main(String[] args) {
//		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		driver.manage().window().fullscreen();

		WebElement block = driver.findElement(By.xpath("//div[4][@class='display']"));

		List<WebElement> checkboxes = block.findElements(By.xpath("//*[@name='sports']"));
		System.out.println("Total checkboxes checked " + checkboxes.size());

		for (WebElement checkbox : checkboxes) {
			checkbox.click();

		}
		
		driver.close();

	}

}
