package basic;

import java.util.Scanner;

class TOH {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();

		while (T-- != 0) {
			int n = scan.nextInt();
			int k = scan.nextInt();
			TOH(n, 1, 3, 2, k);
		}
	}

	static void TOH(int n, int fr, int to, int aux, int k) {
		if (n == 1) {
			System.out.println(fr + " " + to);
			return;
		}

	}
	
	static void TOH_Iterative(int n, int k) {
		
		for(int i=0;i<n;i++) {
			
		}
		
	}
}