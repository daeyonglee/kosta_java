public class WhileExample {

	public static void main(String[] args) {
		
		int cnt = 1;

		while (cnt <= 10) {
			System.out.println("열번찍기 " + cnt);

			cnt++;
		}

		int i = 0;
		int sum = 0;
		
		do {
			
			sum += i;
			i++;

		} while (i <= 100);

		System.out.println("누적합: " + sum);
	}

}
