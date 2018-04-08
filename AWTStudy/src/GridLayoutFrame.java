import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.TextArea;
/**
 * Frame을 확장하여 사용자 정의 Frame 만들기
 * @author 이대용
 *
 */
public class GridLayoutFrame extends Frame {
	
	public GridLayoutFrame() {
		this("No-Title");
	}
	
	public GridLayoutFrame(String title) {
		super(title);
	}
	
	public void setContents() {
		setLayout(new GridLayout(8,8));
		
		for (int i = 0; i < 64; i++) {
			Button button = new Button(i + "버튼");
			add(button);
		}
	}
	
	public static void main(String[] args) {
		GridLayoutFrame frame = new GridLayoutFrame("확장개념을 이용한 화면 구성");
		frame.setContents();
//		frame.setSize(800,500);
		frame.setSize(new Dimension(800, 800));
		frame.setVisible(true);
	}
}
