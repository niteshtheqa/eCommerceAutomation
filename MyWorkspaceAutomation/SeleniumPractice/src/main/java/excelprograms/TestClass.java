/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package excelprograms;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author nites
 *
 */
public class TestClass {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ExcelOperations readData = new ExcelOperations();
		String testcase = "Purchase";
		ArrayList<String> data =readData.getData(testcase);
		System.out.println("TestCase :"+data.get(0));
		System.out.println("Coloumn 1 :"+data.get(1));
		System.out.println("Coloumn 2 :"+data.get(2));
		System.out.println("Coloumn 3 :"+data.get(3));
		System.out.println("Coloumn 4 :"+data.get(4));
		
		

	}

}
