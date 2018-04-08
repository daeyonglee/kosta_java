package kr.or.kosta.ams.util;

public class AccountValidator extends Validator {

	/**
	 * ���¹�ȣ ��ȿ�� �˻�
	 * ex) 1111-2222-3333 : 4�ڸ�����-4�ڸ�����-4�ڸ�����
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
	 * �����ָ�(������) ��ȿ�� �˻�
	 * ex) �� 10����Ʈ -> �ѱ��� ��� 5��, ���ĺ���� 10��
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
	 * ��й�ȣ ��ȿ�� �˻�
	 * ex) 5959 -> ���ڷ� 4��
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
	 * �Աݱݾ� ��ȿ�� �˻�
	 * ex) 10000000 -> �ִ� �Աݱݾ� 99999999�� ����(longŸ��)
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
	 * ����ݾ� ��ȿ�� �˻�
	 * ex) 10000000 -> �ִ� ����ݾ� 99999999�� ����(long Ÿ��)
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
	private static final String ACCOUNT_OWNER_REGEXP  = "[��-�Ra-zA-Z]{1,5}";
	private static final String ACCOUNT_PWD_REGEXP    = "[0-9]{4}";
	private static final String ACCOUNT_RM_BM_REGEXP     = "[0-9]{1,8}";
	
}
