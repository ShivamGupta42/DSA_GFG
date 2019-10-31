package sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class SortArrByFreq {

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
			int[] a = new int[n];

			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

			for (int i = 0; i < n; i++) {
				a[i] = scan.nextInt();
				if (!map.containsKey(a[i])) {
					map.put(a[i], 1);
				} else {
					map.put(a[i], map.get(a[i]) + 1);
				}

			} // end

			List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());

			Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
				@Override
				public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
					int k = (o2.getValue()).compareTo(o1.getValue());
					if (k != 0) {
						return k;
					} else {
						return o1.getKey() - o2.getKey();
					}
				}

			});

			int k = 0;
			for (Map.Entry<Integer, Integer> e : list) {
				  k = e.getKey();
				for (int i = 0; i < e.getValue(); i++) {
                   bw.write(k+" ");
				}
			}

			bw.write("\n");
			bw.flush();
		} // end test cases

		bw.close();
	}
}
