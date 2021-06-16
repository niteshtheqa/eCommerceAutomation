package Assignment;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ZooplaAssignment {

	public static void main(String[] args) throws AWTException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://zoopla.co.uk/");
		driver.manage().deleteAllCookies();
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(20, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class).withMessage("Element is not present");
		WebElement searchLondon = driver.findElement(By.xpath("//input[@id='header-location']"));
		searchLondon.sendKeys("London");
		List<WebElement> list = driver.findElements(By.xpath(
				"//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content']/descendant::li[@class='ui-menu-item']/descendant::a//em[text()='London']"));

		for (WebElement webElement : list) {

			if (webElement.getText().equals("London") ) {
				System.out.println(webElement.getText());
				webElement.click();
				break;
			}
		}


		//Click on Search Button
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350);");
		driver.findElement(By.xpath("//button[@id='search-submit']")).click();
		driver.close();
		
		
	}

}
