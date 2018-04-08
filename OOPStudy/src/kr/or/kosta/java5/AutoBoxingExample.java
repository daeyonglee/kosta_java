package kr.or.kosta.java5;

public class AutoBoxingExample {
	public static void some(Integer i) {
		System.out.println(i);
	}
	
	public static void main(String[] args) {
//		Integer in = new Integer(10);
		Integer in = 10;
		
		int x = new Integer(100);
		
		some(200);
	}
}
