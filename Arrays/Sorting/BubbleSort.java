package Sorting;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 432, 12, 123, 4324, 12, 123, 1212 };
		printarr(arr);
		bubbleSort(arr);
		printarr(arr);

	}

	public static void bubbleSort(int[] arr) {
		int len = arr.length;

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < len - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}

			}

		}

	}

	public static void swap(int[] arr, int i, int j) {
		int ival = arr[i];
		arr[i] = arr[j];
		arr[j] = ival;
	}

	
	public static void printarr(int[] arr) {
		System.out.println("\n");
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}
	
}
