/**
 * Bicycle Ŭ������ Ȯ���Ͽ� MountainBicycle ����
 * @author �̴��
 *
 */
public class MountainBicycle extends Bicycle{
	Boolean suspension; //�߰� �Ӽ�
	
	public MountainBicycle() {
		this(0, null, null, false);
	}
	
	public MountainBicycle(int id, String brand, String frame, boolean suspension) {
		super(id, brand, frame);
		this.suspension = suspension;
	}
	
	// �߰� ���
	public void printInfo() {
		System.out.println("id: " + id);
		System.out.println("brand: " + brand);
		System.out.println("frame: " + frame);
		System.out.println("suspension: " + suspension);
	}
	
	public void some() {
		System.out.println("MountainBicycle�� some() �޼ҵ��Դϴ�.");
	}
	
	@Override
	public String toString() {
		return super.toString() + ", " + suspension;
	}
}
