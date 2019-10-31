package Sorting;

public class SelectionSort {

	public static void main(String[] args) {

		int[] arr = { 1, 22, 33, 44, 232, 11, 1, 1 };
		selectionSort(arr);
		printArr(arr);

	}

	public static void printArr(int[] arr) {

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public static void selectionSort(int[] arr) {

		int len = arr.length;
		int minIndex = 0;

		for (int i = 0; i < len - 1; i++) {
			
			minIndex = i;

			for (int j = i + 1; j < len; j++) {
				if (arr[j] < arr[j - 1]) {
					minIndex = j;
				}

				else {
					minIndex = j - 1;
				}
			}

			if (minIndex != i) {
				swap(arr, minIndex, i);
			}
		}

	}

	public static void swap(int[] arr, int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
