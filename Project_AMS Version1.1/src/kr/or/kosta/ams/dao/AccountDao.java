package kr.or.kosta.ams.dao;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.Vector;

import kr.or.kosta.ams.entity.Account;
import kr.or.kosta.ams.entity.MinusAccount;
/**
 * ���¿� ���� �����͸� ���Ͽ� �а� ����.
 * @author �̴��
 *
 */
public class AccountDao {

	/** ���� ���� ���*/
	private static final String FILE_PATH = "Accounts.dbf";
	
	/** ���ڵ�(ģ��)�� ������ ���� ���� �÷� ������ ���� */
	private static final int RECORD_COUNT_LENGTH = 4;
	
	/** ���ڵ�(��������, ���¹�ȣ, ������, ��й�ȣ, �����ܾ�, ����ݾ�) ������ ���� �÷��� ������ ���� */
	private static final int ACCOUNT_TYPE        = 4;        // ��������(4����Ʈ)       
	private static final int ACCOUNT_NUMBER      = 28;       // ���¹�ȣ(28����Ʈ)
	private static final int ACCOUNT_OWNER       = 10;       // ������(10����Ʈ)
	private static final int ACCOUNT_PWD         = 4;        // ��й�ȣ(4����Ʈ)
	private static final int ACCOUNT_RESTMONEY   = 8;       // �����ܾ�(18����Ʈ)
	private static final int ACCOUNT_BORROWMONEY = 8;       // ����ݾ�(18����Ʈ)
	
	/** ģ������ ������ ���� ���ڵ� ������ : 62����Ʈ */	
	public static final int RECORD_LENGTH = ACCOUNT_TYPE + ACCOUNT_NUMBER + ACCOUNT_OWNER + ACCOUNT_PWD
			                                 + ACCOUNT_RESTMONEY + ACCOUNT_BORROWMONEY;
	
	private RandomAccessFile file;
	
	/** ����� ģ��(���ڵ�)�� */
	private int recordCount = 0;
	
	public AccountDao() throws IOException {
		file = new RandomAccessFile(FILE_PATH, "rw");
		
		// ����� ������ �ִ� ���..
		if(file.length() != 0){
			recordCount = file.readInt();
		}
	}
	
	/** getter */
	public int getRecordCount() {
		return recordCount;
	}
	
	/** 
	 * Account���¸� ���Ͽ� �ۼ��Ѵ�.
	 * @param account : ����
	 * @throws IOException 
	 */
	public void create(Account account) throws IOException {
		// ������ ������ ���ڵ峡���� ���� ������ �̵�.
		create(account, recordCount);
	}
	
	/** 
	 * Account���¸� ���Ͽ� �ۼ��Ѵ�.
	 * @param account : ����
	 * @param index   : ������ ���� ��ġ�� ����Ű�� index ��
	 * @throws IOException 
	 */
	public void create(Account account, int index) throws IOException {
		
		file.seek((index * RECORD_LENGTH) + RECORD_COUNT_LENGTH);
		
		// ���ο� ���ڵ�(����) �߰�
		int accountType = 0;
		if ("�����".equals(account.getAccountType())) {
			accountType = 1;
		} else {
			accountType = 2;
		}
		
		String accountNum   = account.getAccountNum();
		String accountOwner = account.getAccountOwner();
		int accountPwd      = account.getPasswd();
		long restMoney      = account.getRestMoney();
		long borrowMoney    = 0;
		int charCount       = 0;
		
		MinusAccount minusAccount;
		if (account instanceof MinusAccount) {
			minusAccount = (MinusAccount)account;
			borrowMoney = minusAccount.getBorrowMoney();
		}
		
		// 1����Ʈ�� �������� ����
		file.writeInt(accountType);
		
		charCount = accountNum.length();
		// 28����Ʈ�� ���¹�ȣ ����
		for (int i=0; i<(ACCOUNT_NUMBER/2); i++) {
			file.writeChar((i<charCount ? accountNum.charAt(i) : ' '));
		}
		
		charCount = accountOwner.length();
		// 10����Ʈ(5����)�� ������ ����
		for (int i=0; i<(ACCOUNT_OWNER/2); i++) {
			file.writeChar((i<charCount ? accountOwner.charAt(i) : ' '));
		}
		
		// 4����Ʈ�� ��й�ȣ ����
		file.writeInt(accountPwd);
		
		// 8����Ʈ�� �����ܾ� ����
		file.writeLong(restMoney);
		
		// 8����Ʈ�� ����ݾ� ����
		file.writeLong(borrowMoney);
		
		file.seek(0);
		file.writeInt(++recordCount);
	}
	
