import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterExample {

	@Parameters({ "username", "Company", "City" })
	@Test
	public void userdata( @Optional("Mayuri") String user,@Optional("Wokhardt") String company,@Optional("Pune") String city ) {
		System.out.println(user + "==> " + company + " ==>" + city);

	}
}
