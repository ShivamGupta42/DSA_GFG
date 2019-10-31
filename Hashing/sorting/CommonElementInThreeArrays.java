package sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class CommonElementInThreeArrays {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static class Reader {
		BufferedReader br;
		StringTokenizer st;

		public Reader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			if (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}

			return st.nextToken();
		}

		Integer nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}
	}

	public static void main(String[] args) throws IOException {

		Reader scan = new Reader();
		int T = scan.nextInt();

		while (T > 0) {
			T--;
			int a = scan.nextInt();
			int b = scan.nextInt();
			int c = scan.nextInt();
			HashSet<Integer> set1 = new HashSet<Integer>();
			HashSet<Integer> set2 = new HashSet<Integer>();

			for (int i = 0; i < a; i++) {
				set1.add(scan.nextInt());
			}

			int k = 0;
			for (int i = 0; i < b; i++) {
				k = scan.nextInt();
				if (set1.contains(k)) {
					set2.add(k);
				}
			}

			int comAB = set2.size();
			if(comAB==0) {
				bw.write("-1\n");
				bw.flush();
				continue;
			}
			
			int comABC=0;
			for (int i = 0; i < c; i++) {
				k = scan.nextInt();
				if (set2.contains(k)) {
					comABC++;
					bw.write(k + " ");
					if (--comAB == 0) {
						break;
					}
				}
			}

			if(comABC==0) {
				bw.write("-1\n");
			} else {
				bw.write("\n");
			}
			
			bw.flush();

		} // end test cases

		bw.close();
	}
}
