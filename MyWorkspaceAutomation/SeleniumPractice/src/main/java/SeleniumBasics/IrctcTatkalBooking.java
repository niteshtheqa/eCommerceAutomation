package SeleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IrctcTatkalBooking {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(chromeOptions);
		// PageLoad Timeout , Implicitly Timeout
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Object of FluentWait

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(20, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(Exception.class).withMessage("Time out exception");

		// Lanching IRCTC URL
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");

		//driver.switchTo().alert().dismiss();
		// Click on Login button
		WebElement loginButton = driver.findElement(By.xpath("//a[@id='loginText']"));
		loginButton.click();

		Actions action = new Actions(driver);
		
		action.moveByOffset(200, 600).click().perform();

		// Enter user name and Password

		driver.findElement(By.xpath("//input[@id='userId']")).sendKeys("Nitesh1435");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("I@Mitengg2611");
		System.out.println("Username and Password has been entered");

		Thread.sleep(10000);

		driver.findElement(By.xpath("//button[contains(text(),'SIGN IN')]")).click();

		

	}

}
