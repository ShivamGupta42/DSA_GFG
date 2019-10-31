package BitMasking;

public class SetBits {
	public static void main(String[] args) {
		int n = 1333;
		countSetBits1(n);
		countSetBits2(n);
		// isBitSet(12, 5);
	}

	private static boolean isBitSet(int x, int i) {
		return (x & (1 << i)) == 0 ? false : true;
	}

	
	private static void countSetBits1(int n) {
		int counter = 0;

		int k = countBits(n);

		for (int i = 0; i < k; i++) {
			if (isBitSet(n, i)) {
				counter++;
			}
		}

		System.out.println(counter);
	}

	static int countBits(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n >>= 1;
		}

		return count;
	}
	
	private static void countSetBits2(int n) {
		int count =0;
		
		while(n!=0) {
			count=count+ ((n&1)==0?0:1);
			n>>=1;
		}
		
		System.out.println(count);
		
	}
}
