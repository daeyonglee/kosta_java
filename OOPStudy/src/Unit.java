
/**
 * ����Ŭ������ ���� ������ �Ծ� ������ ���� �߻�Ŭ����
 * @author �̴��
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
		System.out.println("������ ������ŵ�ϴ�.");
	}
	
	public abstract void attack();
	public abstract void decrease();
	public abstract void move();
}
