package race;

import java.util.Random;

public class Horse extends Thread{
	public Horse(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		System.out.println(getName() +"�� ��ŸƮ...");
		Random r = new Random();
		for (int i=1; i<=100; i++) {
			System.out.println(getName() + "�� " + i + "���� ����...");
			try {
				Thread.sleep(r.nextInt(500));
			} catch (InterruptedException e) {
				System.out.println(getName() +"�� ���...");
			}
		}
		System.out.println("########### "+ getName() +"�� ���� �Ϸ� ###########");
	}
}
