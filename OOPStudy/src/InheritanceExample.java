
public class InheritanceExample {
	public static void main(String[] args) {
		MountainBicycle mtb = new MountainBicycle(1001, "삼천리", "카본", true);
		
		// 재사용
		System.out.println(mtb.id);
		System.out.println(mtb.brand);
		
		// 추가된 메소드 호출
		mtb.printInfo(); 
		
		System.out.println(mtb.toString());
		System.out.println(mtb);
		
		mtb.some();
		
	}
}
