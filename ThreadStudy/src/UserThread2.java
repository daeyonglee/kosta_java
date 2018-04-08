import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.util.Random;

public class UserThread2 extends Frame implements Runnable{

	Button button;
	
	public UserThread2() {
		this("notitle");
	}
	
	public UserThread2(String title) {
		super(title);
		button = new Button("테스트버튼");
		setLayout(new FlowLayout());
		add(button);
	}
	
	@Override
	public void run() {
		//System.out.println("사용자 스레드입니다..");
		Random r;
		while(true) {
			r = new Random();
			int red = r.nextInt(256);
			int green = r.nextInt(256);
			int blue = r.nextInt(256);
			setBackground(new Color(red,green,blue));
		}
	}

}
