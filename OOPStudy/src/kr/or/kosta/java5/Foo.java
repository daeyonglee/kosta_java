package kr.or.kosta.java5;

@SuppressWarnings("all")
public class Foo {

	@Deprecated
	public void someMethod() {
		System.out.println("어노테이션 연습");
	}
	
	public static void main(String[] args) {
		Foo foo = new Foo();
		foo.someMethod();
	}
}
