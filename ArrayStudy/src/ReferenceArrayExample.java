/**
 * 레퍼런스타입 배열 선언, 생성, 초기화
 * @author 이대용
 *
 */
public class ReferenceArrayExample {
	public static void main(String[] args) {
		
		String[] array;
		
		array = new String[5];
		
		array[0] = "이대용1";
		array[1] = "이대용2";
		array[2] = "이대용3";
		array[3] = "이대용4";
		array[4] = "이대용5";
		
		for (String string : array) {
			System.out.println(string + "(" + string.length() + ")");
		}
		
		// 은행계좌 관리
		Account[] accounts;
		accounts = new Account[100];
		
		// 신규계좌 개설
		int count = 0;
		
		String accountNum = "1111-2222-3333";
		String accountOwner = "이대용";
		int passwd = 1111;
		long restMoney = 100000000L;
		
		accounts[count] = new Account(accountNum, accountOwner, passwd, restMoney);
		count++;
		
		accounts[count] = new Account("4444-5555-6666", "홍길동", 2222, 20000000L);
		count++;
		
		// 전체계좌 출력
		
		for (int i = 0; i < count; i++) {
			accounts[i].print();
		}
		
//		String[] strings = new String[] {"a","b","c","d","e"};
		String[] strings = {"a","b","c","d","e"};
	}
}