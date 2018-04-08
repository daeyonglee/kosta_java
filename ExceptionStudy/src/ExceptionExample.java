/**
 * 예외란?
 * @author 이대용
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
			System.out.println("으하하하하1");
		} catch(NumberFormatException e) {
			System.out.println("으하하하하2");
		} catch(NullPointerException e) {
			System.out.println("으하하하하3");
		} catch(ArithmeticException e) {
			System.out.println("으하하하하4");
		}
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("애플리케이션 시작됨...");
		someMethod();
		System.out.println("애플리케이션 종료됨...");
	}
}
