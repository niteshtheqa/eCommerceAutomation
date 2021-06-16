package Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationPractice {

	public static EventFiringWebDriver eventFiringWebDriver;
	public static WebEventListener webEventListener;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		eventFiringWebDriver = new EventFiringWebDriver(driver);
		webEventListener = new WebEventListener();
		eventFiringWebDriver.register(webEventListener);
		driver = eventFiringWebDriver;
		driver.manage().window().fullscreen();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("http://automationpractice.com/index.php");
		
		System.out.println("User directory ==> "+System.getProperty("user.home"));

		WebElement login = driver
				.findElement(By.xpath("//a[@class='login' and @title='Log in to your customer account']"));
		login.click();
		
		WebElement liftSlider =driver.findElement(By.xpath("//a[@class='ui-slider-handle ui-state-default ui-corner-all' and @style='left: 0%;']"));
		
		driver.close();
		
	}

}
