import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Formatter;
import java.util.List;
import java.util.Vector;

/**
 * �������� ���� ������ ���� Ŭ����
 * @author �̴��
 *
 */
public class AccountManager2 {

	private Vector<Account> accounts;
	private int index;
	
	public AccountManager2() {
		this(10);
	}
	
	public AccountManager2(int size) {
		accounts = new Vector<Account>(size, 2);
	}

	// Setter/Getter Method
	public Vector<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Vector<Account> accounts) {
		this.accounts = accounts;
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
		accounts.addElement(account);
	}
	
	/**
	 * ��ü���� ���
	 */
	public void printAll() {
		System.out.println("===============================================================");
		System.out.println(String.format("%1$9s", "���¹�ȣ")+ String.format("%1$17s", "������") + String.format("%1$13s", "��й�ȣ")
							+ String.format("%1$13s", "�����ܾ�") + String.format("%1$13s", "����ݾ�"));
		System.out.println("===============================================================");
		Enumeration<Account> e = accounts.elements();
		
		while(e.hasMoreElements()) {
			Account a = e.nextElement();
			System.out.println(a);
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
		
		Enumeration<Account> e = accounts.elements();
		while(e.hasMoreElements()) {
			Account acc = e.nextElement();
			if (acc.getAccountNum().equals(accountNum)) {
				return acc;
			}
		}
		return null;
	}
	
	/**
	 * @param accountOwner		�˻��ϰ��� �ϴ� �����ָ�
	 * @return					�˻��� ���µ�
	 */
	public List<Account> search(String accountOwner) {
		
		List<Account> list = new ArrayList<Account>();
		Enumeration<Account> e = accounts.elements();
		while(e.hasMoreElements()) {
			Account acc = e.nextElement();
			if (acc.getAccountOwner().equals(accountOwner)) {
				list.add(acc);
			}
		}
		
		return list;
	}
	
	/**
	 * @param accountNum		�����ϰ��� �ϴ� ���¹�ȣ
	 * @return					��������
	 */
	public boolean remove(String accountNum) {

		Enumeration<Account> e = accounts.elements();
		while(e.hasMoreElements()) {
			Account acc = e.nextElement();
			if (acc.getAccountNum().equals(accountNum)) {
				accounts.removeElement(acc);
				return true;
			}
		}
		
		return false;
	}
}
