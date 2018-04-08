package race;

import java.util.Random;

public class Horse extends Thread{
	public Horse(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		System.out.println(getName() +"말 스타트...");
		Random r = new Random();
		for (int i=1; i<=100; i++) {
			System.out.println(getName() + "말 " + i + "미터 전진...");
			try {
				Thread.sleep(r.nextInt(500));
			} catch (InterruptedException e) {
				System.out.println(getName() +"말 사망...");
			}
		}
		System.out.println("########### "+ getName() +"말 경주 완료 ###########");
	}
}
