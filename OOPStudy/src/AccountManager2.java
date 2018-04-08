import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Formatter;
import java.util.List;
import java.util.Vector;

/**
 * 여러개의 계좌 관리를 위한 클래스
 * @author 이대용
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
	 * 신규계좌 개설
	 * @param accountNum		계좌번호
	 * @param accountOwner		예금주
	 * @param passwd			비밀번호
	 * @param restMoney			잔액
	 */
	public void open(String accountNum, String accountOwner, int passwd, long restMoney) {
		Account account = new Account(accountNum, accountOwner, passwd, restMoney);
		open(account);
	}
	
	public void open(Account account) {
		accounts.addElement(account);
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
	 * @param accountOwner		검색하고자 하는 예금주명
	 * @return					검색된 계좌들
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
	 * @param accountNum		삭제하고자 하는 계좌번호
	 * @return					삭제여부
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
