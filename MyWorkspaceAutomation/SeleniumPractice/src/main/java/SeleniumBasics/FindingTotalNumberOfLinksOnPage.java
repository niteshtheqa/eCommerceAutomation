package SeleniumBasics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindingTotalNumberOfLinksOnPage {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().fullscreen();

		//WebElement block = driver.findElement(By.xpath("//div[@class='other-projects']"));

		List<WebElement> links = driver.findElements(By.tagName("a"));

		int size = links.size();

		System.out.println(size);

		for (int i = 0; i < size; i++) {
			//System.out.println(i + "==>" + links.get(i).getAttribute("href"));
			String link = links.get(i).getAttribute("href");

			URL url = new URL(link);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setConnectTimeout(5000);
			httpURLConnection.connect();
			if (httpURLConnection.getResponseCode() == 200) {
				System.out.println("Working Link : "+link + " == >" + " " + httpURLConnection.getResponseMessage());
			} else {
				System.out.println("Dead Links : "+link + " == >" + httpURLConnection.getResponseMessage() + " - "
						+ HttpURLConnection.HTTP_NOT_FOUND);
			}

		}

		driver.close();
	}

}
