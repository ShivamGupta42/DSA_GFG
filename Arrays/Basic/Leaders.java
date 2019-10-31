package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Leaders {
	public static void main(String[] args) {
		int[] arr = { 16, 17, 4, 3, 5, 2 };
		leadersNonStack(arr);
		leaders(arr);
		leadersOptimized(arr);
	}

	private static void leaders(int[] arr) {
		Stack<Integer> s = new Stack<>();

		int max = -1;

		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] > max) {
				max = arr[i];
				s.push(arr[i]);
			}
		}

		int n = s.size();

		for (int j = 0; j < n; j++) {
			System.out.print(s.pop() + " ");
		}

		System.out.println();
	}

	private static void leadersNonStack(int[] arr) {

		int max = -1;
		int n = arr.length;
		int[] arr2 = new int[n];
		Arrays.fill(arr2, 0, n, -1);

		for (int i = n - 1, k = n - 1; i >= 0; i--) {
			if (arr[i] > max) {
				max = arr[i];
				arr2[k] = arr[i];
				k--;
			}
		}

		if (arr2.length == 0) {
			System.out.println("");
			return;
		}

		StringJoiner sj = new StringJoiner(" ");

		for (int i = n - 1; i >= 0; i--) {
			if (arr2[i] != -1) {
				continue;
			} else {
				for (int j = i + 1; j <= n - 1; j++) {
					sj.add(String.valueOf(arr2[j]));
				}

				break;
			}
		}

		System.out.println(sj.toString());
	}

	private static void leadersOptimized(int[] arr) {

		int n = arr.length;
		int max = arr[n-1];
		String s=""+max;
	
		
		for (int i = n -2; i >= 0; i--) {
			if (arr[i] > max) {
				max = arr[i];
				s=arr[i]+" "+s;
			}

		}

		System.out.println(s);

	}

	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		
		public FastReader() {
			br= new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(st==null|!st.hasMoreElements()) {
				
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		Long nextLong() {
			return Long.parseLong(next());
		}
		
		String nextLine() {
			String str="";
			
			try {
				br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
		
		
	}

}
