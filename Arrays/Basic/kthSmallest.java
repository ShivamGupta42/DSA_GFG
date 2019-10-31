package Array;

public class kthSmallest {

	public static void main(String[] args) {
		int[] arr = { 34, 12, 11, 1, 4, 54, 3, 32, 3 };

		kSmallest(arr, 5);
	}

	private static void kSmallest(int[] arr, int k) {

		if (k == 0)
			System.out.println(-1);
		
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (min <= arr[i]) {
				min = arr[i];
			}
		}

		if (k == 1)
			System.out.println(min);
		
		for (int i = 0; i < arr.length; i++) {
			if (min <= arr[i]) {
				min = arr[i];
			}
		}

	}

}
