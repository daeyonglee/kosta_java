import java.util.Stack;

/**
 * LIFO ����
 * @author �̴��
 *
 */
public class StackExample {
	public static void main(String[] args) {
		Stack stack = new Stack();
		
		stack.push("AAAA");
		stack.push("BBBB");
		stack.push("CCCC");
		
		
		System.out.println(stack.pop());
		System.out.println(stack.size());
		System.out.println(stack.peek());
		System.out.println(stack.size());
	}
}
