package Sorting;

public class BubSort {
	
	public static void main(String[] args) {

		
		int[] data  = {12,43,1,3224,43,5,45678};
        printArr(data);
        sorter(data);
        
	}

	static void sorter(int[] data) {
		
		
		for(int i=0;i<data.length-2;i++) {
			
			for(int j=0;j<data.length-1-i;j++) {
				
				if(data[j]>data[j+1]) {
					int temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}
			}
			
		}
		
		
		printArr(data);
	}
	
	static void printArr(int[] arr) {
		System.out.println("\n\n");
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}
}
