
/**
 * 서브클래스에 대한 수직적 규약 제공을 위한 추상클래스
 * @author 이대용
 *
 */
public abstract class Unit {

	protected String name;
	protected int energy;
	protected Weapon weapon;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	
	public void stop() {
		System.out.println("유닛을 정지시킵니다.");
	}
	
	public abstract void attack();
	public abstract void decrease();
	public abstract void move();
}
