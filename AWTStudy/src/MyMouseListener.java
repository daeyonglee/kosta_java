import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener {

	UserFrame frame;
	
	public MyMouseListener() {
		this(null);
	}
	
	public MyMouseListener(UserFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		frame.ta.append("��ư�� Ŭ���Ǿ����ϴ�.\n");
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("��ư �������� ���Խ��ϴ�.");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("��ư �������� �������ϴ�.");
	}

}
