import java.util.Random;

public class MathExample {
	public static void main(String[] args) {
		
		
		System.out.println(Math.PI);
		System.out.println(Math.E);
		
		System.out.println(Math.abs(-10));
		System.out.println(Math.round(75.68));
		System.out.println(Math.ceil(34.12));
		System.out.println(Math.floor(38.90));
		System.out.println(Math.sin(34.5));
		
		int lotto = (int)(Math.random() * 45) + 1;
		System.out.println(lotto);
		
		Random random = new Random();
		
		for (int i = 0; i < 6; i++) {
			System.out.println(random.nextInt(45) + 1);
		}
	}
}
