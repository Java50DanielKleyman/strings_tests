package telran.performance;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import telran.text.*;

public class JoinStringsPerformanceAppl {

	private static final int N_STRINGS = 1000;
	private static final int N_RUNS = 1000;
	private static final String BASE_PACKAGE = "telran.text.";

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String[] strings = getStrings();
		JoinStrings[] joinStringsArray = new JoinStrings[args.length];
		if (args.length < 3) {
			System.out.println("Must be 3 arguments <name of class as an argument>");
		} else {
			for (int i = 0; i < args.length; i++) {
				Class<JoinStrings> clazz = (Class<JoinStrings>) Class.forName(BASE_PACKAGE + args[i]);
				Constructor<JoinStrings> constructor = clazz.getConstructor();
				joinStringsArray[i] = constructor.newInstance();
			}
			PerformanceTest[] performanceTestsArray = getPerformanceTests(joinStringsArray, strings, args);
			runTests(performanceTestsArray);
		}

	}

	private static void runTests(PerformanceTest[] performanceTestsArray) {
		for (PerformanceTest performanceTest : performanceTestsArray) {
			performanceTest.run();
		}
	}

	private static PerformanceTest[] getPerformanceTests(JoinStrings[] joinStringsArray, String[] strings,
			String[] args) {
		PerformanceTest[] performanceTestsArray = new PerformanceTest[joinStringsArray.length];
		for (int i = 0; i < joinStringsArray.length; i++) {
			performanceTestsArray[i] = getTest(args[i], strings, joinStringsArray[i]);
		}
		return performanceTestsArray;
	}

	private static PerformanceTest getTest(String className, String[] strings, JoinStrings joinStrings) {
		String testName = getTestName(className);
		return new JoinStringsPerformanceTest(testName, N_RUNS, strings, joinStrings);
	}

	private static String getTestName(String className) {

		return String.format("%s; Number of the strings is %d", className, N_STRINGS);
	}

	private static String[] getStrings() {
		String[] res = new String[N_STRINGS];
		Arrays.fill(res, "string");
		return res;
	}

}