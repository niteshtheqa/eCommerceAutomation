/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package icertis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author nites
 *
 */
public class BaseTest {
	WebDriver driver;
	public Page page;

	@BeforeMethod()
	@Parameters(value = "browser")
	public void setUp(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("No browser mentioned in testng file");
		}
		driver.get("G:\\MyWorkspaceAutomation\\C_SeleniumExcercise\\FirstTest\\home.html");
		driver.manage().window().maximize();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("Webdriver is not initialized");
		}
		page = new BasePage(driver);
	}

	@AfterMethod()
	public void tearDown() {
		driver.close();
	}
}