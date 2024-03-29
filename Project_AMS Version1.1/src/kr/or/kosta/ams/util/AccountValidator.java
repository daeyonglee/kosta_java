package kr.or.kosta.ams.util;

public class AccountValidator extends Validator {

	/**
	 * 계좌번호 유효성 검사
	 * ex) 1111-2222-3333 : 4자리숫자-4자리숫자-4자리숫자
	 * @param text
	 * @return
	 */
	public static boolean isAccountNumValid(String text) {
		
		if (isEmpty(text) | !text.matches(ACCOUNT_NUMBER_REGEXP)) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * 예금주명(소유주) 유효성 검사
	 * ex) 총 10바이트 -> 한글의 경우 5자, 알파벳경우 10자
	 * @param text
	 * @return
	 */
	public static boolean isAccountOwnerValid(String text) {
		
		if (isEmpty(text) | !text.matches(ACCOUNT_OWNER_REGEXP)) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * 비밀번호 유효성 검사
	 * ex) 5959 -> 숫자로 4자
	 * @param text
	 * @return
	 */
	public static boolean isAccountPwdValid(String text) {
		
		if (isEmpty(text) | !text.matches(ACCOUNT_PWD_REGEXP)) {
			return true;
		}

		return false;
	}
	
	/**
	 * 입금금액 유효성 검사
	 * ex) 10000000 -> 최대 입금금액 99999999로 제한(long타입)
	 * @param text
	 * @return
	 */
	public static boolean isAccountRestMoneyValid(String text) {
		
		if (isEmpty(text) | !text.matches(ACCOUNT_RM_BM_REGEXP)) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * 대출금액 유효성 검사
	 * ex) 10000000 -> 최대 대출금액 99999999로 제한(long 타입)
	 * @param text
	 * @return
	 */
	public static boolean isAccountBorrowMoneyValid(String text) {
		
		if (isEmpty(text) | !text.matches(ACCOUNT_RM_BM_REGEXP)) {
			return true;
		}
		return false;
	}
	
	private static final String ACCOUNT_NUMBER_REGEXP = "[0-9]{4}-[0-9]{4}-[0-9]{4}";
	private static final String ACCOUNT_OWNER_REGEXP  = "[가-힣a-zA-Z]{1,5}";
	private static final String ACCOUNT_PWD_REGEXP    = "[0-9]{4}";
	private static final String ACCOUNT_RM_BM_REGEXP     = "[0-9]{1,8}";
	
}
