
public class Marine extends Unit{

	public Marine() {
		this(null, 0, null);
	}
	
	public Marine(String name, int energy, Weapon weapon) {
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
		System.out.println("Marine¿« decrease()");
	}

	@Override
	public void move() {
		System.out.println("Marine¿« move()");
	}

}
