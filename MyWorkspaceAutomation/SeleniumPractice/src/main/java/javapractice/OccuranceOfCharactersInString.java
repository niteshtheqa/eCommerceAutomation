package javapractice;

import java.util.HashMap;
import java.util.Map;

public class OccuranceOfCharactersInString {

	public static void main(String[] args) {
		int count[] = new int[256];
		String str = "Nitesh Wayafalkar".trim();
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < str.length() - 1; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				if (map.containsKey(str.charAt(i))) {
					map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
				} else {
					map.put(str.charAt(i), 1);
				}
			}
		}

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "==>" + entry.getValue());

		}

	}

}
