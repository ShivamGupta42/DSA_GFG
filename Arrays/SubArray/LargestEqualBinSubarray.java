package SubArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.StringJoiner;
import java.util.regex.Pattern;

import Array.MaxSubArraySum;

public class LargestEqualBinSubarray {

	public static void main(String[] args) {

		int[] arr = { 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0,
				1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1,
				1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0 };
		// largestSubEqualZeroOne(arr);
		//largestSubEqualZeroOneWithArraySearch(arr);
		defMethod(arr);

	}

	private static void formString() {
		String str = "0 1 1 1 1 0 0 1 1 0 1 0 1 1 0 0 0 0 0 1 0 1 1 0 0 0 1 1 1 1 0 0 0 1 1 1 0 1 0 1 1 1 1 0 1 0 0 1 0 1 0 1 0 0 1 0 0 0 1 1 1 0 1 0 1 0 1 1 1 0 1 0 1 0 1 0 0 1 0 1 0 0 0 0";
		StringJoiner sj = new StringJoiner(",");
		for (String c : str.split(" ")) {
			sj.add(c);
		}

		System.out.println(sj.toString());
	}

	private static int largestSubEqualZeroOne(int[] arr) {

		int sum = 0;
		int maxSize = 0;
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			arr[i] = (arr[i] == 0) ? -1 : 1;

		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(2 * n + 1);

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			if (sum == 0) {
				if (i + 1 > maxSize) {
					maxSize = i + 1;

				}
			}

			if (map.containsKey(sum + n)) {
				if (i - map.get(sum + n) > maxSize) {
					maxSize = i - map.get(sum + n);
				}
			} else {
				map.put(sum + n, i);
			}

		}

		return maxSize;

	}

	private static void largestSubEqualZeroOneWithArraySearch(int[] arr) {

		int sum = 0;
		int maxSize = 0;
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			arr[i] = (arr[i] == 0) ? -1 : 1;

		}

		int[] diffSum = new int[2 * n + 1];

		for (int j = 0; j < 2 * n + 1; j++) {
			diffSum[j] = -1;
		}

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			if (sum == 0) {
				if (i + 1 > maxSize) {
					maxSize = i + 1;

				}
			}

			if (diffSum[sum + n] != -1) {
				if (i - diffSum[sum + n] > maxSize) {
					maxSize = i - diffSum[sum + n];
				}
			} else {
				diffSum[sum + n] = i;
				;
			}

		}

		System.out.println(maxSize);

	}

	private static void defMethod(int[] arr) {

		int n = arr.length;
		int sum = 0;
		int[] diffPreSum = new int[2 * n + 1];
		Arrays.fill(diffPreSum, -1);
		int maxLength = 0;

		
		for (int i = 0; i < n; i++) {

			sum += (arr[i] == 0) ? -1 : 1;

			if (sum == 0) {
				if (i + 1 > maxLength) {
					maxLength = i + 1;
				}
			}

			if (diffPreSum[sum + n] == -1) {
				diffPreSum[sum + n] = i;
			}

			else {
				if (i - diffPreSum[sum + n] + 1 > maxLength) {
					maxLength = i - diffPreSum[sum + n] + 1;
				}
			}

		}

		System.out.println(maxLength);

	}

}
