public class MethodExample {

	public static void main(String[] args) {
		
		int x = 50, y = 30;
		
		System.out.println(sum(x, y));

		printDan(9);


	}

	public static int sum(int x, int y) {

		return x + y;

	}

	public static void printDan(int i) {

		for (int j=1; j<10; j++) {
			System.out.print(i + " * " + j + " = " + (i * j) + "\t");
		}
		System.out.println();
		
	}

}
