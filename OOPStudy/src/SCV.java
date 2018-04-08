
public class SCV extends Unit{


	public SCV() {
		this(null, 0, null);
	}
	
	public SCV(String name, int energy, Weapon weapon) {
		this.name = name;
		this.energy = energy;
		this.weapon = weapon;
	}

	@Override
	public void attack() {
		weapon.attack();
	}

	@Override
	public void decrease() {
		System.out.println("SCVÀÇ decrease()");
	}

	@Override
	public void move() {
		System.out.println("SCVÀÇ move()");
	}

	public void work() {
		System.out.println("SCVÀÇ work()");
	}
}
