
public class StaticExample {

	public static void main(String[] args) {
	
		Account account1 = new Account("1234-5678-9101", "이대용", 22222222, 3333);
		Account account2 = new Account("1111-2222-3333", "이대용", 10000000, 1111);
		
		account1.print();
		//System.out.println(Account.bankName);
		
		//System.out.println(Account.calculateRate());
	}
	
}
