package BitMasking;

public class PermutationBitMasking {

	public static void main(String[] args) {
		char[] arr = { 'a', 'b', 'c', 'd' };

		for (int i = 1; i < Math.pow(2, arr.length); i++) {
			int k = 0;
			int l = i;

			while (l != 0) {
				if ((l & 1) == 0 ? false : true) {
					System.out.print(arr[k]);
				}
				l = l >> 1;
				k++;
			}
			System.out.println();
		}
	}
	
	static void Version2(String input) {
        int c = 1;
        for (int i = 0; i < (1 << input.length()); i++) {
            int k = 0;
            while((1 << k) <= i) {
                if(((1 << k) & i) != 0) {
                    System.out.print(input.charAt(k));
                }
                k++;
            }
            System.out.println();
        }
	}

}
