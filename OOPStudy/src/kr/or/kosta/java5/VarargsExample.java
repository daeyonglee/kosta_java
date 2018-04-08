package kr.or.kosta.java5;

public class VarargsExample {
	public static int sum(int[] args) {
		
		int sum = 0;
		for (int i : args) {
			sum += 1;
		}
		return sum;
	}
	
	public static int sum2(int...args) {

		int sum = 0;
		for (int i : args) {
			sum += 1;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int[] array = {10, 30, 70};
		sum(array);
		sum2(array);
	}
}
