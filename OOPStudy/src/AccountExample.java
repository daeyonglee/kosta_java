/**
 * ��Ʈ������Ʈ ������ ���ø����̼� Ŭ����
 */
public class AccountExample {

	public static void main(String[] args) {
		
		int num;
		num = 10;

		// Ŭ������ �޸𸮿� �Ҵ�(�ν��Ͻ� ����)
		Account account;
		account = new Account("1111-2222-3333", "�̴��", 10000000, 1111);
		
		// ������ �ν��Ͻ��� ������(�ν��Ͻ�����) ����
		// System.out.println(account.accountNum);
		// System.out.println(account.accountOwner);
		// System.out.println(account.restMoney);
		// System.out.println(account.passwd);
		account.print();

		// ������ �ν��Ͻ��� ������ �ʱ�ȭ
		/*
		account.accountNum = "1111-2222-3333";
		account.accountOwner = "�̴��";
		account.restMoney = 1000000000;
		account.passwd = 1111;
		*/
		// System.out.println(account.accountNum);
		// System.out.println(account.accountOwner);
		// System.out.println(account.restMoney);
		// System.out.println(account.passwd);
		account.print();


		// �׽�Ʈ�� ���� �ν��Ͻ� �޼ҵ� ȣ��

		boolean ok = account.checkPasswd(2222);
		if (ok) {
			long money = account.deposit(1000000);
			System.out.println("�����ܾ�: " + money);
			//money = account.withdraw(1000000000);
			System.out.println("�����ܾ�: " + money);
		} else {
			System.out.println("��й�ȣ�� Ȯ���Ͽ� �ּ���.");
		}

		Account acc = new Account();
		// System.out.println(acc.accountNum);
		acc.print();

		// Pass by Reference
		Account acc2 = account;
		// System.out.println(acc2.getRestMoney());
		acc2.print();
		
		// ������ �����ε� �׽�Ʈ
		Account a = new Account();
		/*Account a2 = new Account("3333", "ȫ�浿");
		Account a3 = new Account("4444", "�Ӳ���",  1234);*/
		Account a4 = new Account("5555", "�̼���", 3241, 1000000000);
		
//		a3.print();
		
		// ����ȭ �׽�Ʈ
		// a.accountNum = "1111-2222";
		
		a.setAccountNum("1111-2222");
		String n = a.getAccountNum();
		System.out.println(n);
	}
}
