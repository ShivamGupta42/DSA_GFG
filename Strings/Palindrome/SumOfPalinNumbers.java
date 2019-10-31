package Palindrome;

public class SumOfPalinNumbers {

	
	public static void main(String[] args) {
		int[] arr = { 123, 121 };
		sumCount(arr);
	}

	private static void sumCount(int[] arr) {
		int sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			sum = sum + (isPalindrome(arr[i]) == true ? arr[i] : 0);
		}
		
		System.out.println(sum);
	}

	static boolean isPalindrome(int n) {
		int revNumber = 0;
		int temp =n;
		int c = 0;
		while (n != 0) {
			c = n % 10;
			revNumber = revNumber * 10 + c;
			n = n / 10;
			;
		}

		return revNumber == temp;

	}

	static boolean isPalindrome(String n) {
		char[] c = n.toCharArray();
		int i = 0, j = c.length;

		while (i < j) {
			if (c[i] == c[j]) {
				i++;
				j--;
			} else {
				return false;
			}
		}

		return true;

	}

}
