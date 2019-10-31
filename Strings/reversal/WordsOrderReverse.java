package reversal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class WordsOrderReverse {

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

			String s = scan.next();
			String[] splits = s.split("\\.");

			int size = splits.length;

			if (size > 0) {

				bw.write(splits[splits.length - 1]);

				for (int i = (splits.length - 2); i >= 0; i--) {
					bw.write("." + splits[i]);
				}
				bw.write("\n");
				bw.flush();
			}

			else {
				System.out.println("");
			}

		}

		bw.close();
	}
}
