package race;

public class RaceGame {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("지금부터 경주마 게임을 시작합니다..");

		System.out.println("준비");
		
		Horse horse1 = new Horse("대용");
		Horse horse2 = new Horse("홍규");
		Horse horse3 = new Horse("세준");
		Horse horse4 = new Horse("방그리");

		
		System.out.println("땅");
		
		horse1.start();
		horse2.start();
		horse3.start();
		horse4.start();
		
		horse1.join();
		horse2.join();
		horse3.join();
		horse4.join();
		
		System.out.println("지금부터 경주마 게임을 종료합니다.");
	}
}
