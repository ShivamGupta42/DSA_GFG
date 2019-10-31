package Strings;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class lastIndexOf1 {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			if (st == null || !st.hasMoreElements()) {
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

	}

	public static void main(String[] args) throws IOException {

		FastReader f = new FastReader();
		int T = f.nextInt();

		while (T > 0) {
			T--;
			char[] c = f.next().toCharArray();
			int lastIndexOf1 = -1;

			for (int i = 0; i < c.length; i++) {
				if (Character.getNumericValue(c[i]) == 1) {
					lastIndexOf1 = i;
				}
			}

			System.out.println(lastIndexOf1);

		}
	}
}
