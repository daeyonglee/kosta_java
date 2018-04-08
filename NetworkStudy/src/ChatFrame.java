import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class ChatFrame extends Frame{

	Panel chatPanel;
	List joinList;
	TextArea chatContent;
	TextField connectTxt;
	Button connectBtn;
	Button sendBtn;
	TextField sendTxt;
	
	Panel chatPanelHeader;
	Panel chatPanelCenter;
	Panel chatPanelBottom;
	
	public ChatFrame() {
		this("No-title");
	}
	
	public ChatFrame(String title) {
		super(title);
	}

	/**
	 * 컴포넌트 설정
	 */
	public void setContents() {
		chatPanel = new Panel();
		chatPanel.setLayout(new BorderLayout(0,10));
		
		joinList = new List(20);
		
		connectTxt = new TextField("대화명을 입력하세요");
		chatContent = new TextArea(20,50);
		
		connectBtn = new Button("접속");
		connectBtn.setPreferredSize(new Dimension(90, 20));
		
		sendBtn = new Button("전송");
		sendBtn.setPreferredSize(new Dimension(90, 20));
		
		sendTxt = new TextField();
		
		chatPanelHeader = new Panel();
		chatPanelCenter = new Panel();
		chatPanelBottom = new Panel();
		
		chatPanelHeader.setLayout(new BorderLayout());
		chatPanelCenter.setLayout(new BorderLayout());
		chatPanelBottom.setLayout(new BorderLayout());
		
		chatPanelHeader.add(connectTxt, BorderLayout.CENTER);
		chatPanelHeader.add(connectBtn, BorderLayout.EAST);
		
		chatPanelCenter.add(chatContent, BorderLayout.CENTER);
		chatPanelCenter.add(joinList, BorderLayout.EAST);
		
		chatPanelBottom.add(sendTxt, BorderLayout.CENTER);
		chatPanelBottom.add(sendBtn, BorderLayout.EAST);
		
		chatPanel.add(chatPanelHeader, BorderLayout.NORTH);
		chatPanel.add(chatPanelCenter, BorderLayout.CENTER);
		chatPanel.add(chatPanelBottom, BorderLayout.SOUTH);
	}

	/**
	 * Component에 다른 Component를 붙이고, Layout을 설정한다.
	 * @param comp  -> 붙여질 Component
	 * @param comp2 -> 붙일 Component
	 * @param constraints -> Layout 배치방법
	 */
	public void add(Component comp, Component comp2, Object constraints) {
		if (comp instanceof Panel) {
			Panel panel = (Panel) comp;
			panel.add(comp2, constraints);
		}
		
		
	}
	
	/**
	 * 각종 컴포넌트 결합
	 */
	public void execute() {
		add(chatPanel, BorderLayout.CENTER);
		setSize(500, 500);
		setVisible(true);
	}
	
	public void exit() {
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	/**
	 * 이벤트 처리 메소드
	 */
	public void setEventRegister() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		
		sendTxt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = sendTxt.getText();
				chatContent.append(msg + "\n");
			}
		});
	}

}
