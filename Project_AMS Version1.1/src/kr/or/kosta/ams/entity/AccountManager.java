package kr.or.kosta.ams.entity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import kr.or.kosta.ams.dao.AccountDao;

/**
 * 여러개의 계좌 관리를 위한 클래스
 * @author 이대용
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
	 * 신규계좌 개설
	 * @param accountNum		계좌번호
	 * @param accountOwner		예금주
	 * @param passwd			비밀번호
	 * @param restMoney			잔액
	 * @throws IOException 
	 */
	public void open(String accountNum, String accountOwner, int passwd, long restMoney) throws IOException {
		Account account = new Account(accountNum, accountOwner, passwd, restMoney);
		open(account);
	}
	
	public void open(Account account) throws IOException {
		
		// 계좌개설
		dao.create(account);
	}
	
	/**
	 * 전체계좌 출력
	 */
	public void printAll() {
		System.out.println("===============================================================");
		System.out.println(String.format("%1$9s", "계좌번호")+ String.format("%1$17s", "예금주") + String.format("%1$13s", "비밀번호")
							+ String.format("%1$13s", "현재잔액") + String.format("%1$13s", "대출금액"));
		System.out.println("===============================================================");
		Enumeration<Account> e = accounts.elements();
		
		while(e.hasMoreElements()) {
			Account a = e.nextElement();
			System.out.println(a);
		}
	}
	
	/**
	 * @param obj		출력하고자 하는 객체 (배열 혹은 단일객체)
	 */
	public void print(Object obj) {
		
		if (obj == null)
		{
			System.out.println("조회된 계좌가 존재하지 않습니다.");
		} else {
			System.out.println("조회된 계좌 정보는 아래와 같습니다.");
			System.out.println("계좌번호\t예금주\t비밀번호\t현재잔액");
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
	 * @param accountNum		조회하고자 하는 계좌번호
	 * @return					조회된 계좌정보
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
	 * @param accountOwner		검색하고자 하는 예금주명
	 * @return					검색된 계좌들
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
	 * 계좌삭제
	 * @param accountNum		삭제하고자 하는 계좌번호
	 * @return					삭제여부
	 * @throws IOException 
	 */
	public boolean remove(String accountNum) throws IOException {

		return dao.remove(accountNum);
	}
	
	/**
	 * 계좌 목록 조회
	 * @return 조회된 계좌목록 List
	 * @throws IOException
	 */
	public Vector<Account> listAll() throws IOException {
		return dao.listAll();
	}
}
