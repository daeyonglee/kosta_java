/**
 * 엔트리포인트 역할의 애플리케이션 클래스
 */
public class AccountExample {

	public static void main(String[] args) {
		
		int num;
		num = 10;

		// 클래스를 메모리에 할당(인스턴스 생성)
		Account account;
		account = new Account("1111-2222-3333", "이대용", 10000000, 1111);
		
		// 생성된 인스턴스의 데이터(인스턴스변수) 접근
		// System.out.println(account.accountNum);
		// System.out.println(account.accountOwner);
		// System.out.println(account.restMoney);
		// System.out.println(account.passwd);
		account.print();

		// 생성된 인스턴스의 데이터 초기화
		/*
		account.accountNum = "1111-2222-3333";
		account.accountOwner = "이대용";
		account.restMoney = 1000000000;
		account.passwd = 1111;
		*/
		// System.out.println(account.accountNum);
		// System.out.println(account.accountOwner);
		// System.out.println(account.restMoney);
		// System.out.println(account.passwd);
		account.print();


		// 테스트를 위한 인스턴스 메소드 호출

		boolean ok = account.checkPasswd(2222);
		if (ok) {
			long money = account.deposit(1000000);
			System.out.println("현재잔액: " + money);
			//money = account.withdraw(1000000000);
			System.out.println("현재잔액: " + money);
		} else {
			System.out.println("비밀번호를 확인하여 주세요.");
		}

		Account acc = new Account();
		// System.out.println(acc.accountNum);
		acc.print();

		// Pass by Reference
		Account acc2 = account;
		// System.out.println(acc2.getRestMoney());
		acc2.print();
		
		// 생성자 오버로딩 테스트
		Account a = new Account();
		/*Account a2 = new Account("3333", "홍길동");
		Account a3 = new Account("4444", "임꺽정",  1234);*/
		Account a4 = new Account("5555", "이순신", 3241, 1000000000);
		
//		a3.print();
		
		// 은닉화 테스트
		// a.accountNum = "1111-2222";
		
		a.setAccountNum("1111-2222");
		String n = a.getAccountNum();
		System.out.println(n);
	}
}
