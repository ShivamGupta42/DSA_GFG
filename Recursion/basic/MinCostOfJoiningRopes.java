package basic;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MinCostOfJoiningRopes {

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
			int size = scan.nextInt();
			int[] arr = new int[size];
			int i = 0;
			while (i < size) {
				arr[i++] = scan.nextInt();
			}

			Arrays.sort(arr);
			long sum = arr[0];
			long cost = 0;

			for (int k = 1; k < size; k++) {
				sum = sum + arr[k];
				cost += sum;
			}

			bw.write(cost + "\n");
			bw.flush();
		} // end of testcases
		bw.close();
	}


	//This problem can only be solved using a priority Queue
	//because at every step I need to sum the lowest two elements in the array

	static void usingPQ() throws IOException {
		Reader scan = new Reader();
		int T = scan.nextInt();

		while (T > 0) {
			T--;
			int size = scan.nextInt();
			int[] arr = new int[size];
			int i = 0;
			long cost = 0;

			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			while (i < size) {
				pq.add(scan.nextInt());
				i++;
			}
			int a = 0, b = 0;
			while (pq.size() >= 2) {
				a = pq.poll();
				b = pq.poll();
				cost = cost + a + b;
				pq.add(a + b);
			}

			bw.write(cost + "\n");
			bw.flush();
		} // end of testcases
		bw.close();
	}

}
