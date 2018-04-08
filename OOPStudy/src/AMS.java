
/**
 * AccountManager �׽�Ʈ�� ���� ���ø����̼� Ŭ����
 * @author �̴��
 *
 */
public class AMS {

	public static void main(String[] args) {

		AccountManager manager = new AccountManager();
		
		String accountNum = "1111-2222-3333";
		String accountOwner = "�̴��";
		int passwd = 1111;
		long restMoney = 100000000L;
		
		// �ű԰��� ����
		manager.open(accountNum, accountOwner, passwd, restMoney);
		manager.open("4444-5555-6666", "ȫ�浿", 2222, 20000000L);
		manager.open("1234-1234-1234", "�Ӳ���", 3333, 30000000L);
		manager.open("2222-3333-4444", "�̴��", 4444, 40000000L);
		
		Account ac = new Account("5555-6666-7777", "�̽���", 1111, 10000);
		manager.open(ac);
		
		MinusAccount minusAccount = new MinusAccount("6666-7777-8888", "�����", 1111, 10000, 100000);
		manager.open(new MinusAccount("3333-3333-3333", "�����", 3333, 30000, 300000));
		manager.open(minusAccount);
		
		// ��ü���� ���
		manager.printAll();
		
		// ������ȸ
		String num = "1234-1234-1234";
		Account acc = manager.get(num);
		
		System.out.println();
		
		acc.print();
		
		String keyword = "�̴��";
		Account[] acc2 = manager.search(keyword);
		
		System.out.println();
		
		System.out.println("�˻���: " + keyword);
		manager.print(acc2);
		
		System.out.println();
		
		boolean result = manager.remove("1111-2222-3333");

		if (result) {
			System.out.println("���������� �����Ǿ����ϴ�.");
		}
		
		System.out.println();
		
		manager.printAll();
		
		manager.remove("1234-1234-1234");
		
		System.out.println();
		manager.printAll();
	}

}
