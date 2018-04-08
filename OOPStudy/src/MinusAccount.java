

public class MinusAccount extends Account{
	
	private long borrowMoney;

	public MinusAccount() {this(null, null, 0, 0, 0);}

	public MinusAccount(String accountNum, String accountOwner, int passwd, long restMoney, long borrowMoney) {
		super(accountNum, accountOwner, passwd, restMoney);
		this.borrowMoney = borrowMoney;
	}

	// Getter/Setter Method
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
		return "MinusAccount [borrowMoney=" + borrowMoney + ", getAccountNum()=" + getAccountNum()
				+ ", getAccountOwner()=" + getAccountOwner() + ", getPasswd()=" + getPasswd() + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		return toString().equals(obj.toString());
	}
}
