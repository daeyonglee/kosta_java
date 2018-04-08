/*
 * 변수 선언 및 할당 테스트
 */
 public class VariableExample {
	public static void main(String[] args) {
		// 1. 변수 선언
		int age;

		// 2. 변수에 리터럴 할당
		age = 50;

		// 3. 변수 사용
		System.out.println(age);

		int age2;

		age2 = age;

		System.out.println(age2);

		//int x;		// 컴파일 에러
		int x = 10;

		System.out.println(x);
	}
}
