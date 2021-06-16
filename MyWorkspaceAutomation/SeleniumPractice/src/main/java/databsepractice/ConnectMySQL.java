/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package databsepractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

/**
 * @author nites
 *
 */
public class ConnectMySQL {

	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Test
	public void connectMySQL()  throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/SELENIUM";
		String username = "root";
		String password = "I@Mitengg2611";
		//oracle.jdbc.driver.OracleDriver
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded....");
		Connection conn = DriverManager.getConnection(url, username, password);
		System.out.println("Connection established!");
		String query = "SELECT * FROM SELENIUMUSERS";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			System.out.println( rs.getString("FirstName") + "==>" +rs.getString("email"));
		}
		conn.close();
		System.out.println("Connection closed");
	}

}
