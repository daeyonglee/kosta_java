
public class PriorityExample {
	public static void main(String[] args) {
		
		Thread mainThread = Thread.currentThread();
		System.out.println(mainThread.getPriority());
		System.err.println(mainThread.getName());
		System.out.println(mainThread.getThreadGroup());
		UserThread t1 = new UserThread("종찬");
		UserThread t2 = new UserThread("세준");
		
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		
		t1.start();
		t2.start();
		
		t1.setPriority(Thread.MAX_PRIORITY);
	}
}
