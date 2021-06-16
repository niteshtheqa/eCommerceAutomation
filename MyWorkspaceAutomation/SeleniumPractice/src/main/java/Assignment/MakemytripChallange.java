package Assignment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class MakemytripChallange {

	public static WebDriver driver = null;
	public static Wait<WebDriver> wait = null;

	public void initialization() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("firefox");
		capabilities.setPlatform(Platform.ANY);
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.8:4444/wb/hub"), capabilities);
		wait = new FluentWait<WebDriver>(driver).withTimeout(20, TimeUnit.SECONDS).pollingEvery(4, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class).withMessage("Element is present");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().fullscreen();

	}

	public void selectFlightAndClickRoundTrip() {
		System.out.println("---------------------   Select flight and click on Round trip   ---------------");
		WebElement flights = driver
				.findElement(By.xpath("//span[@class='chNavText darkGreyText' and text()='Flights']"));
		flights.click();
		WebElement roundTrip = driver.findElement(By.xpath("//li[@data-cy='roundTrip']"));
		roundTrip.click();
	}

	public void flight() {
		System.out.println("---------------------  From Delhi to Banglore  --------------");
		WebElement from = wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//input[@data-cy='fromCity' and @type='text']"))));
		from.sendKeys("Delhi");
		WebElement delhi = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[text()='Delhi, India']"))));
		delhi.click();

		WebElement toCity = wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//div[@role='combobox']/input[@placeholder='To']"))));
		toCity.sendKeys("Bengaluru");
		WebElement banglore = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[text()='Bengaluru, India']"))));
		banglore.click();
	}

	public void selectDepartureDate() {
		WebElement departure = driver.findElement(By.xpath("//label[@for='departure']/ span[text()='DEPARTURE']"));
		departure.click();

		WebElement today = wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(By.xpath(
				"//div[@class='DayPicker-Day DayPicker-Day--start DayPicker-Day--selected']//div[@class='dateInnerCell']//p[text()='8']")))));
		today.click();
	}

	public void selectReturnDate() {
		List<WebElement> returnDates = driver.findElements(By.xpath(
				"//div[@class='DayPicker-Week']//div[@class='DayPicker-Day']//descendant::div[@class='dateInnerCell']//descendant::p"));
		for (WebElement webElement : returnDates) {
			// System.out.println(webElement.getText());
			if (Integer.valueOf(webElement.getText()) == 15) {
				webElement.click();
				break;
			}

		}
	}

	public void clickOnSearch() {
		WebElement search = driver.findElement(By.xpath("//a[text()='Search']"));
		search.click();
	}

	public Integer departureFilghts() {
		List<WebElement> flights = driver.findElements(By.xpath("//span[@class='airlineInfo-sctn']"));

		return flights.size();
	}

	public static void main(String[] args) throws MalformedURLException {
		MakemytripChallange obj = new MakemytripChallange();
		obj.initialization();
		obj.selectFlightAndClickRoundTrip();
		obj.flight();
		obj.selectDepartureDate();
		obj.selectReturnDate();
		obj.clickOnSearch();
		System.out.println("Total number of flights to depart :" + obj.departureFilghts());
	}

}
