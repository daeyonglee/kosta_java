import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
/**
 * Frame을 확장하여 사용자 정의 Frame 만들기
 * @author 이대용
 *
 */
public class UserFrame extends Frame implements MouseListener, FocusListener, ItemListener, ActionListener {
	Button button;
	Button button2;
	Label label;
	Checkbox mcb, fcb;
	TextArea ta;
	Choice choice;
	List list;
	
	public UserFrame() {
		this("No-Title");
	}
	
	public UserFrame(String title) {
		super(title);
		this.button = new Button("버튼");
		this.button2 = new Button("버튼2");
		button.setName("btn");
		this.label = new Label("라벨");
		CheckboxGroup cg = new CheckboxGroup();
		this.mcb = new Checkbox("남자", cg, false);
		this.fcb = new Checkbox("여자", cg, true);
		this.ta = new TextArea("요넘이 텍스트에어리어",10, 50);
		this.choice = new Choice();
		choice.add("C");
		choice.add("C++");
		choice.add("C#");
		choice.add("JAVA");
		this.list = new List(10, true);
		list.add("기아 베이즈");
		list.add("두산 타이거즈");
		list.add("삼성 이글즈");
		list.add("한화 라이온즈");
	}
	
	/**
	 * 이벤트소스에 이벤트리스너 등록
	 */
	public void setEventRegist() {
//		button.addMouseListener(this);
		button.addActionListener(this);
		button2.addActionListener(this);
		ta.addFocusListener(this);
		choice.addItemListener(this);
		list.addItemListener(new ItemEventListener());
		this.addWindowListener(new Exiter());
	}
	public void setContents() {
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		add(button);
		add(button2);
		add(label);
		add(mcb);
		add(fcb);
		add(ta);
		add(choice);
		add(list);
	}
	
	public void exit() {
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e);
		ta.append("버튼이 클릭되었습니다.\n");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusGained(FocusEvent e) {
		ta.setText("");
	}

	@Override
	public void focusLost(FocusEvent e) {
	}
	

	@Override
	public void itemStateChanged(ItemEvent e) {
		System.out.println(choice.getSelectedItem() +"이(가) 선택되었습니다.");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
		System.out.println(((Button)e.getSource()).getLabel()+"이(가) 선택되었습니다.");
	}
	
	public static void main(String[] args) {
		UserFrame frame = new UserFrame("확장개념을 이용한 화면 구성");
		frame.setContents();
//		frame.setSize(800,500);
		frame.setSize(new Dimension(800, 500));
		frame.setVisible(true);
		
		// 이벤트소스에 이벤트리스너 등록
		frame.setEventRegist();
	}
	
	// 멤버내부클래스를 이용한 이벤트
	public class ItemEventListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			int[] arrItem = list.getSelectedIndexes();
			
			for (int i : arrItem) {
				System.out.println(i + "행 선택");
			}
		}
	}
	
	public class Exiter extends WindowAdapter /*implements WindowListener*/ {
		@Override
		public void windowClosing(WindowEvent e) {
			exit();
		}
	}
}
