package Array;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class EquilibriumPoint {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public Reader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}

	public static void main(String[] args) throws IOException {
		Reader scan = new Reader();
		int T = scan.nextInt();

		while (T > 0) {
			T--;

			int n1 = scan.nextInt();

			
			int[] preSum = new int[n1];
			int sum = 0;

			for (int i = 0; i < n1; i++) {
				sum += scan.nextInt();
				preSum[i] = sum;

			} // end of taking value
			

			int index = 0;
			int rightMax = preSum[n1 - 1];

			boolean pointFound = false;


			for (int i = 1; i < n1-1; i++) {
				if (preSum[i - 1] == (rightMax - preSum[i])) {
					index = i;
					pointFound = true;
					break;
				}
			}

			if (pointFound) {
				System.out.println(index+1);
			} else if(n1==1){
				System.out.println(1);
			}
			else{
				System.out.println(-1);
			}


		} // end of testcases

	}

}
