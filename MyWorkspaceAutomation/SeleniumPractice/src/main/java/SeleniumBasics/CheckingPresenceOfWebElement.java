package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckingPresenceOfWebElement {

	public static WebDriver driver;

	public static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (Throwable t) {
			return false;
		}
	}

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.wikipedia.org/");
		driver.manage().window().fullscreen();

		System.out.println(isElementPresent(By.xpath("//*[@id='searchLanguage']")));
		
		driver.close();

	}
}
