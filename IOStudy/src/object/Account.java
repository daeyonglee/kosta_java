package object;

import java.io.Serializable;

public class Account implements Serializable{

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
	
	// 인스턴스 메소드
	public long deposit(long money) {
		return restMoney += money;
	}
	
	public long withdraw(long money){
		if (money < restMoney) {
		}
		return restMoney -= money;
	}
	
	public boolean checkPasswd(int pw) {
		return passwd == pw;
	}
	
	public void print() {
		System.out.print(String.format("%1$9s", accountNum) + String.format("%1$8s", accountOwner) + String.format("%1$17s", passwd) + String.format("%1$,13d", restMoney) + "\n");
	}
	
	@Override
	public String toString() {
		return accountNum + "\t" + accountOwner + "\t" + passwd + "\t" + restMoney + "\t ";
	}
	
	@Override
	public boolean equals(Object obj) {
		return toString().equals(obj.toString());
	}
}
