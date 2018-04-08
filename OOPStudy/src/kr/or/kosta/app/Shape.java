package kr.or.kosta.app;

public class Shape {
	private double x;
	private double y;
	
	public Shape() {}

	public Shape(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void draw() {
		System.out.println("(" + getX() + ", " + getY() + ")");
	}
	
	public double getLength() {
		return 0.0;
	}
	
	public double getArea() {
		return 0.0;
	}

	@Override
	public String toString() {
		return "Shape [x=" + x + ", y=" + y + "]";
	}
}
