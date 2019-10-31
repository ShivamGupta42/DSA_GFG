package Strings;

import java.util.Arrays;

public class ReverseEachWord {

	public static void main(String[] args) {
		String str = "I know a lot of books knowledge but true knowledge lies within.";

		// in place reversing
		Arrays.stream(str.split(" ")).map(e -> reverseStr(e)).forEach(s -> System.out.print(s + " "));
		;

		System.out.println();
		// reverse all words positions and words themselves
		// in place reversing
		Arrays.stream(reverseArray(str.split(" "))).map(e -> reverseStr(e)).forEach(s -> System.out.print(s + " "));
		;
	}

	public static String reverseStr(String str) {
		char[] c = str.toCharArray();
		int start = 0;
		int end = c.length - 1;
		char temp;
		while (start < end) {
			temp = c[end];
			c[end] = c[start];
			c[start] = temp;
			start++;
			end--;
		}

		return String.valueOf(c);
	}

	static <T> T[] reverseArray(T[] arr) {
		int start = 0;
		int end = arr.length - 1;
		T temp;

		while (start < end) {
			temp = arr[end];
			arr[end] = arr[start];
			arr[start] = temp;
			start++;
			end--;
		}

		return arr;
	}
}
