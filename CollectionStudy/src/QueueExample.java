import java.util.LinkedList;
import java.util.Queue;

/**
 * FIFO ����
 * @author �̴��
 *
 */
public class QueueExample {
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		queue.offer("���̿���");
		queue.offer("�̱���");
		queue.offer("���");
		
		System.out.println(queue.peek());
		System.out.println(queue.size());
		System.out.println(queue.poll());
		System.out.println(queue.size());
	}
}
