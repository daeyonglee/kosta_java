
public class InsufficientBalanceException extends Exception {
	
	private int code;
	
	public InsufficientBalanceException() {
		this("잔액이 부족합니다.", 100);
	}
	
	public InsufficientBalanceException(String msg, int code) {
		super(msg);
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "에러코드: 메시지";
	}
	
}
