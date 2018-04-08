/**
 * JVM에 의해 자동 생성되는 main 스레드에 의해 자동 호출되는 엔트리포인트
 * @author 이대용
 *
 */
public class ThreadExample {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("메인스레드 시작됨...");
		
		for (int i=0; i<100; i++) {
			System.out.println("메인스레드 i 출력: " + i);
			Thread.sleep(100);
			if (i == 50) {
				UserThread thread = new UserThread("class5");
				// 스레드스케쥴러에 사용자스레드 등록
				thread.start();
				
				new Thread() {
					@Override
					public void run() {
						System.out.println("음악재생");
					}
				}.start();
				
				UserThread2 thread2 = new UserThread2();
				thread2.setSize(500,500);
				thread2.setVisible(true);
				
				new Thread(thread2).start();;
			}
		}
		
		System.out.println("메인스레드 종료됨...");
	}
}
