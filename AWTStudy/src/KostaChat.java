import java.awt.BorderLayout;

public class KostaChat {
	public static void main(String[] args) {
		
		ChatFrame cf = new ChatFrame();

		// 레이아웃 구성
		cf.setLayout(new BorderLayout(10, 0));
		cf.setContents();
		cf.setEventRegister();
		cf.execute();

	}
}
