package Array;

import java.util.HashSet;

public class Triplets {

	public static void main(String[] args) {
		int arr[] = {1,3 ,4 ,15 ,19 };
		countTriplets(arr, arr.length);
	}

	private static void countTriplets(int[] arr, int n) {
		HashSet<Integer> set = new HashSet<Integer>();
		//HashSet<Integer> set2 = new HashSet<Integer>();
		

		int counter=0;
		for (int i = 0; i < n; i++) {
			set.add(arr[i]);
		}

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (set.contains(arr[i] + arr[j])) {
					//set2.add(arr[i]+arr[j]); -> for duplicate integers
					counter++;
				}
			}
		}
		
		
       // int size = set2.size();
		
		if (counter == 0) {
			System.out.println(-1);
		} else {
			System.out.println(counter);
		}

	}

}
