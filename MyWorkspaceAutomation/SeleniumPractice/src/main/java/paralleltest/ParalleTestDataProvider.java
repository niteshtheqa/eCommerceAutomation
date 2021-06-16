package paralleltest;

import java.util.Date;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParalleTestDataProvider {

	@Test(dataProvider = "getData")
	public void doLogin(String browser) throws InterruptedException {

		Date date = new Date();

		System.out.println("Browser Name : " + browser + "==>" + date);
		Thread.sleep(2000);
	}

	
	@DataProvider(parallel = true)
	public Object[][] getData() {

		Object[][] data = new Object[2][1];

		data[0][0] = "firefox";
		data[1][0] = "chrome";

		return data;

	}
}
