import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.TextArea;
/**
 * Frame을 확장하여 사용자 정의 Frame 만들기
 * @author 이대용
 *
 */
public class GridBagLayoutFrame extends Frame {
	
	Button button1, button2, button3, button4, button5;
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	public GridBagLayoutFrame() {
		this("No-Title");
	}
	
	public GridBagLayoutFrame(String title) {
		super(title);
		button1 = new Button("버튼1");
		button2 = new Button("버튼2");
		button3 = new Button("버튼3");
		button4 = new Button("버튼4");
		button5 = new Button("버튼5");
		
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
	}
	
	public void setContents() {
		setLayout(gridBagLayout);
		
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
//		gridBagConstraints.weightx = 0.1;
//		gridBagConstraints.weighty = 0.1;
		
		gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
		
		gridBagLayout.setConstraints(button1, gridBagConstraints);
		add(button1, gridBagConstraints);
		
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
//		gridBagConstraints.fill = GridBagConstraints.NONE;
//		gridBagConstraints.weightx = 0.1;
//		gridBagConstraints.weighty = 0.1;
		
		gridBagLayout.setConstraints(button2, gridBagConstraints);
		add(button2, gridBagConstraints);

		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.gridheight = 1;
		
		gridBagLayout.setConstraints(button3, gridBagConstraints);
		add(button3, gridBagConstraints);
		
		add(button4, 2, 0, 1, 2, 0, 0);
		add(button5, 0, 3, 3, 1, 0, 0);
	}
	
	private void add(Component com, int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty) {
		
		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		gridBagConstraints.gridwidth = gridwidth;
		gridBagConstraints.gridheight = gridheight;
		gridBagConstraints.weightx = weightx;
		gridBagConstraints.weighty = weighty;
		
		gridBagLayout.setConstraints(com, gridBagConstraints);
		add(com, gridBagConstraints);
	}
	
	public static void main(String[] args) {
		GridBagLayoutFrame frame = new GridBagLayoutFrame("확장개념을 이용한 화면 구성");
		frame.setContents();
//		frame.setSize(800,500);
		frame.setSize(new Dimension(800, 800));
		frame.setVisible(true);
	}
}
