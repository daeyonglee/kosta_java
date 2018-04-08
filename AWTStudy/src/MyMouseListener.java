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
		frame.ta.append("버튼이 클릭되었습니다.\n");
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("버튼 영역으로 들어왔습니다.");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("버튼 영역에서 나갔습니다.");
	}

}
