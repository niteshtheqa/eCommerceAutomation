package paralleltest;

import java.util.Date;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestClass {

	@Parameters({"browser"})
	@Test
	public void doLogin(@Optional("Nitesh") String browser) throws InterruptedException {
		
		Date date = new Date();
		
		System.out.println("Browser Name : " + browser+"==>"+date);
		Thread.sleep(2000);
	}

}
