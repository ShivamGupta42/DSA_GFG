package Sorting;
import java.util.TreeMap;

public class SelfMergeSort {

	public static void main(String[] args) {

		int[] arr = { 1,111, 22, 312, 42323, 53 ,1,1,1123,1192};
		MergeSort(arr, new int[arr.length], 0, arr.length - 1);
		
		TreeMap<Integer, Integer> map = new TreeMap<>();
		
		

	}

	public static void MergeSort(int[] a, int[] temp, int leftStart, int RightEnd) {

		if (leftStart < RightEnd) {
			int mid = leftStart + (RightEnd - leftStart) / 2;
			MergeSort(a, temp, leftStart, mid);
			MergeSort(a, temp, mid + 1, RightEnd);
			mergeHalves(a, temp, leftStart, RightEnd);
		}

		else {
			return;
		}
	}

	public static void mergeHalves(int[] a, int[] temp, int leftStart, int RightEnd) {
		int leftEnd = leftStart + (RightEnd - leftStart) / 2;
		int RightStart = leftEnd + 1;
		int length = RightEnd - leftStart + 1;

		int left = leftStart;
		int right = RightStart;
		int index = leftStart;

		while (left <= leftEnd && right <= RightEnd) {
			if (a[left] <= a[right]) {
				temp[index] = a[left];
				left++;
			} else {
				temp[index] = a[right];
				right++;
			}

			index++;

		}
		
		System.arraycopy(a, left, temp, index, leftEnd - left +1);
		System.arraycopy(a, right, temp, index, RightEnd - right +1);
		System.arraycopy(temp, leftStart, a, leftStart, length);
		

	}

	public static void printArr(int[] a) {
		for (int i : a) {
			System.out.print(i + " ");
		}

	}

}
