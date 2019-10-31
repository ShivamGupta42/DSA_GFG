package basic;

public class SumOfDigits {

	public static void main(String[] args) {
		int n = 9987;
		System.out.println(printSum(n));
	}

	private static int printSum(int n) {
		if(n==0) return 0;
		return n%10+printSum(n/10);
	}

}
