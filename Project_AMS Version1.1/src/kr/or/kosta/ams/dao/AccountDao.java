package kr.or.kosta.ams.dao;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.Vector;

import kr.or.kosta.ams.entity.Account;
import kr.or.kosta.ams.entity.MinusAccount;
/**
 * 계좌에 대한 데이터를 파일에 읽고 쓴다.
 * @author 이대용
 *
 */
public class AccountDao {

	/** 저장 파일 경로*/
	private static final String FILE_PATH = "Accounts.dbf";
	
	/** 레코드(친구)수 저장을 위한 파일 컬럼 사이즈 고정 */
	private static final int RECORD_COUNT_LENGTH = 4;
	
	/** 레코드(계좌종류, 계좌번호, 소유주, 비밀번호, 현재잔액, 대출금액) 저장을 위한 컬럼별 사이즈 고정 */
	private static final int ACCOUNT_TYPE        = 4;        // 계좌종류(4바이트)       
	private static final int ACCOUNT_NUMBER      = 28;       // 계좌번호(28바이트)
	private static final int ACCOUNT_OWNER       = 10;       // 소유주(10바이트)
	private static final int ACCOUNT_PWD         = 4;        // 비밀번호(4바이트)
	private static final int ACCOUNT_RESTMONEY   = 8;       // 현재잔액(18바이트)
	private static final int ACCOUNT_BORROWMONEY = 8;       // 대출금액(18바이트)
	
	/** 친구정보 저장을 위한 레코드 사이즈 : 62바이트 */	
	public static final int RECORD_LENGTH = ACCOUNT_TYPE + ACCOUNT_NUMBER + ACCOUNT_OWNER + ACCOUNT_PWD
			                                 + ACCOUNT_RESTMONEY + ACCOUNT_BORROWMONEY;
	
	private RandomAccessFile file;
	
	/** 저장된 친구(레코드)수 */
	private int recordCount = 0;
	
	public AccountDao() throws IOException {
		file = new RandomAccessFile(FILE_PATH, "rw");
		
		// 저장된 파일이 있는 경우..
		if(file.length() != 0){
			recordCount = file.readInt();
		}
	}
	
	/** getter */
	public int getRecordCount() {
		return recordCount;
	}
	
	/** 
	 * Account계좌를 파일에 작성한다.
	 * @param account : 계좌
	 * @throws IOException 
	 */
	public void create(Account account) throws IOException {
		// 파일의 마지막 레코드끝으로 파일 포인터 이동.
		create(account, recordCount);
	}
	
	/** 
	 * Account계좌를 파일에 작성한다.
	 * @param account : 계좌
	 * @param index   : 파일의 읽을 위치를 가르키는 index 값
	 * @throws IOException 
	 */
	public void create(Account account, int index) throws IOException {
		
		file.seek((index * RECORD_LENGTH) + RECORD_COUNT_LENGTH);
		
		// 새로운 레코드(계좌) 추가
		int accountType = 0;
		if ("입출금".equals(account.getAccountType())) {
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
		
		// 1바이트로 계좌종류 저장
		file.writeInt(accountType);
		
		charCount = accountNum.length();
		// 28바이트로 계좌번호 저장
		for (int i=0; i<(ACCOUNT_NUMBER/2); i++) {
			file.writeChar((i<charCount ? accountNum.charAt(i) : ' '));
		}
		
		charCount = accountOwner.length();
		// 10바이트(5글자)로 소유주 저장
		for (int i=0; i<(ACCOUNT_OWNER/2); i++) {
			file.writeChar((i<charCount ? accountOwner.charAt(i) : ' '));
		}
		
		// 4바이트로 비밀번호 저장
		file.writeInt(accountPwd);
		
		// 8바이트로 현재잔액 저장
		file.writeLong(restMoney);
		
		// 8바이트로 대출금액 저장
		file.writeLong(borrowMoney);
		
		file.seek(0);
		file.writeInt(++recordCount);
	}
	
	/**
	 * 파일의 모든 데이터를 읽어들인다.
	 * @return 파일로 읽어들인 내용 List
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
	 * 특정 레코드의 정보를 Account로 반환
	 * @param index : 파일의 읽을 위치를 가르키는 index 값
	 * @return 파일로 읽어들인 Account 정보
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
		
		// 해당 레코드에 위치
		file.seek((index * RECORD_LENGTH) + RECORD_COUNT_LENGTH);

		// 계좌종류(4바이트)
		accountType = file.readInt();
		
		// 계좌번호(28바이트)
		for (int i=0; i<(ACCOUNT_NUMBER/2); i++) {
			accountNum += file.readChar();
		}
		accountNum = accountNum.trim();
		
		// 소유주(10바이트)
		for (int i=0; i<(ACCOUNT_OWNER/2); i++) {
			accountOwner += file.readChar();
		}
		accountOwner = accountOwner.trim();
		
		// 비밀번호(4바이트)
		accountPwd = file.readInt();
		
		// 현재잔액(8바이트)
		restMoney = file.readLong();
		
		// 대출금액(8바이트)
		borrowMoney = file.readLong();
		
		// 계좌종류 확인
		if (accountType == 1) {
			account = new Account(accountNum, accountOwner, accountPwd, restMoney);
		} else if (accountType == 2) {
			account = new MinusAccount(accountNum, accountOwner, accountPwd, restMoney, borrowMoney);
		}
		
		return account;
	}
	
	/**
	 * 단일 건 계좌정보 조회
	 * @param accountNum : 정보조회하고자하는 계좌번호
	 * @return 조회된 계좌
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
	 * 소유주에 해당하는 다 건의 계좌를 검색
	 * @param accountOwner : 소유주 이름
	 * @return 조회된 계좌정보 List
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
	 * 계좌번호에 해당하는 계좌정보 삭제
	 * @param accountNum : 삭제하고자하는 계좌번호
	 * @return 계좌 삭제 여부 boolean
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
	 * Stream 닫기
	 */
	public void close(){
		try{
			if(file != null) file.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
}
