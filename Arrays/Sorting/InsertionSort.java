package Sorting;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = { 1, 22, 33, 44, 232, 11, 1, 1 };
		printArr(arr);
		InsertionSort(arr);
		printArr(arr);
	}

	private static void printArr(int[] arr) {
		System.out.println("\n");
		for (int i : arr) {
			System.out.print(i+ " ");
		}

	}

	
	private static void InsertionSort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			
			int current = arr[i];
			int j = i - 1;
			
			while (j >= 0 && arr[j] > current) {
                arr[j+1]=arr[j];
				j--;
			}
			
			arr[j+1]=current;
		}

	}

}
