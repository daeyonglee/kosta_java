
public class InsufficientBalanceException extends Exception {
	
	private int code;
	
	public InsufficientBalanceException() {
		this("�ܾ��� �����մϴ�.", 100);
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
		return "�����ڵ�: �޽���";
	}
	
}
