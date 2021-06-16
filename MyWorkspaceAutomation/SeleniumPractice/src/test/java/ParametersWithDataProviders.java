import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParametersWithDataProviders {

	@DataProvider(name = "Parameters")
	public Object[][] createData() {
		return new Object[][] { { "Nitesh", new Integer(36) }, { "Mayuri", new Integer(37) }, };
	}

	@Test(dataProvider = "Parameters")
	public void test(String n1, Integer n2) {
		System.out.println(n1 + "==>" + n2);
	}
}
