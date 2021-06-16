/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package listeners;

import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

/**
 * @author nites
 *
 */
public class Reporter implements IReporter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.IReporter#generateReport(java.util.List, java.util.List,
	 * java.lang.String)
	 */
	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

		for (ISuite suite : suites) {
			String suiteNames = suite.getName();

			Map<String, ISuiteResult> suiteResult = suite.getResults();

			for (ISuiteResult result : suiteResult.values()) {
				ITestContext context = result.getTestContext();

				System.out.println("Test are passed from suite : " + suiteNames + " is "
						+ context.getPassedTests().getAllResults().size());
			}
		}

	}

}
