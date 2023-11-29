package telran.text;

public class JoinStringsOnStandard implements JoinStrings {

	@Override
	public String join(String[] strings, String delimiter) {
		
		return String.join(delimiter, strings);
	}

}
