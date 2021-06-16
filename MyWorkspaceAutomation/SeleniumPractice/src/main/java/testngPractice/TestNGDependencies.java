package testngPractice;

import org.testng.annotations.Test;

public class TestNGDependencies {

	@Test(priority = 1)
	public void userRegiStration() {
		//Assert.fail();

	}

	@Test(priority = 2, dependsOnMethods = {"userRegiStration","thirdTest"})
	public void userLogin() {
		System.out.println("User logged in successfully..");
	}

	@Test(priority = 3)
	public void thirdTest() {
		System.out.println("Executing Third Test case....");
	}

	@Test(priority = 4)
	public void fourthTest() {
		System.out.println("Executing Fourth Test case....");
	}
}
