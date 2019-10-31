package SubArray;

import java.util.HashMap;

public class SubArrayWithGivenSum {

	public static void main(String[] args) {
		int[] arr = { 3, 2, 3, 4,1};
		int k = 10;
		SubArrayWithGivenSum(arr, k);
	}

	private static void SubArrayWithGivenSum(int[] arr, int k) {

		int sum = 0;
		int startIndex = -1;
		int endIndex = startIndex;
		var map = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			if (sum - k == 0) {
				startIndex = 0;
				endIndex = i;
				break;
			}
			
			//Works for positive integers
			//for negative integers it should be k-sum
			if(map.containsKey(sum-k)) {
				startIndex = map.get(sum-k)+1;
				endIndex = i;
				break;
			}else {
				map.put(sum, i);
			}
			
			
		}
		
		  if(startIndex==-1||endIndex==-1){
	            System.out.println(-1);
	            return;
	        }

		System.out.println("startIndex: " + startIndex + " endIndex: " + endIndex);

	}

}
