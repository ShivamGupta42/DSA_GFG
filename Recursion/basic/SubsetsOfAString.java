package basic;

public class SubsetsOfAString {

	public static void main(String[] args) {
		String s = "ABC";
		printPerm(s, 0);
	}

	static void printPerm(String s, int index) {
		printPerm(s, 0, "");

	}

	private static void printPerm(String s, int index, String last) {
		if (index > s.length() - 1) {
			System.out.print("*" + last + "* ");
			return;
		}
		printPerm(s, index + 1, last);
		printPerm(s, index + 1, last + s.charAt(index));
	}

}
