import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */

/**
 * @author nites
 *
 */
public class Demo {
	static WebDriver  driver;
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver","G:\\Selenium\\Drivers2\\chromedriver");
	  driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://vinayak-sonar.herokuapp.com/admin");
		//*USer Login**
		driver.findElement(By.xpath("//*[@id='admin_user_email']")).sendKeys("admin@example.com");
		driver.findElement(By.xpath("//*[@id='admin_user_password']")).sendKeys("password");
		driver.findElement(By.xpath("//*[@id='admin_user_remember_me']")).click();
		driver.findElement(By.xpath("//*[@id='admin_user_submit_action']/input")).click();
		
		//**Product**
		driver.findElement(By.xpath("//*[@id='products']/a")).click(); 
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='titlebar_right']/div/span/a")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='product_title']")).sendKeys("Pen");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='product_sku']")).sendKeys("PE");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='product_description']")).sendKeys("Writing Equipement");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='product_submit_action']/input")).click();
		
		//**View Product list***
		Thread.sleep(4000);
		driver.findElement(By.xpath("//li[@id='products']//a[contains(text(),'Products')]\n" + 
				"")).click();	
		
		//*Update Product*

		  Thread.sleep(4000);
		  driver.findElement(By.xpath("//a[contains(text(),'Id')]")).click();
		 Thread.sleep(4000);
		 
				 driver.findElement(By.xpath("//*[@name='collection_selection[]']")).click();							
	     		
	        Thread.sleep(4000);
		 driver.findElement(By.xpath("/html/body/div/div[4]/div[1]/div/form/div[2]/div[1]/div/div/table/tbody/tr/td[8]/div/a[2]")).click(); 
		 Thread.sleep(4000);
		 driver.findElement(By.xpath("//*[@id='product_sku']")).clear();
		 Thread.sleep(4000);
		  driver.findElement(By.xpath("//*[@id='product_sku']")).sendKeys("PN");
		  Thread.sleep(4000);
		  driver.findElement(By.xpath("//input[@name='commit']")).click();
		
		//**Delete Product**
		  
		  Thread.sleep(4000);
			driver.findElement(By.xpath("//li[@id='products']//a[contains(text(),'Products')]\n" + 
					"")).click();	

			  Thread.sleep(4000);
			  driver.findElement(By.xpath("//a[contains(text(),'Id')]")).click();
			 Thread.sleep(4000);
			 
						 driver.findElement(By.xpath("//*[@name='collection_selection[]']")).click();							
		
		 Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div/div[4]/div[1]/div/form/div[2]/div[1]/div/div/table/tbody/tr/td[8]/div/a[3]")).click();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		
		//*Logout**
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		driver.quit();
		
		
	}
}
