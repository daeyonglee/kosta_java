/**
 * JVM�� ���� �ڵ� �����Ǵ� main �����忡 ���� �ڵ� ȣ��Ǵ� ��Ʈ������Ʈ
 * @author �̴��
 *
 */
public class ThreadExample {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("���ν����� ���۵�...");
		
		for (int i=0; i<100; i++) {
			System.out.println("���ν����� i ���: " + i);
			Thread.sleep(100);
			if (i == 50) {
				UserThread thread = new UserThread("class5");
				// �����彺���췯�� ����ڽ����� ���
				thread.start();
				
				new Thread() {
					@Override
					public void run() {
						System.out.println("�������");
					}
				}.start();
				
				UserThread2 thread2 = new UserThread2();
				thread2.setSize(500,500);
				thread2.setVisible(true);
				
				new Thread(thread2).start();;
			}
		}
		
		System.out.println("���ν����� �����...");
	}
}
