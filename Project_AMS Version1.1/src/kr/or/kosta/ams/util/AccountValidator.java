package kr.or.kosta.ams.util;

public class AccountValidator extends Validator {

	/**
	 * ∞Ë¡¬π¯»£ ¿Ø»øº∫ ∞ÀªÁ
	 * ex) 1111-2222-3333 : 4¿⁄∏Æº˝¿⁄-4¿⁄∏Æº˝¿⁄-4¿⁄∏Æº˝¿⁄
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
	 * øπ±›¡÷∏Ì(º“¿Ø¡÷) ¿Ø»øº∫ ∞ÀªÁ
	 * ex) √— 10πŸ¿Ã∆Æ -> «—±€¿« ∞ÊøÏ 5¿⁄, æÀ∆ƒ∫™∞ÊøÏ 10¿⁄
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
	 * ∫Òπ–π¯»£ ¿Ø»øº∫ ∞ÀªÁ
	 * ex) 5959 -> º˝¿⁄∑Œ 4¿⁄
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
	 * ¿‘±›±›æ◊ ¿Ø»øº∫ ∞ÀªÁ
	 * ex) 10000000 -> √÷¥Î ¿‘±›±›æ◊ 99999999∑Œ ¡¶«—(long≈∏¿‘)
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
	 * ¥Î√‚±›æ◊ ¿Ø»øº∫ ∞ÀªÁ
	 * ex) 10000000 -> √÷¥Î ¥Î√‚±›æ◊ 99999999∑Œ ¡¶«—(long ≈∏¿‘)
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
	private static final String ACCOUNT_OWNER_REGEXP  = "[∞°-∆Ra-zA-Z]{1,5}";
	private static final String ACCOUNT_PWD_REGEXP    = "[0-9]{4}";
	private static final String ACCOUNT_RM_BM_REGEXP     = "[0-9]{1,8}";
	
}
