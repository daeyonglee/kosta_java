import java.util.LinkedList;
import java.util.Queue;

/**
 * FIFO 구조
 * @author 이대용
 *
 */
public class QueueExample {
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		queue.offer("라이온즈");
		queue.offer("이글즈");
		queue.offer("베어스");
		
		System.out.println(queue.peek());
		System.out.println(queue.size());
		System.out.println(queue.poll());
		System.out.println(queue.size());
	}
}
