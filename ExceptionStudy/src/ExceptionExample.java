/**
 * ���ܶ�?
 * @author �̴��
 *
 */
public class ExceptionExample {
	
	public static void someMethod() {
		
		String message = null;
		String[] list = {"artist", "Musical", "actor"};
		try {
			System.out.println(message.length());
			System.out.println(100/0);
			System.out.println(list[0]);
			System.out.println(list[3]);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("����������1");
		} catch(NumberFormatException e) {
			System.out.println("����������2");
		} catch(NullPointerException e) {
			System.out.println("����������3");
		} catch(ArithmeticException e) {
			System.out.println("����������4");
		}
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("���ø����̼� ���۵�...");
		someMethod();
		System.out.println("���ø����̼� �����...");
	}
}