	/**
	 * ������ ��� �����͸� �о���δ�.
	 * @return ���Ϸ� �о���� ���� List
	 * @throws IOException
	 */
	public Vector<Account> listAll() throws IOException{
		Vector<Account> list = new Vector<Account>();
		for(int i=0; i<recordCount; i++){
			Account account = read(i);
			list.addElement(account);		
		}
		return list;
	}

	/**
	 * Ư�� ���ڵ��� ������ Account�� ��ȯ
	 * @param index : ������ ���� ��ġ�� ����Ű�� index ��
	 * @return ���Ϸ� �о���� Account ����
	 * @throws IOException
	 */
	private Account read(int index) throws IOException{
		Account account = null;
		
		int accountType     = 0;
		String accountNum   = "";
		String accountOwner = "";
		int accountPwd      = 0;
		long restMoney      = 0;
		long borrowMoney    = 0;
		
		// �ش� ���ڵ忡 ��ġ
		file.seek((index * RECORD_LENGTH) + RECORD_COUNT_LENGTH);

		// ��������(4����Ʈ)
		accountType = file.readInt();
		
		// ���¹�ȣ(28����Ʈ)
		for (int i=0; i<(ACCOUNT_NUMBER/2); i++) {
			accountNum += file.readChar();
		}
		accountNum = accountNum.trim();
		
		// ������(10����Ʈ)
		for (int i=0; i<(ACCOUNT_OWNER/2); i++) {
			accountOwner += file.readChar();
		}
		accountOwner = accountOwner.trim();
		
		// ��й�ȣ(4����Ʈ)
		accountPwd = file.readInt();
		
		// �����ܾ�(8����Ʈ)
		restMoney = file.readLong();
		
		// ����ݾ�(8����Ʈ)
		borrowMoney = file.readLong();
		
		// �������� Ȯ��
		if (accountType == 1) {
			account = new Account(accountNum, accountOwner, accountPwd, restMoney);
		} else if (accountType == 2) {
			account = new MinusAccount(accountNum, accountOwner, accountPwd, restMoney, borrowMoney);
		}
		
		return account;
	}
	
	/**
	 * ���� �� �������� ��ȸ
	 * @param accountNum : ������ȸ�ϰ����ϴ� ���¹�ȣ
	 * @return ��ȸ�� ����
	 * @throws IOException
	 */
	public Account get(String accountNum) throws IOException {
		
		for(int i=0; i<recordCount; i++){
			Account account = read(i);
			if (accountNum.equals(account.getAccountNum())) {
				return account;
			}
		}
		
		return null;
	}
	
	/**
	 * �����ֿ� �ش��ϴ� �� ���� ���¸� �˻�
	 * @param accountOwner : ������ �̸�
	 * @return ��ȸ�� �������� List
	 * @throws IOException
	 */
	public Vector<Account> search(String accountOwner) throws IOException {
		
		Vector<Account> list = new Vector<Account>();
		
		for(int i=0; i<recordCount; i++){
			Account account = read(i);
			if (accountOwner.equals(account.getAccountOwner())) {
				list.addElement(account);
			}
		}
		
		return list;
	}
	
	/**
	 * ���¹�ȣ�� �ش��ϴ� �������� ����
	 * @param accountNum : �����ϰ����ϴ� ���¹�ȣ
	 * @return ���� ���� ���� boolean
	 * @throws IOException
	 */
	public boolean remove(String accountNum) throws IOException {
		
		int removeIndex = -1;
		
		for(int i=0; i<recordCount; i++){
			Account account = read(i);
			if (accountNum.equals(account.getAccountNum())) {
				removeIndex = i;
				break;
			}
		}
		
		if (removeIndex != -1) {
			for (int j=removeIndex; j<recordCount; j++) {
				--recordCount;
				
				if ((j+1) != recordCount) {
					Account account = read(j+1);
					--recordCount;
					create(account, removeIndex);
				} 
			}
			return true;
		}

		return false;
	}
	
	/**
	 * Stream �ݱ�
	 */
	public void close(){
		try{
			if(file != null) file.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
}
