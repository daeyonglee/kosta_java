
public class AMS2 {
	public static void main(String[] args) {
		Account account = new Account("1111-2222", "ÀÌ´ë¿ë", 11111, 1000);
		try {
			account.withdraw(10000);
		} catch (InsufficientBalanceException e) {
			e.printStackTrace();
		}
	}
}
