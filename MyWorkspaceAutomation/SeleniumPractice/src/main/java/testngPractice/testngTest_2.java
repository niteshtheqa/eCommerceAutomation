package testngPractice;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class testngTest_2 {

	@Test(groups = { "smoke", "functional" })
	public void test2() {

		Assert.fail();
		System.out.println("Executing test2 case ");
	}

	@Test(groups = "bvt")
	public void test22() {
		throw new SkipException("Skipped Test ");

	}

	@Test(groups = "smoke")
	public void test222() {
		Assert.fail();
		System.out.println("Executing test222 case ");
	}
}
