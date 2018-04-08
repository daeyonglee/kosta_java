
public class Account {

	private String accountNum;
	private String accountOwner;
	private int passwd;
	private long restMoney;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Account(String accountNum, String accountOwner, int passwd, long restMoney) {
		super();
		this.accountNum = accountNum;
		this.accountOwner = accountOwner;
		this.passwd = passwd;
		this.restMoney = restMoney;
	}

	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public String getAccountOwner() {
		return accountOwner;
	}
	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}
	public int getPasswd() {
		return passwd;
	}
	public void setPasswd(int passwd) {
		this.passwd = passwd;
	}
	public long getRestMoney() {
		return restMoney;
	}
	public void setRestMoney(long restMoney) {
		this.restMoney = restMoney;
	}
	
	public void print() {
		System.out.print(accountNum + "\t" + accountOwner + "\t" + passwd + "\t" + restMoney + "\n");
	}
	
	@Override
	public String toString() {
		return accountNum + "\t" + accountOwner + "\t" + passwd + "\t" + restMoney + "\t ";
	}
}
