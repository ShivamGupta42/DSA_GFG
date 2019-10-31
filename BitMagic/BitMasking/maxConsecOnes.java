package BitMasking;

public class maxConsecOnes {

	public static void main(String[] args) {
		int n = 222;
		System.out.println(Integer.toBinaryString(n));
		System.out.println(maxConsecutiveOnes(n));
	}

	
	public static int maxConsecutiveOnes(int x) {
		int curCon = 0;
		int maxCon = 0;

		while (x != 0) {

			if ((x & 1) != 0) {
				curCon++;
				if (curCon > maxCon) {
					maxCon = curCon;
				}
			} else {
				curCon = 0;
			}
			x = x >> 1;
		} // end of loop

		return maxCon;
	}
}
