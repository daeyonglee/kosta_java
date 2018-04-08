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
 * Frame�� Ȯ���Ͽ� ����� ���� Frame �����
 * @author �̴��
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
			Button button = new Button(i + "��ư");
			add(button);
		}
	}
	
	public static void main(String[] args) {
		GridLayoutFrame frame = new GridLayoutFrame("Ȯ�尳���� �̿��� ȭ�� ����");
		frame.setContents();
//		frame.setSize(800,500);
		frame.setSize(new Dimension(800, 800));
		frame.setVisible(true);
	}
}
