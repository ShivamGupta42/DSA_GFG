package SubArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AdvancKadene {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, -2, 5 };
		int[] arr2 = { -1, -2, -3, -4 };
		// maxSumSubArray(arr, 5);
		maxSumSubArray(arr2, 4);
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

		// startIndex
		for (int i = 0; i <= endIndex; i++) {
			if (preSum[i] < minValue) {
				minValue = preSum[i];
				if (i != 0) {
					if (minValue < 0) {
						startIndex = i + 1;
					} else {
						startIndex = i;
					}
				}
			}
		}

		System.out.println(startIndex + " " + endIndex);

	}
	
	static class FastReader{
		
		BufferedReader br;
		StringTokenizer st;
		
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			
			if(st==null||!st.hasMoreTokens()) {
				try {
					st=new StringTokenizer(br.readLine());
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
