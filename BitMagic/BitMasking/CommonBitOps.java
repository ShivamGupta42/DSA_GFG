package BitMasking;

public class CommonBitOps {

	public static void main(String[] args) {
		// 100000

		int i = 31, k = 3;
		System.out.println(Integer.toBinaryString(i));
		countBits(i);
		countBitsBKAlgorithm(i);
		firstSetBit(i);
		checkIfKthBitIsSet(i, k);
		numberIsEven(i);
	}

	private static void numberIsEven(int x) {
		if (x == 0) {
			System.out.println("Number zero is not a power of two");
			return;
		}
		System.out
				.println("Number " + x + " is" + (((x & (x - 1)) == 0 && x != 0) ? "" : " not ") + " a power of two.");

	}

	private static void checkIfKthBitIsSet(int i, int k) {
		String str = (((i & 1 << (k - 1)) == 0) ? "not" : ""); // for 1 1<<0 is 1

		System.out.println("The " + k + " bit of number " + i + " is " + str + " set");
	}

	private static void countBits(int i) {
		int counter = 0;
		// Bit And operation. It is going to return zero unless the last bit is 1.
		while (i != 0) {
			counter += ((i & 1) == 0) ? 0 : 1;
			i = i >> 1;
		}
		System.out.println("Set Bits In Number : " + counter);
	}

	private static void countBitsBKAlgorithm(int i) {
		int counter = 0;

		while (i != 0) {
			i = (i & (i - 1));
			counter++;
		}
		System.out.println("Set Bits in Number Acc to BK : " + counter);
	}

	private static void firstSetBit(int i) {

		if (i == 0) {
			System.out.println("Zero Exception");
		}
		int counter = 0;
		// Bit And operation. It is going to return zero unless the last bit is 1.
		while (i != 0) {
			if ((i & 1) == 1) {
				System.out.println("First set bit index: " + counter);
				return;
			}
			counter++;
			i = i >> 1;
		}

		System.out.println("First set bit index:" + -1);
	}

}
