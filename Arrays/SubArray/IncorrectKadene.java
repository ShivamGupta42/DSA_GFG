package SubArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//Solution in which there are so many checks for different test cases don't work
// the shorter a solution is the more general it is 
public class IncorrectKadene {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, -2, 5 };
		int[] arr2 = { -1, -2, -3, -4 };
		int [] arr3= {-2,5,-1};
		int [] arr4 = {23,23,-98,5};
		//maxSumSubArray(arr, 5);
		 maxSumSubArray(arr4, 4);
	}

	private static void maxSumSubArray(int[] arr, int n) {

		int sum = 0;
		int[] preSum = new int[n];
		int maxValue = Integer.MIN_VALUE;
		int minValue = Integer.MAX_VALUE;
		int startIndex = 0;
		int endIndex = 0;

		// endIndex
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			preSum[i] = sum;

			if (sum > maxValue) {
				maxValue = sum;
				endIndex = i;
			}

		}
		
		if(endIndex==0) {
			System.out.println(arr[0]);
			return;
		}

		
		// startIndex
		startIndex=0;
		int setOnIndex=0;
		for (int i = 0; i < endIndex; i++) {
			if (preSum[i] < minValue) {
				minValue = preSum[i];
				setOnIndex =i;
			}
		}
		
	    if(minValue<0) {
	    	startIndex=setOnIndex+1;
	    	sum=preSum[endIndex]-preSum[setOnIndex];
	    } 
	    
	    else {
	    	startIndex=0;
	    	sum=preSum[endIndex];
	    }
		
		
		System.out.println(startIndex + " " + endIndex);
        
		/*
		sum=0;
		for(int i=startIndex;i<=endIndex;i++) {
			sum+=arr[i];
		}
		*/
		
		System.out.println(sum);

	}

	static class FastReader {

		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {

			if (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			return st.nextToken();
		}

		String nextLine() {

			try {
				return br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return null;
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}

}
