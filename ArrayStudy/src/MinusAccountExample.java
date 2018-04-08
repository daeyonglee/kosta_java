
public class MinusAccountExample {
	public static void main(String[] args) {
		
		MinusAccount ma = new MinusAccount();
		
		ma.setAccountNum("1111-2222-3333");
		ma.setAccountOwner("°í±æµ¿");
		ma.setPasswd(1111);
		ma.setRestMoney(10000);
		ma.setBorrowMoney(100000000);
		
		ma.print();
		
		System.out.println(ma.getRestMoney());
		
	}
}
