
public class AutoSaver extends Thread{
	boolean stop = false;
	
	@Override
	public void run() {
		while(!stop) {
			System.out.println("저장합니다..");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("텍스트 프로그램 시작됨...");
		
		AutoSaver as = new AutoSaver();
		as.setDaemon(true);
		as.start();
		Thread.sleep(10000);
		System.out.println("텍스트 프로그램 종료됨...");
		
	}
}
