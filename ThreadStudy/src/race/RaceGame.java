package race;

public class RaceGame {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("���ݺ��� ���ָ� ������ �����մϴ�..");

		System.out.println("�غ�");
		
		Horse horse1 = new Horse("���");
		Horse horse2 = new Horse("ȫ��");
		Horse horse3 = new Horse("����");
		Horse horse4 = new Horse("��׸�");

		
		System.out.println("��");
		
		horse1.start();
		horse2.start();
		horse3.start();
		horse4.start();
		
		horse1.join();
		horse2.join();
		horse3.join();
		horse4.join();
		
		System.out.println("���ݺ��� ���ָ� ������ �����մϴ�.");
	}
}
