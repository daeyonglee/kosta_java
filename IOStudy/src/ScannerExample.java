import java.io.IOException;
import java.util.Scanner;

public class ScannerExample {
	public static void main(String[] args) throws IOException {
		
		System.out.print("당신의 이름을 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.print("당신의 나이는요? : ");
		int age = sc.nextInt();
		System.out.print("당신의 이름은 " + name +"이군요..");
		System.out.print("나이는 " + age + "이군요..");
		sc.close();
	}
}
