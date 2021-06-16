package SeleniumBasics;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class HandlingWindowsAndClickingOnElementDynnamically {
	public static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.get("https://www.hdfcbank.com");
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).withMessage("Alert is not present").ignoring(Exception.class);
		wait.until(ExpectedConditions.alertIsPresent());	
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		
		try {
			System.out.println(driver.findElement(By.xpath("//img[@class='popupCloseButton']")).isEnabled());
			driver.findElement(By.xpath("//img[@class='popupCloseButton']"));
		} catch (Throwable t) {
			
		}
		// 1st Window
		System.out.println("--------------------Generarting 1st Window ID-------------------------");
		System.out.println("First Page Title :" + driver.getTitle());
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		String first_window = iterator.next();
		while (iterator.hasNext()) {
			try {
				driver.switchTo().window(iterator.next());
				WebElement loginButton1 = driver.findElement(By.xpath("//a[@id='loginsubmit' and @class='homeloginbtn']"));
				js.executeScript("arguments[0].click();", loginButton1);
				
				
				System.out.println(driver.getTitle().contains("JetPrivilege HDFC Bank Signature Chip Debit Card"));
				System.out.println("Third Page Title :" + driver.getTitle());

			} catch (Exception e) {
				System.out.println("WebElement or Window not found");
			}

		}
		driver.quit();
	}
}
