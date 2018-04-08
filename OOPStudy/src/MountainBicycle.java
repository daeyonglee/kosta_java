/**
 * Bicycle 클래스를 확장하여 MountainBicycle 정의
 * @author 이대용
 *
 */
public class MountainBicycle extends Bicycle{
	Boolean suspension; //추가 속성
	
	public MountainBicycle() {
		this(0, null, null, false);
	}
	
	public MountainBicycle(int id, String brand, String frame, boolean suspension) {
		super(id, brand, frame);
		this.suspension = suspension;
	}
	
	// 추가 기능
	public void printInfo() {
		System.out.println("id: " + id);
		System.out.println("brand: " + brand);
		System.out.println("frame: " + frame);
		System.out.println("suspension: " + suspension);
	}
	
	public void some() {
		System.out.println("MountainBicycle의 some() 메소드입니다.");
	}
	
	@Override
	public String toString() {
		return super.toString() + ", " + suspension;
	}
}
