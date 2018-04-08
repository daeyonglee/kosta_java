/**
 * String API Study..
 * 묵시적 생성시.. Pool에 이미 생성되어있다면, 두번 세번 새로 생성하지 않는다.
 * @author 이대용
 *
 */
public class StringExample {
	public static void main(String[] args) {
		String str1 = new String("Java Programming");
		String str2 = "Java Programming";
		char[] chars = {'J', 'a', 'v', 'a'};
		String str3 = new String(chars);
		
		String str4 = "Java Programming";
		
		System.out.println(str1 == str2);
		System.out.println(str2 == str4);
		
		String sub = str1.substring(0, 4);
		System.out.println(sub);
		
		System.out.println(str1.replace('J', 'A'));
		
		String ssn= "680313-1234567";
		
		char val = ssn.charAt(ssn.indexOf("-")+1);
		
		switch (val) {
		case '1':
			System.out.println("2000년도 이전 남자");
			break;
		case '2':
			System.out.println("2000년도 이전 여자");
			break;
		case '3':
			System.out.println("2000년도 이후 남자");
			break;
		case '4':
			System.out.println("2000년도 이후 여자");
			break;
		}
		
		System.out.println("javajavajavajava".lastIndexOf("j"));
		System.out.println("abc              ".trim().length());
	}
}
