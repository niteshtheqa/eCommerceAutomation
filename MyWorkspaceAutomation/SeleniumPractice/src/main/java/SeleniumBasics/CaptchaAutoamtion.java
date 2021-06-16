package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptchaAutoamtion {

	public static void main(String[] args) throws InterruptedException {
		//
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://timesofindia.indiatimes.com/poll.cms");
		driver.manage().window().fullscreen();

		String rawString = driver.findElement(By.cssSelector("span#mathq2")).getText();
		System.out.println(rawString);
		driver.findElement(By.xpath("//input[@name='PRadio' and @value='2']")).click();
		String firstNumber = rawString.replaceAll(" ", "").split("\\+")[0];
		String secondNumber = rawString.replaceAll(" ", "").split("\\+")[1].substring(0, 1);
		int add = Integer.valueOf(firstNumber) + Integer.valueOf(secondNumber);
		System.out.println(add);
		driver.findElement(By.cssSelector("input#mathuserans2")).sendKeys("" + add);
		driver.findElement(By.xpath("//div[@pg='Vote']")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//b[text()='You have successfully cast your vote.']")).getText());
		driver.close();
		

	}

}
