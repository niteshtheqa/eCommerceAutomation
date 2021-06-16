import org.testng.annotations.Test;

public class DependsOnMethodsTest {

	@Test(enabled = true, groups = "init")
	public void test1() {
		System.out.println("First Method executed");

	}

	@Test(dependsOnMethods = "test1", alwaysRun = true, groups = "init")
	public void test2() {
		System.out.println("Second Method executed");
	}

	@Test(alwaysRun = true,dependsOnGroups="init")
	public void test3() {
		System.out.println("Third Method executed");
	}

}
