import java.awt.BorderLayout;

public class KostaChat {
	public static void main(String[] args) {
		
		ChatFrame cf = new ChatFrame();

		// ���̾ƿ� ����
		cf.setLayout(new BorderLayout(10, 0));
		cf.setContents();
		cf.setEventRegister();
		cf.execute();

	}
}
