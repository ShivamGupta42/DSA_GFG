package SortedArrays;

import java.util.Arrays;

public class swapTest {

	public static void main(String[] args) {

		int[] arr1 = { 1, 2, 3, 4 };
		int[] arr2 = { 3, 2, 1, 5 };

		System.out.println("Arr1: " + Arrays.toString(arr1));
		System.out.println("Arr2: " + Arrays.toString(arr2));
		swap(arr1, arr2, 3, 3);
		System.out.println("Arr1: " + Arrays.toString(arr1));
		System.out.println("Arr2: " + Arrays.toString(arr2));
		int k=0;
		System.out.println(arr2[k++]);
	}

	private static void swap(int[] arr1, int[] arr2, int i, int j) {
		arr1[i] = arr1[i] + arr2[j];
		arr2[j] = arr1[i] - arr2[j];
		arr1[i] = arr1[i] - arr2[j];
	}
}
