import java.io.IOException;
import java.util.Scanner;

public class ScannerExample {
	public static void main(String[] args) throws IOException {
		
		System.out.print("����� �̸��� �Է��ϼ��� : ");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.print("����� ���̴¿�? : ");
		int age = sc.nextInt();
		System.out.print("����� �̸��� " + name +"�̱���..");
		System.out.print("���̴� " + age + "�̱���..");
		sc.close();
	}
}
