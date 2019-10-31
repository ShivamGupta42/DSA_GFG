package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class RearrangeZigZag {
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

		public static void main(String[] args) {
			FastReader scan = new FastReader();
			int T = scan.nextInt();
			
			while(T>0){
			    T--;
			    
			int n = scan.nextInt();   
		    int[] arr = new int[n];
		    
		    for(int i=0;i<n;i++) {
		    	arr[i]= scan.nextInt();
		    }
	        
			for(int i=0, k=0;i<n/2;i++) {
				arr[i]= arr[i] ^ arr[n-i-1];
				arr[n-i-1] = arr[i] ^ arr[n-i-1];
				arr[i] = arr[i] ^ arr[n-i-1];
			}
		    
			Arrays.stream(arr).forEach(e->System.out.print(e+" "));

		}
		    
		}
}
