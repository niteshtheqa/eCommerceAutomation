package SeleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingWebTables {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://money.rediff.com/gainers");
		driver.manage().window().fullscreen();

		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));

		int rowNum = rows.size();

		System.out.println(rowNum);

		List<WebElement> columns = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td"));

		int colNum = columns.size();

		System.out.println(colNum);

		for (int row = 1; row <= rowNum; row++) {
			for (int col = 1; col <= colNum; col++) {
				System.out.print(driver
						.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[" + row + "]/td[" + col + "]"))
						.getText() + "  ");
			}
			System.out.println();
		}
		// .findElement(By.xpath("//table[@class='dataTable']/tbody/tr[" + rowNum +
		// "]/td[" + colNum + "]"))
		// driver.close();

	}

}
