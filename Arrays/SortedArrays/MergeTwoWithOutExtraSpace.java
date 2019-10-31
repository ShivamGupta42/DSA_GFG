package SortedArrays;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;



public class MergeTwoWithOutExtraSpace {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
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

	public static void main(String[] args) throws IOException {
		FastReader scan = new FastReader();
		int T = scan.nextInt();

		while (T > 0) {
			T--;

			int n1 = scan.nextInt();
			int n2 = scan.nextInt();
			int[] arr1 = new int[n1];
			int[] arr2 = new int[n2];

			for (int i = 0; i < n1; i++) {
				arr1[i] = scan.nextInt();
			}

			for (int i = 0; i < n2; i++) {
				arr2[i] = scan.nextInt();
			}
			
			int k1=0;
			
			while(k1<n1) {
				
				if(arr1[k1]<arr2[0]) {
					k1++;
					continue;
				}
				
				else {
					swap(arr1, arr2, k1, 0);
					
					int l=0;
				    while(l<n2-1) {
				    	if(arr2[l]>arr2[l+1]) {
				    		swap(arr2, arr2, l, l+1);
				    	}
				    	else {
				    		break;
				    	}
				    	l++;
				    }
				    
				    
				    k1++;
				}
			}
			
			//print
			/*
		    Arrays.stream(arr1).forEach(e->System.out.print(e+" "));
		    Arrays.stream(arr2).forEach(e->System.out.print(e+" "));
		    *.
		    */
			/*
			 * StringBuilder sb = new StringBuilder();
			 */
			
			
			
			for(int i=0;i<n1;i++) {
				bw.write(arr1[i]+" ");
			}
			
			for(int i=0;i<n2;i++) {
				bw.write(arr2[i]+" ");
			}
			
		    bw.write("\n");
		    bw.flush();

		}

	}
	
	static void swap(int[] arr1, int[] arr2, int i, int j) {
		arr1[i] = arr1[i]+arr2[j];
		arr2[j] = arr1[i]-arr2[j];
		arr1[i] = arr1[i]-arr2[j];
	}
}
