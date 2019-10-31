package modifiedBS;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class firstCharOccur {

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
			int n = scan.nextInt();
			int k = scan.nextInt();
			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = scan.nextInt();
			}

			bw.write(bsLeftMostOccur(arr, k, 0, n - 1) + "\n");
			bw.flush();
		} // end of testcases
		bw.close();
	}

	private static int bs(int[] arr, int x, int l, int h) {

		if (l > h) {
			return -1;
		}

		int mid = l + (h - l) / 2;

		if (arr[mid] == x) {
			return mid;
		}

		if (arr[mid] > x) {
			return bsLeftMostOccur(arr, x, l, mid - 1);
		} else {
			return bsLeftMostOccur(arr, x, mid + 1, h);
		}
	}

	private static int bsInfinite(int[] arr, int n, int x, int l, int h) {
		if (l > h) {
			return -1;
		}

		if (arr[0] == x) {
			return 0;
		}

		int i = 1;

		while (arr[i] < x) {
			i = i * 2;
		}
		return bs(arr, x, i / 2, i);
	}
	
	
	private static int bsRotated(int[] arr, int n, int x, int l, int h) {
		if(l<h)return -1;
		
		int pivot = findPivot(arr, n,x, l, h);
		if(pivot!=-1) {
			if(x==arr[pivot]) 
			{
				
			}
		}
		return -1;
	}

	private static int findPivot(int[] arr, int n, int x, int l, int h) {

		if (l > h) {
			return -1;
		}

		int mid = l + (h - l) / 2;
		

		if (((arr[mid] > arr[mid-1])&&(arr[mid]>arr[mid+1]))||(mid==0||mid==n-1)) {
			return mid;
		}
		
		if (arr[mid] <= arr[l]) {
			return findPivot(arr, n,x, l, mid - 1);
		} else {
			return findPivot(arr, n,x, mid + 1, h);
		}

	}

	private static int bsLeftMostOccur(int[] arr, int x, int l, int h) {

		if (l > h) {
			return -1;
		}

		int mid = l + (h - l) / 2;

		if (arr[mid] == x && (mid == 0 || arr[mid - 1] != x)) {
			return mid;
		}

		if (arr[mid] >= x) {
			return bsLeftMostOccur(arr, x, l, mid - 1);
		} else {
			return bsLeftMostOccur(arr, x, mid + 1, h);
		}
	}

	private static int bsRightMostOccur(int[] arr, int n, int x, int l, int h) {

		if (l > h) {
			return -1;
		}

		int mid = l + (h - l) / 2;

		if (arr[mid] == x && (mid == n - 1 || arr[mid + 1] != x)) {
			return mid;
		}

		if (arr[mid] > x) {
			return bsRightMostOccur(arr, n, x, l, mid - 1);
		} else {
			return bsRightMostOccur(arr, n, x, mid + 1, h);
		}
	}

}
