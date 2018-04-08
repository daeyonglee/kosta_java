import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;

/**
 * AWT API를 이용한 윈도우창 띄우기
 * @author 이대용
 *
 */
public class AWTExample {
	public static void main(String[] args) {
		
		Frame frame = new Frame("처음으로 작성하는 윈도우 프로그래밍");

		// 이해를 돕기 위해 Frame의 레이아웃 매니저 교체
		// frame.setLayout(new FlowLayout());
		
		/*for (int i = 0; i < 10; i++) {
			Button button = new Button("AWT버튼");
			frame.add(button);
		}*/
		
		Button button1 = new Button("AWT버튼1");
		Button button2 = new Button("AWT버튼2");
		Button button3 = new Button("AWT버튼3");
		Button button4 = new Button("AWT버튼4");
		Button button5 = new Button("AWT버튼5");
		frame.add(button1, BorderLayout.NORTH);
		frame.add(button2, BorderLayout.WEST);
		frame.add(button3, BorderLayout.EAST);
		//frame.add(button4, BorderLayout.SOUTH);
		frame.add(button5, BorderLayout.CENTER);
		
		TextField tf = new TextField();
		Button confirmB = new Button(" 확 인 ");
		
		Panel panel = new Panel();
		panel.setLayout(new BorderLayout());
		panel.add(tf, BorderLayout.CENTER);
		panel.add(confirmB, BorderLayout.EAST);
		
		frame.add(panel, BorderLayout.SOUTH);
		
		frame.setSize(500, 400);
		frame.setVisible(true);
		
	}
}
