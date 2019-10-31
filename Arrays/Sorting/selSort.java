package Sorting;

public class selSort {

	public static void main(String[] args) {
		int[] data = { 12, 23, 34, 24, 12, 11, 2223, 121314, 65 };
		printArr(data);
		Sorter(data);
		printArr(data);

	}

	private static void Sorter(int[] data) {

		for(int i=0;i<data.length-1;i++) {
			int minimum = i;
			
			for(int j=i;j<data.length-1;j++) {
                 if(data[j+1]<data[j]) {
                	
                 }
			}
		}
		
		
	}

	static void printArr(int[] arr) {
		System.out.println("\n\n");
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int ival = arr[i];
		arr[i] = arr[j];
		arr[j] = ival;
	}

}
