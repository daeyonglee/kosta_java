
public class AutoSaver extends Thread{
	boolean stop = false;
	
	@Override
	public void run() {
		while(!stop) {
			System.out.println("�����մϴ�..");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("�ؽ�Ʈ ���α׷� ���۵�...");
		
		AutoSaver as = new AutoSaver();
		as.setDaemon(true);
		as.start();
		Thread.sleep(10000);
		System.out.println("�ؽ�Ʈ ���α׷� �����...");
		
	}
}
