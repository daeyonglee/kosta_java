package kr.or.kosta.app;

public class Circle extends Shape{

	private double radian;
	
	public Circle() {
		super();
	}

	public Circle(double x, double y, double radian) {
		super(x, y);
		this.radian = radian;
	}

	public double getRadian() {
		return radian;
	}

	public void setRadian(double radian) {
		this.radian = radian;
	}

	@Override
	public void draw() {
		System.out.println("(" + super.getX() + ", " + super.getY() + "), radian: " + getRadian());
	}
	
	@Override
	public double getLength() {
		return (2 * Math.PI * getRadian());
	}
	
	@Override
	public double getArea() {
		return (Math.PI * getRadian() * getRadian());
	}

	@Override
	public String toString() {
		return "Circle [radian=" + radian + ", getX()=" + getX() + ", getY()=" + getY() + "]";
	}
	
	// 부모클래스에 없는 새로 추가된 메소드
	public void someMethod() {
		System.out.println("someMethod() 입니다.");
	}
	
}
