package SeleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingFrames {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_scripts_intro");
		driver.manage().window().fullscreen();

		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println("Number of frames: " + frames.size());

		for (int i = 0; i <= frames.size(); i++) {
		   System.out.println(driver.switchTo().frame(i));
			
		

		}

		Thread.sleep(500);
		driver.close();

	}

}
