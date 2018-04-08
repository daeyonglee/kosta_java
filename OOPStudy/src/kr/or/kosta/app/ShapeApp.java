package kr.or.kosta.app;
/**
 * 상속 실습을 위한 애플리케이션 클래스
 * @author 이대용
 *
 */
public class ShapeApp {
	public static void main(String[] args) {
		
		Shape shape = new Shape(10, 10);
		
		shape.draw();
		System.out.println(shape.getLength());
		System.out.println(shape.getArea());
		
		shape = new Circle(10, 10, 15);
		shape.draw();
		System.out.println(shape.getLength());
		System.out.println(shape.getArea());
		
		shape = new Rectangle(10, 10, 25, 25);
		shape.draw();
		System.out.println(shape.getLength());
		System.out.println(shape.getArea());
		
		// 새롭게 추가된 메소드 호출을 위해 강제형변환(Demotion) 필요
		Circle circle = null;
		
		if (shape instanceof Circle) {
			circle = (Circle)shape;
			circle.someMethod();
		}
	}
}
