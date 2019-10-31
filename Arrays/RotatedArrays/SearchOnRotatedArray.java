package RotatedArrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchOnRotatedArray {

	public static void main(String[] args) {

		int[] oddIntegers = Stream.iterate(1, i -> i + 1).limit(20).mapToInt(e -> e).toArray();
		int oddIntLength = oddIntegers.length;

		print(oddIntegers);
		print(rotateArray(oddIntegers, 2, true));
		print(rotateArray(oddIntegers, 2, false));

		// System.out.println("Minimum element" + findMin(oddIntegers, 0, oddIntLength -
		// 1));

	}

	private static int findMin(int[] arr, int low, int high) {

		// Case when array is not rotated at all
		if (high < low)
			return arr[0];

		if (high == low)
			return arr[low];

		// Find mid
		int mid = low + (high - low) / 2;

		// if mid+1 is minimum element
		if (mid < high && arr[mid + 1] < arr[mid])
			return arr[mid + 1];

		// if mid is minimum
		if (mid > low && arr[mid] < arr[mid - 1])
			return arr[mid];

		// Decide if we need to go left half or right half
		if (arr[high] > arr[mid])
			return findMin(arr, low, mid - 1);

		return findMin(arr, mid + 1, high);
	}

	private static int[] rotateArray(int[] arr, int steps, boolean leftDirection) {

		if (leftDirection) {
			List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
			Collections.reverse(list.subList(0, steps));
			Collections.reverse(list.subList(steps, list.size()));
			Collections.reverse(list);
			return list.parallelStream().mapToInt(e -> e).toArray();
		} else {
			List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
			Collections.reverse(list.subList(0, list.size() - steps));
			Collections.reverse(list.subList(list.size() - steps, list.size()));
			Collections.reverse(list);
			return list.parallelStream().mapToInt(e -> e).toArray();
		}

	}

	private static int[] rotateArrayWithoutLibrary(int[] arr, int steps, boolean leftDirection) {
		if (leftDirection) {

		} else {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			map.put("", 1);
		}
		
		return null;
	}

	static void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("\n");
	}

}
