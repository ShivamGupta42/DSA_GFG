package SubArray;

public class Kadene {

	public static void main(String[] args) {
		int[] arr = {-1,-2,-3,-5};
		
		int curSumPositiveSegment=0;
		int maxSumPositiveSegment=Integer.MIN_VALUE;
		int startIndex=0;
		
		for(int i=0;i<arr.length;i++) {
			curSumPositiveSegment+=arr[i];
			
			if(maxSumPositiveSegment<curSumPositiveSegment) {
				maxSumPositiveSegment=curSumPositiveSegment;
			}
			
			if(curSumPositiveSegment<0) {
				curSumPositiveSegment=0;
			}
			
			
		}
		
		System.out.println(maxSumPositiveSegment);
	}
}
