package subArray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class LargestSubWithZeroSum {

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
			int n = scan.nextInt();
			int maxLength = 0;
			int sum = 0;
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

			for (int i = 0; i < n; i++) {
				sum += scan.nextInt();

				if (sum == 0 && maxLength < i + 1) {
					maxLength = i + 1;
				}

				if (map.containsKey(sum)) {
					if (i - map.get(sum) > maxLength) {
						maxLength = i - map.get(sum) ;
					}
				} else {
					map.put(sum, i);
				}

			}

			bw.write(maxLength + "\n");
			bw.flush();

		} // end test cases

		bw.close();
	}
}
