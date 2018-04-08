package kr.or.kosta.app;
/**
 * ��� �ǽ��� ���� ���ø����̼� Ŭ����
 * @author �̴��
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
		
		// ���Ӱ� �߰��� �޼ҵ� ȣ���� ���� ��������ȯ(Demotion) �ʿ�
		Circle circle = null;
		
		if (shape instanceof Circle) {
			circle = (Circle)shape;
			circle.someMethod();
		}
	}
}
