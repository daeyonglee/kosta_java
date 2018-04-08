package kr.or.kosta.app;

public class Rectangle extends Shape {

	private double width;
	private double height;
	
	public Rectangle() {
		super();
	}

	public Rectangle(double x, double y, double width, double height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}
	
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	public void draw() {
		System.out.println("(" + super.getX() + ", " + super.getY() + "), width: " + getWidth() + ", height: " + getHeight());
	}
	
	@Override
	public double getLength() {
		return (width + height) * 2;
	}
	
	@Override
	public double getArea() {
		return (width * height);
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + ", getX()=" + getX() + ", getY()=" + getY() + "]";
	}
}
