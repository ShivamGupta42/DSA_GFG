package sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class RelativeSorting {

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
		Pattern p = Pattern.compile(".");

		while (T > 0) {
			T--;

			int n = scan.nextInt();
			int m = scan.nextInt();

			int[] a = new int[n];

			TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

			for (int i = 0; i < n; i++) {
				a[i] = scan.nextInt();

				if (map.containsKey(a[i])) {
					map.put(a[i], map.get(a[i]) + 1);
				} else {
					map.put(a[i], 1);
				}
			}

			int b = 0;
			for (int i = 0; i < m; i++) {
				b = scan.nextInt();

				if (map.containsKey(b)) {
					for (int j = 0; j < map.get(b); j++) {
						bw.write(b + " ");
					}

					map.remove(b);
				}
			}

			int k = map.size();

			if (k != 0) {
				for (Entry<Integer, Integer> e : map.entrySet()) {
					for (int i = 0; i < e.getValue(); i++) {
						bw.write(e.getKey() + " ");
					}
				}
			}

			bw.write("\n");
			bw.flush();

		}

		bw.close();
	}
}
