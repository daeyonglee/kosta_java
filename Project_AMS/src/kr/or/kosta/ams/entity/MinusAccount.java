package kr.or.kosta.ams.entity;


public class MinusAccount extends Account{
	
	private String accountType = "마이너스";
	private long borrowMoney;

	public MinusAccount() {this(null, null, 0, 0, 0);}

	public MinusAccount(String accountNum, String accountOwner, int passwd, long restMoney, long borrowMoney) {
		super(accountNum, accountOwner, passwd, restMoney);
		this.borrowMoney = borrowMoney;
	}

	// Getter/Setter Method
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public long getBorrowMoney() {
		return borrowMoney;
	}

	public void setBorrowMoney(long borrowMoney) {
		this.borrowMoney = borrowMoney;
	}
	
	@Override
	public long getRestMoney() {
		return super.getRestMoney() - getBorrowMoney();
	}
	
	@Override
	public void print() {
		System.out.println(String.format("%1$9s", getAccountNum()) + String.format("%1$8s",  getAccountOwner()) 
							+ String.format("%1$17s", getPasswd()) + String.format("%1$,13d", getRestMoney()) +  String.format("%1$,13d", this.borrowMoney));
	}
	
	@Override
	public String toString() {
		return String.format("%1$4s", accountType) + String.format("%1$27s", getAccountNum()) + String.format("%1$10s",  getAccountOwner()) 
		       + String.format("%1$,20d", getRestMoney()) +  String.format("%1$,18d", this.borrowMoney);
	}
	
	@Override
	public boolean equals(Object obj) {
		return toString().equals(obj.toString());
	}
}
