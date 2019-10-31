package SubArray;

public class BinarySubArraysSpan {

	public static void main(String[] args) {
		int[] a = new int[] { 0, 1, 0, 1, 1, 1, 1 };
		int[] b = new int[] { 1, 1, 1, 1, 1, 0, 1 };
		maxLengthCommonSubSpan(a, b);

	}

	private static void maxLengthCommonSubSpan(int[] a, int[] b) {
		int maxLength = 0;
		int prefixSum1 = 0;
		int prefixSum2 = 0;
		int cur_diff = 0;
		int startIndex = 0;
		int endIndex = 0;
		int len = a.length;

		int[] diffIndex = new int[2 * a.length + 1];

		for (int i = 0; i < 2 * len + 1; i++) {
			diffIndex[i] = -1;
		}

		for (int i = 0; i < len; i++) {
			prefixSum1 += a[i];
			prefixSum2 += b[i];
			cur_diff = len + prefixSum1 - prefixSum2;

			
			if(cur_diff==0) {
				if(i+1>maxLength) {
					startIndex=0;
					endIndex=i;
					maxLength=i+1;
				}
			}
			
			if (diffIndex[cur_diff] == -1) {
				diffIndex[cur_diff] = i;
			}

			
			
			else {
				startIndex = diffIndex[cur_diff]+1;
				endIndex = i;
				if (endIndex - startIndex + 1 > maxLength) {
					maxLength = endIndex - startIndex + 1;
				}
			}
		}

		System.out.println("The longest common subarray \nstarts from: " + startIndex + "\nand ends at: " + endIndex+"\nmax: "+maxLength);
	}

}
