package Array;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MaxSubArraySum {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testCases = Integer.parseInt(s.nextLine());

		for (int i = 0; i < testCases; i++) {
			MaxSum(s);
		}
	}

	static void MaxSum(Scanner s) {
		s.nextLine();
		int[] array = Pattern.compile(" ").splitAsStream(s.nextLine()).filter(e -> !e.equals("")).map(Integer::parseInt)
				.mapToInt(e -> e).toArray();

		int sum = 0;
		int startIndex = 0;
		int endIndex = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];

			if (sum < array[i]) {
				sum = array[i];
				max = array[i];
				startIndex = i;
				endIndex = i;
				continue;
			}

			if (sum > max) {
				max = sum;
				endIndex = i;
			}

		}

		for (int q = startIndex; q <= endIndex; q++) {
			System.out.print(array[q] + " ");
		}

		System.out.println();
	}
}
