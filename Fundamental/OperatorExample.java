public class OperatorExample {
	public static void main(String[] args) {
		
		int x = 30, y = 10;

		System.out.println("결과 : " + (x + y));
		System.out.println(x % y);

		x += y;		// x = x + y;

		System.out.println(x);

		double weight = 70.345;
		System.out.println((int)weight);

		System.out.println(x == y);
		System.out.println(x != y);

		System.out.println(false && true);
		System.out.println(true || false);

		int a=2, b=3, c=1, max;

		max = (a > b) ? a : b;
		max = (max > c) ? max : c;

		System.out.println("최대값 : " + max);
	}
}
