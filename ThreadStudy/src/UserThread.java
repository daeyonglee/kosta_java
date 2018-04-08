
public class UserThread extends Thread{
	
	public UserThread() {
		this("noname");
	}
	
	public UserThread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		System.out.println(getName() + "������ ���۵�..");
		
		for (int i=0; i<50; i++) {
			System.out.println(getName() + "������ i ���: " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(getName() + "������ �����..");
	}
}
