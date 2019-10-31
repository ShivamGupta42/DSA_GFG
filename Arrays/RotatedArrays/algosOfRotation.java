package RotatedArrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class algosOfRotation {
	public static void main(String[] args) {

		int[] arr = Stream.iterate(1, i -> i + 2).limit(20).mapToInt(e -> e).toArray();

		boolean leftRotate = true;
		int steps = 2;
		// method1(arr, steps, leftRotate);

		printArr(arr);
		method2ReversalAlg(arr, steps, leftRotate);

	}

	// Time Complexity O(n+d) Space Complexity O(d)
	private static void method1(int[] arr, int steps, boolean rotDirection) {

		if (rotDirection) {
			int[] shift = new int[steps];

			for (int i = 0; i < steps; i++) {
				shift[i] = arr[i];
			}

			for (int k = 0; k <= arr.length - 1 - steps; k++) {
				arr[k] = arr[k + steps];
			}

			for (int k = arr.length - 1 - steps + 1; k <= arr.length - 1; k++) {
				arr[k] = shift[k - arr.length + steps];
			}
		}
	}

	private static void method2ReversalAlg(int[] arr, int steps, boolean rotDirection) {

		if (rotDirection) {
			List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

			if (steps < 0 || steps == 0) {
				return;
			}
			Collections.reverse(list.subList(0, steps));
			Collections.reverse(list.subList(steps, list.size()));
			Collections.reverse(list.subList(0, list.size()));

			arr = list.parallelStream().mapToInt(e -> e).toArray();
			printArr(arr);
		}
	}

	private static void method3(int[] arr) {

	}

	private static void method4(int[] arr) {

	}

	private static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();

	}

}
