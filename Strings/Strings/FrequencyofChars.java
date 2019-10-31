package Strings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class FrequencyofChars {

	public static void main(String[] args) {

		String str = "Thisiasbcsadvkjkjsnv kkjdfs vkjdfs klknf nsf ";
		FrequencyOfChars(str);

	}

	private static void FrequencyOfChars(String str) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		char[] c = str.toCharArray();

		for (int i = 0; i <= c.length - 1; i++) {
			if (!map.containsKey(c[i])) {
				map.put(c[i], 1);
			} else {
				map.put(c[i], map.get(c[i]) + 1);
			}
		}

		Set<Entry<Character, Integer>> entries = map.entrySet();

		for (Iterator iterator = entries.iterator(); iterator.hasNext();) {
			Entry<Character, Integer> entry = (Entry<Character, Integer>) iterator.next();
			System.out.println("" + entry.getKey() + " was repeated " + entry.getValue());
		}

	}
}
