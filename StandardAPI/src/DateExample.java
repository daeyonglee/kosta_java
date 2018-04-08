import java.util.Date;

public class DateExample {
	public static void main(String[] args) {
		
		Date now = new Date();
		
		System.out.println(now.getDate());
		System.out.println(now.getDay());
		System.out.println(now.getHours());
		System.out.println(now.getMinutes());
		
		System.out.println(now.toLocaleString());
	}
}
