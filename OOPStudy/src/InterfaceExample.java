
public class InterfaceExample {
	public static void main(String[] args) {
		
		Weapon weapon = new Gun();
		weapon.attack();
		
		weapon = new Sword();
		weapon.attack();
		
		weapon = new Club();
		weapon.attack();
		
	}
}
