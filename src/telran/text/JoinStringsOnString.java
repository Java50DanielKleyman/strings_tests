package telran.text;

public class JoinStringsOnString implements JoinStrings {

	@Override
	public String join(String[] strings, String delimiter) {
		String res = "";
		if(strings != null && strings.length > 0) {
			res = strings[0];
			for(int i = 1; i < strings.length; i++) {
				res += delimiter + strings[i];
			}
		}
		return res;
	}

}
