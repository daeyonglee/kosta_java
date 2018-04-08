
/**
 * AccountManager 테스트를 위한 애플리케이션 클래스
 * @author 이대용
 *
 */
public class AMS {

	public static void main(String[] args) {

		AccountManager manager = new AccountManager();
		
		String accountNum = "1111-2222-3333";
		String accountOwner = "이대용";
		int passwd = 1111;
		long restMoney = 100000000L;
		
		// 신규계좌 개설
		manager.open(accountNum, accountOwner, passwd, restMoney);
		manager.open("4444-5555-6666", "홍길동", 2222, 20000000L);
		manager.open("1234-1234-1234", "임꺽정", 3333, 30000000L);
		manager.open("2222-3333-4444", "이대용", 4444, 40000000L);
		
		Account ac = new Account("5555-6666-7777", "이승훈", 1111, 10000);
		manager.open(ac);
		
		MinusAccount minusAccount = new MinusAccount("6666-7777-8888", "김대출", 1111, 10000, 100000);
		manager.open(new MinusAccount("3333-3333-3333", "김대추", 3333, 30000, 300000));
		manager.open(minusAccount);
		
		// 전체계좌 출력
		manager.printAll();
		
		// 계좌조회
		String num = "1234-1234-1234";
		Account acc = manager.get(num);
		
		System.out.println();
		
		acc.print();
		
		String keyword = "이대용";
		Account[] acc2 = manager.search(keyword);
		
		System.out.println();
		
		System.out.println("검색어: " + keyword);
		manager.print(acc2);
		
		System.out.println();
		
		boolean result = manager.remove("1111-2222-3333");

		if (result) {
			System.out.println("성공적으로 삭제되었습니다.");
		}
		
		System.out.println();
		
		manager.printAll();
		
		manager.remove("1234-1234-1234");
		
		System.out.println();
		manager.printAll();
	}

}
