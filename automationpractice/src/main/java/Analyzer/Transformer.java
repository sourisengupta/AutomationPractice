package Analyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class Transformer implements IAnnotationTransformer{

	public void transform(ITestAnnotation annotation, Class myclass, Constructor constructor, Method method) {		
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}
}
