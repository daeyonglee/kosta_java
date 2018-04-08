package kr.or.kosta.ams.entity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import kr.or.kosta.ams.dao.AccountDao;

/**
 * �������� ���� ������ ���� Ŭ����
 * @author �̴��
 *
 */
public class AccountManager {

	private Vector<Account> accounts;
	private AccountDao dao;
	private int index;
	
	public AccountManager() throws IOException {
		this(10);
	}
	
	public AccountManager(int size) throws IOException {
		accounts = new Vector<Account>(size, 2);
		dao = new AccountDao();
	}

	// Setter/Getter Method
	public Vector<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Vector<Account> accounts) {
		this.accounts = accounts;
	}

	public AccountDao getDao() {
		return dao;
	}

	/**
	 * �ű԰��� ����
	 * @param accountNum		���¹�ȣ
	 * @param accountOwner		������
	 * @param passwd			��й�ȣ
	 * @param restMoney			�ܾ�
	 * @throws IOException 
	 */
	public void open(String accountNum, String accountOwner, int passwd, long restMoney) throws IOException {
		Account account = new Account(accountNum, accountOwner, passwd, restMoney);
		open(account);
	}
	
	public void open(Account account) throws IOException {
		
		// ���°���
		dao.create(account);
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
	 * @throws IOException 
	 */
	public Account get(String accountNum) throws IOException {
		
		Account account = dao.get(accountNum);
		
		if (account != null) {
			return account;
		}
		
		return null;
	}
	
	/**
	 * @param accountOwner		�˻��ϰ��� �ϴ� �����ָ�
	 * @return					�˻��� ���µ�
	 * @throws IOException 
	 */
	public Vector<Account> search(String accountOwner) throws IOException {
		
		Vector<Account> list = dao.search(accountOwner);
		
		if (list != null) {
			return list;
		}
		return null;
		
	}
	
	/**
	 * ���»���
	 * @param accountNum		�����ϰ��� �ϴ� ���¹�ȣ
	 * @return					��������
	 * @throws IOException 
	 */
	public boolean remove(String accountNum) throws IOException {

		return dao.remove(accountNum);
	}
	
	/**
	 * ���� ��� ��ȸ
	 * @return ��ȸ�� ���¸�� List
	 * @throws IOException
	 */
	public Vector<Account> listAll() throws IOException {
		return dao.listAll();
	}
}
