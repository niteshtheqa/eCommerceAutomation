package SeleniumBasics;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingTabsAndWindows {

	public static WebDriver driver;

	public static void screenShot() throws IOException {

		Date date = new Date();
		String filePrefix = date.toString().replace(":", "_").replace(" ", "_");
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//ScreenShot//" + filePrefix + ".jpg"));

	}

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.get("https://www.hdfcbank.com");
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
		System.out.println("First Window : " + first_window);

		WebElement loginButton = driver.findElement(By.xpath("//a[@id='loginsubmit' and @class='homeloginbtn']"));
		js.executeScript("arguments[0].click();", loginButton);
		screenShot();

		// 2nd Window
		System.out.println("--------------------Generarting 2nd Window ID-------------------------");
		try {
			driver.findElement(By.xpath("//a/span[contains(text(),'JetPrivilege HDFC Bank Signature Debit Card')]"))
			.click();
		}
		catch(Exception e) {
			System.out.println("Exception Caought.....");
		}
		windows = driver.getWindowHandles();
		iterator = windows.iterator();
		iterator.next();
		String second_window = iterator.next();
		System.out.println("Second window : " + second_window);
		driver.switchTo().window(second_window);
		driver.manage().window().fullscreen();
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div/div[1]/div/a")));
		js.executeScript("arguments[0].click();",
				driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div/div[1]/div/a")));
		System.out.println("Second Page Title :" + driver.getTitle());
		screenShot();

		// 3rd Window
		System.out.println("--------------------Generarting 3rd Window ID-------------------------");

		driver.findElement(By.xpath("//a/span[contains(text(),'JetPrivilege HDFC Bank Signature Debit Card')]"))
				.click();
		System.out.println(driver.getTitle().contains("JetPrivilege HDFC Bank Signature Chip Debit Card"));
		System.out.println("Third Page Title :" + driver.getTitle());
		screenShot();
		Thread.sleep(1000);
		driver.close();
		driver.switchTo().window(first_window);
		System.out.println("First Page Title :" + driver.getTitle());
		driver.quit();

	}

}
