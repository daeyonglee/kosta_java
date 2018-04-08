
public class WrapperExample {
	public static void main(String[] args) {
		int i = 150;
		
		Integer integer = new Integer(i);
		Integer integer2 = Integer.valueOf(i);
		
		int x = integer2.intValue();
		
		String num = "1987";
		int y = integer.parseInt(num);
		
		System.out.println(y + 13);
		
		System.out.println(Integer.toBinaryString(y));
		System.out.println(Integer.toHexString(y));
		System.out.println(Integer.toOctalString(y));
	}
}
