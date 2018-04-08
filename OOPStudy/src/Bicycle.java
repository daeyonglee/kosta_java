
public class Bicycle {
	int id;
	String brand;
	String frame;
	
	public Bicycle() {
		this(0, null, null);
	}
	
	public Bicycle(int id, String brand, String frame) {
		this.id = id;
		this.brand = brand;
		this.frame = frame;
		
	}
	
	public void some() {
		System.out.println("Bicycle의 some()메소드 입니다.");
	}
	
	@Override
	public String toString() {
		return + id + ", " + brand + ", " + frame;
	}
}
