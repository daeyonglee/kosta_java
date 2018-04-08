import java.util.Formatter;

/**
 * �������� ���� ������ ���� Ŭ����
 * @author �̴��
 *
 */
public class AccountManager {

	private Account[] accounts;
	private int count;
	private int index;
	
	public AccountManager() {
		this(100);
	}
	
	public AccountManager(int size) {
		accounts = new Account[size];
	}

	// Setter/Getter Method
	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	

	/**
	 * �ű԰��� ����
	 * @param accountNum		���¹�ȣ
	 * @param accountOwner		������
	 * @param passwd			��й�ȣ
	 * @param restMoney			�ܾ�
	 */
	public void open(String accountNum, String accountOwner, int passwd, long restMoney) {
		Account account = new Account(accountNum, accountOwner, passwd, restMoney);
		open(account);
	}
	
	public void open(Account account) {
		accounts[count] = account;
		count++;
	}
	
	/**
	 * ��ü���� ���
	 */
	public void printAll() {
		
		Formatter formatter = new Formatter();
		
		formatter.format("%1$13s", "���¹�ȣ");
		System.out.println("===============================================================");
		System.out.println(String.format("%1$9s", "���¹�ȣ")+ String.format("%1$17s", "������") + String.format("%1$13s", "��й�ȣ")
							+ String.format("%1$13s", "�����ܾ�") + String.format("%1$13s", "����ݾ�"));
		System.out.println("===============================================================");
		for (int i = 0; i < count; i++) {
				accounts[i].print();
		}
	}
	
	/**
	 * @param obj		����ϰ��� �ϴ� ��ü (�迭 Ȥ�� ���ϰ�ü)
	 */
	public void print(Object obj) {
		
		if (obj == null)
		{
			System.out.println("��ȸ�� ���°� �������� �ʽ��ϴ�.");
		} else {
			System.out.println("��ȸ�� ���� ������ �Ʒ��� �����ϴ�.");
			System.out.println("���¹�ȣ\t������\t��й�ȣ\t�����ܾ�");
			System.out.println("=====================================");
			
			if (obj instanceof Account[]) {
				Account[] acc = (Account[])obj;
				for (int i = 0; i < acc.length; i++) {
					
					if (acc[i] == null) {
						break;
					}
					
					acc[i].print();
				}
			}
			
			if (obj instanceof Account) {
				Account acc = (Account) obj;
				acc.print();
			}
		}
	}
	
	/**
	 * @param accountNum		��ȸ�ϰ��� �ϴ� ���¹�ȣ
	 * @return					��ȸ�� ��������
	 */
	public Account get(String accountNum) {
		for (int i = 0; i < count; i++) {
			if (accounts[i].getAccountNum().equals(accountNum)) {
				return accounts[i];
			}
		}
		
		return null;
	}
	
	/**
	 * @param accountOwner		�˻��ϰ��� �ϴ� �����ָ�
	 * @return					�˻��� ���µ�
	 */
	public Account[] search(String accountOwner) {
		
		// count�� 2�� �����鼭 null�� �ƴ� ���� ã�� ���� ��� ���°� �ִ��� ��ȸ�Ѵ�.
		// count / 2 �� ���� null�̸� �ش� ���� �������� �ٽ� 2�� ������, null�ƴϸ� �ش� ���� �������� 2�� ������.
		
		int start = 0;
		int end = accounts.length;
		int mid = (end - start) / 2;
		
		int index = countArrayCount(start,end,mid);
		
		if (index == 0) {
			return null;
		}
		
		Account[] rtAccounts = new Account[index];
		
		int cnt = 0;
		
		for (int i = 0; i < count; i++) {
			if (accounts[i].getAccountOwner().equals(accountOwner)) {
				rtAccounts[cnt] = accounts[i];
				cnt++;
			}
		}
		
		return rtAccounts;
	}
	
	
	/**
	 * �迭�� �� ������ ������ ���� �� ���� ã��
	 * @param start
	 * @param end
	 * @param mid
	 * @return
	 */
	private int countArrayCount(int start, int end, int mid) {
		if (start != end) {
			if (accounts[mid] == null) {
				countArrayCount(0, mid, (end-start)/2);
			} else {
				countArrayCount(mid, (end-start)/2, mid);
			}
		} else {
			index = mid;
		}
		
		return index;
	}
	
	/**
	 * @param accountNum		�����ϰ��� �ϴ� ���¹�ȣ
	 * @return					��������
	 */
	public boolean remove(String accountNum) {
		
		for (int i = 0; i < count; i++) {
			if (accounts[i].getAccountNum().equals(accountNum)) {
				// �迭 ũ�� �ϳ� ���̸鼭 �̵�
				accounts[i] = null;
				
				if (i != count-1) {
					for (int j=i; j < count; j++) {
						accounts[j] = accounts[j+1];
						
						if (j == count-1) {
							break;
						}
					}
				}
				count = count-1;
				return true;
			}
		}
		
		return false;
	}
}
