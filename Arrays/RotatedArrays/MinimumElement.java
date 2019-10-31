package RotatedArrays;

import java.util.Optional;

public class MinimumElement {

	public static void main(String[] args) {
		
		int[] arr = new int[] {5, 6, 1, 2, 3, 4};
		int[] arr2 = new int[] {2,3,4,5,6,1};
		System.out.println(minElement(arr2).get());
	}

	private static Optional<Integer> minElement(int[] arr) {
		int trend=1;
		
		for(int i=0;i<arr.length-1;i++) {
			trend=arr[i+1]-arr[i];
			if(trend<0) return Optional.of(arr[i+1]);
		}
		
		return Optional.empty();
	}
}
