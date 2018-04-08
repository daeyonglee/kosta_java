import kr.or.kosta.app.Shape;

public class ClassCastingExample {
	public static void main(String[] args) {
		Account account = new MinusAccount();
		
		MinusAccount ma = (MinusAccount)account;
		
		ma.getBorrowMoney();
		
		Object obj = new Account();
		obj = new MinusAccount();
		obj = new Shape();
		
		Shape shape = (Shape)obj;
		
		shape.draw();
		
		obj = new int[10];
		
		System.out.println(obj.toString());
		int[] array = (int[])obj;
		System.out.println(array.length);
		
		String s = "Çüº¯È¯";
	}
}
