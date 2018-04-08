import java.util.StringTokenizer;

public class StringTokenExample {

	public static void main(String[] args) {
		String cardNo = "1111 2222 3333 4444";
		
//		StringTokenizer st = new StringTokenizer(cardNo, " ");
		StringTokenizer st = new StringTokenizer(cardNo);
		System.out.println(st.countTokens());
		
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
}
