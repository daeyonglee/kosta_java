/**
 * ���۷���Ÿ�� �迭 ����, ����, �ʱ�ȭ
 * @author �̴��
 *
 */
public class ReferenceArrayExample {
	public static void main(String[] args) {
		
		String[] array;
		
		array = new String[5];
		
		array[0] = "�̴��1";
		array[1] = "�̴��2";
		array[2] = "�̴��3";
		array[3] = "�̴��4";
		array[4] = "�̴��5";
		
		for (String string : array) {
			System.out.println(string + "(" + string.length() + ")");
		}
		
		// ������� ����
		Account[] accounts;
		accounts = new Account[100];
		
		// �ű԰��� ����
		int count = 0;
		
		String accountNum = "1111-2222-3333";
		String accountOwner = "�̴��";
		int passwd = 1111;
		long restMoney = 100000000L;
		
		accounts[count] = new Account(accountNum, accountOwner, passwd, restMoney);
		count++;
		
		accounts[count] = new Account("4444-5555-6666", "ȫ�浿", 2222, 20000000L);
		count++;
		
		// ��ü���� ���
		
		for (int i = 0; i < count; i++) {
			accounts[i].print();
		}
		
//		String[] strings = new String[] {"a","b","c","d","e"};
		String[] strings = {"a","b","c","d","e"};
	}
}