import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;

/**
 * AWT API�� �̿��� ������â ����
 * @author �̴��
 *
 */
public class AWTExample {
	public static void main(String[] args) {
		
		Frame frame = new Frame("ó������ �ۼ��ϴ� ������ ���α׷���");

		// ���ظ� ���� ���� Frame�� ���̾ƿ� �Ŵ��� ��ü
		// frame.setLayout(new FlowLayout());
		
		/*for (int i = 0; i < 10; i++) {
			Button button = new Button("AWT��ư");
			frame.add(button);
		}*/
		
		Button button1 = new Button("AWT��ư1");
		Button button2 = new Button("AWT��ư2");
		Button button3 = new Button("AWT��ư3");
		Button button4 = new Button("AWT��ư4");
		Button button5 = new Button("AWT��ư5");
		frame.add(button1, BorderLayout.NORTH);
		frame.add(button2, BorderLayout.WEST);
		frame.add(button3, BorderLayout.EAST);
		//frame.add(button4, BorderLayout.SOUTH);
		frame.add(button5, BorderLayout.CENTER);
		
		TextField tf = new TextField();
		Button confirmB = new Button(" Ȯ �� ");
		
		Panel panel = new Panel();
		panel.setLayout(new BorderLayout());
		panel.add(tf, BorderLayout.CENTER);
		panel.add(confirmB, BorderLayout.EAST);
		
		frame.add(panel, BorderLayout.SOUTH);
		
		frame.setSize(500, 400);
		frame.setVisible(true);
		
	}
}
