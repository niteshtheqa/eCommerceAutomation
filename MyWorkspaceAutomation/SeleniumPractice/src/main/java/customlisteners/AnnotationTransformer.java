/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package customlisteners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

/**
 * @author nites
 *
 */
public class AnnotationTransformer implements IAnnotationTransformer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.IAnnotationTransformer#transform(org.testng.annotations.
	 * ITestAnnotation, java.lang.Class, java.lang.reflect.Constructor,
	 * java.lang.reflect.Method)
	 */
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
	
			annotation.setRetryAnalyzer(RetryAnalyzer.class);
		

	}

}
