
public class AbstractExample {
	public static void main(String[] args) {
		
		Unit[] unit = {new SCV("∏€√Ê¿Ã", 100, new Gun()), new Marine("±Ë¿œ∫¥", 100, new Sword())};
		
		unit[0].stop();
		unit[0].attack();
		unit[0].decrease();
		unit[0].move();
		
		unit[1].stop();
		unit[1].attack();
		unit[1].move();
		unit[1].decrease();
		
	}
}
