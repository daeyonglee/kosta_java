
public class InheritanceExample {
	public static void main(String[] args) {
		MountainBicycle mtb = new MountainBicycle(1001, "��õ��", "ī��", true);
		
		// ����
		System.out.println(mtb.id);
		System.out.println(mtb.brand);
		
		// �߰��� �޼ҵ� ȣ��
		mtb.printInfo(); 
		
		System.out.println(mtb.toString());
		System.out.println(mtb);
		
		mtb.some();
		
	}
}
