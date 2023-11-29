package telran.performance;

import telran.text.JoinStrings;

public class JoinStringsPerformanceTest extends PerformanceTest {
	private String[] strings;
	private JoinStrings joinStrings;
	public JoinStringsPerformanceTest(String testName, int nRuns,
			String[] strings, JoinStrings joinStrings) {
		super(testName, nRuns);
		this.strings = strings;
		this.joinStrings = joinStrings;
	}
	@Override
	protected void runTest() {
		joinStrings.join(strings, " ");

	}

}
