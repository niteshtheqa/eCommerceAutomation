package testngPractice;

import org.testng.annotations.Test;

public class testngTest_1 {

	@Test(groups="funtional")
	public void test1() {
		System.out.println("Executing test1 case ");
	}

	@Test(groups="bvt")
	public void test11() {
		System.out.println("Executing test11 case ");
	}

	@Test(groups="smoke")
	public void test111() {
		System.out.println("Executing test111 case ");
	}
}
