package telran.text;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class StringTests {
private static final int N_STRINGS = 10000;
private static final int N_RUNS = 1000;
String [] strings = {"12", "34", "56"};
String delimeter = "&";
String expected = "12&34&56";
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Disabled
	void test() {
		
		String str1 = "lmn";
		updateString(str1);
		assertEquals(str1, "lmn");
		StringBuilder str2 = new StringBuilder("lmn");
		
		updateString(str2);
		assertEquals(str2.toString(), "lmnabc");
		
		
		
		
	}
	private void updateString(String str1) {
		str1 += "abc";
	}
	private void updateString(StringBuilder builder) {
		builder.append("abc");
	}
	private String joinStrings(String[] strings, String delimeter) {
		String res = "";
		if(strings != null && strings.length > 0) {
			res = strings[0];
			for(int i = 1; i < strings.length; i++) {
				res += delimeter + strings[i];
			}
		}
		return res;
	}
	private String joinStringsInBuilder(String[] strings, String delimeter) {
		String res = "";
		if (strings != null && strings.length > 0) {
			StringBuilder builder = new StringBuilder(strings[0]);
			for(int i = 1; i < strings.length; i++) {
				builder.append(delimeter).append(strings[i]);
				
			}
			res = builder.toString();
		}
		return res;
	}
	@Test
	void joinStringsTest() {
		assertEquals(expected, joinStrings(strings, delimeter));
	}
	@Test
	void joinStringsInBuilderTest() {
		assertEquals(expected, joinStringsInBuilder(strings, delimeter));
	}
	@Test
	@Disabled
	void joingStringsPerformanceTest() {
		String [] array = getBigArray();
		for(int i = 0; i < N_RUNS; i++) {
			joinStrings(array, " ");
		}
	}
	private String[] getBigArray() {
		String[] res = new String[N_STRINGS];
		Arrays.fill(res , "Hello");
		return res;
	}

	@Test
	void joingStringsInBuilderPerformanceTest() {
		String [] array = getBigArray();
		for(int i = 0; i < N_RUNS; i++) {
			joinStringsInBuilder(array, " ");
		}
	}
	
	
	

}