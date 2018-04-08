package kr.or.kosta.java5;

public class Robot {
	public static void move(Directions direction) {
		
		switch(direction) {
			case EAST: System.out.println("�κ��� �������� �����Դϴ�."); break;
			case WEST: System.out.println("�κ��� �������� �����Դϴ�."); break;
			case SOUTH: System.out.println("�κ��� �������� �����Դϴ�."); break;
			case NORTH: System.out.println("�κ��� �������� �����Դϴ�.");	break;
		}
	}
	
	public static void main(String[] args) {
		move(Directions.EAST);
		move(Directions.NORTH);
		
		Directions[] list = Directions.values();
		
		for (Directions directions : list) {
			System.out.println(directions);
		}
		
		Directions dir = Directions.valueOf("NORTH");
		
		System.out.println(dir);
		
		System.out.println(Directions.NORTH == Directions.SOUTH);
		System.out.println(Directions.NORTH.equals(Directions.SOUTH));
	}
}