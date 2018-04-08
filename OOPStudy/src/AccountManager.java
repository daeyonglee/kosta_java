import java.util.Formatter;

/**
 * 여러개의 계좌 관리를 위한 클래스
 * @author 이대용
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
		accounts[count] = account;
		count++;
	}
	
	/**
	 * 전체계좌 출력
	 */
	public void printAll() {
		
		Formatter formatter = new Formatter();
		
		formatter.format("%1$13s", "계좌번호");
		System.out.println("===============================================================");
		System.out.println(String.format("%1$9s", "계좌번호")+ String.format("%1$17s", "예금주") + String.format("%1$13s", "비밀번호")
							+ String.format("%1$13s", "현재잔액") + String.format("%1$13s", "대출금액"));
		System.out.println("===============================================================");
		for (int i = 0; i < count; i++) {
				accounts[i].print();
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
		for (int i = 0; i < count; i++) {
			if (accounts[i].getAccountNum().equals(accountNum)) {
				return accounts[i];
			}
		}
		
		return null;
	}
	
	/**
	 * @param accountOwner		검색하고자 하는 예금주명
	 * @return					검색된 계좌들
	 */
	public Account[] search(String accountOwner) {
		
		// count를 2씩 나누면서 null이 아닌 값을 찾아 실제 몇개의 계좌가 있는지 조회한다.
		// count / 2 의 값이 null이면 해당 값의 왼쪽으로 다시 2로 나누고, null아니면 해당 값의 우측으로 2를 나눈다.
		
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
	 * 배열의 빈 공간을 제외한 실제 값 갯수 찾기
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
	 * @param accountNum		삭제하고자 하는 계좌번호
	 * @return					삭제여부
	 */
	public boolean remove(String accountNum) {
		
		for (int i = 0; i < count; i++) {
			if (accounts[i].getAccountNum().equals(accountNum)) {
				// 배열 크기 하나 줄이면서 이동
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
