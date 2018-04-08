package kr.or.kosta.chat.boundary;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.List;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;

import kr.or.kosta.chat.client.ChatClient;
import kr.or.kosta.chat.util.MessageType;

@SuppressWarnings("serial")
public class ChatFrame extends Frame {
	
	private static ChatFrame instance;
	
	private Panel header;
	private Panel center;
	private Panel footer;
	
	private GridBagLayout gridBagLayout;
	private GridBagConstraints bagConstraints;
	
	private TextField connTf;					// 대화명 TextField
	private Button connBtn;						// 접속 Button
	
	private TextArea chatTa;					// 대화내용 TextArea
	private List connList;						// 접속자명단 List
	private PopupMenu connListPopup;			// 접속자팝업메뉴 PopupMenu 
	private MenuItem fileItem;					// 파일전송을 위한 MenuItem
	private FileDialog dialog;					// 파일전송을 위한 FileDialog

	private Choice sendType;					// 메시지 전송 대상 Choice 
	private TextField sendTf;					// 메시지 전송 TextField
	private Button sendBtn;						// 메시지 전송 Button
	
	private ChatClient chatClient;
	
	public static ChatFrame getInstance() {
		if (instance == null) instance = new ChatFrame();
		return instance;
	}
	
	public ChatFrame() {
		
	}
	
	public ChatClient getChatClient() {
		return chatClient;
	}

	public void init() {
		header = new Panel();
		center = new Panel();
		footer = new Panel();
		
		connTf = new TextField("대화명을 입력하세요.");
		connBtn = new Button("접속하기");
		
		chatTa        = new TextArea(20, 50);
		connList      = new List(50, false);
		connListPopup = new PopupMenu("File");
		fileItem      = new MenuItem("파일전송");
		dialog        = new FileDialog(this, "파일전송", FileDialog.LOAD);
		
		chatTa.setEditable(false);
		connListPopup.add(fileItem);
		
		sendType = new Choice();
		sendTf   = new TextField();
		sendBtn  = new Button("보내기");
		
		/******************************************************/
		//Test용
		sendType.add("모두에게");
		
		/*****************************************************/
		
		gridBagLayout  = new GridBagLayout();
		bagConstraints = new GridBagConstraints();
		
		setting(0);
	}

	/**
	 * 화면 관련 설정
	 * @param flag : 0 => 접속하기전 설정
	 * 			   : 1 => 접속 후 설정
	 */
	public void setting(int flag) {
		
		if (flag == 0) {
			sendType.setEnabled(false);
			sendTf.setEnabled(false);
			sendBtn.setEnabled(false);
		} else if (flag == 1) {
			
			// 상단 disable
			connTf.setEnabled(false);
			connBtn.setEnabled(false);
			
			// 하단 enable
			sendType.setEnabled(true);
			sendTf.setEnabled(true);
			sendBtn.setEnabled(true);
		}
		
	}
	
	public void setEventRegist() {
		setHeaderEventRegist();
		setCenterEventRegist();
		setFooterEventRegist();
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
	}
	
	/**
	 * 전체화면 상단부분 Event 등록
	 */
	private void setHeaderEventRegist() {
		// 접속하기 버튼 Event
		connBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chatClient = new ChatClient(connTf.getText());
				connection();
			}
		});
	}
	
	private void connection() {
		// 서버에 접속
		try {
			chatClient.connect();
			chatClient.messageListening();
			chatClient.messageSend(MessageType.SC_CONNECT_LIST+MessageType.DELEMITER+MessageType.SERVER);
			chatClient.messageSend(MessageType.CC_CONNECT+MessageType.DELEMITER+chatClient.getNickName());
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * 전체화면 중앙부분 Event 등록
	 */
	private void setCenterEventRegist() {
		
		// 파일전송을 위한 팝업메뉴 생성
		fileItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// protocol + 보내는사람 + 받는사람 + 파일위치 + 파일명 + 파일전송허가여부
				dialog.setVisible(true);
				chatClient.messageSend(MessageType.CC_FILE_YN+MessageType.DELEMITER+connTf.getText()+MessageType.DELEMITER+connList.getSelectedItem()+MessageType.DELEMITER+dialog.getDirectory()+MessageType.DELEMITER+dialog.getFile());
				dialog.setVisible(false);
				dialog.dispose();
			}
		});
		
		// 접속자 클릭 시 파일전송 팝업메뉴 show
		connList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				connListPopup.show(connList, e.getX(), e.getY());
			}
		});
	}
	
	/**
	 * 전체화면 하단부분 Event 등록
	 */
	private void setFooterEventRegist() {
		// 보내기 버튼 Event
		sendBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				send();
			}
		});
		
		sendTf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				send();
			}
		});
	}

	// 채팅 메시지 전송
	private void send() {
		if (!"".equals(sendTf.getText())) {
			
			if (sendType.getSelectedIndex() == 0) {
				chatClient.messageSend(MessageType.CC_MULTI_MESSAGE+MessageType.DELEMITER+connTf.getText()+MessageType.DELEMITER+sendTf.getText());
				sendTf.setText("");
			} else {
				// protocol + 보내는사람 + 받는사람 + 보내는 내용
				chatClient.messageSend(MessageType.CC_SINGLE_MESSAGE+MessageType.DELEMITER+connTf.getText()+MessageType.DELEMITER+sendType.getSelectedItem()+MessageType.DELEMITER+sendTf.getText());
			}
		}
	}
	
	/**
	 * List 및 Choice 컴포넌트에 접속자 추가 및 삭제
	 * @param nickName	=> 추가하고자하는 접속자 닉네임
	 * @param flag		=> 0 : 최초 접속이므로 명단에 추가
	 * 					   1 : 기존 명단 추가이므로 명단 삭제 후 추가
	 */
	public void writeList(String nickName, int flag) {
		
		if (flag == 0) {
			connList.add(nickName);
			sendType.add(nickName);
		}
		
		if (flag == 1) {
			connList.removeAll();
			sendType.removeAll();
			sendType.add("모두에게");
			String[] s = nickName.split(",");
			for (int i = 0; i < s.length; i++) {
				connList.add(s[i]);
				sendType.add(s[i]);
			} 
		}
	}
	
	/**
	 * 채팅창에 메시지를 출력
	 * @param message => 출력할 메시지
	 */
	public void writeMessage(String message) {
		chatTa.append(message);
	}
	
	/**
	 * FileFrame을 생성한다
	 * @param serverMessage => 서버에서 보내온 메시지.
	 */
	public void executeFileFrame(String serverMessage) {
		// ServerMessage 구조 : protocol,보내는사람 ,받는사람 ,파일위치 ,파일명
		
		String[] tokens = serverMessage.split(MessageType.DELEMITER);
		
		File file = new File(tokens[3] + tokens[4]);
		// 새창 띄운다.
		FileFrame fileFrame = new FileFrame(tokens[1], tokens[2], tokens[3], tokens[4], file.length(), serverMessage, chatClient);
		fileFrame.init();
		fileFrame.setLocation(500, 0);
		fileFrame.setSize(400,100);
		fileFrame.setVisible(true);
	}
	
	public void setContents() {
		setLayout(new BorderLayout());
		// 컴포넌트 간격 조정
		bagConstraints.insets = new Insets(5, 5, 5, 5);
		
		setHeader();
		setCenter();
		setFooter();
		
		add(header, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		add(footer, BorderLayout.SOUTH);
		
	}
	
	private void setHeader() {
		header.setLayout(gridBagLayout);
		header.setBackground(new Color(234, 234, 234));
		
		add(header, connTf , 0 , 0, 80, 10, 0.8, 0.1, GridBagConstraints.BOTH);
		add(header, connBtn, 80, 0, 20, 10, 0.2, 0.1, GridBagConstraints.BOTH);
	}
	
	private void setCenter() {
		center.setLayout(gridBagLayout);
		center.setBackground(new Color(181, 178, 255));
		
		center.add(connListPopup);
		
		add(center, chatTa  , 0 , 10, 80, 80, 0.8, 0.6, GridBagConstraints.BOTH);
		add(center, connList, 80, 10, 20, 80, 0.2, 0.6, GridBagConstraints.BOTH);
	}
	
	private void setFooter() {
		footer.setLayout(gridBagLayout);
		footer.setBackground(new Color(234, 234, 234));
		bagConstraints.insets = new Insets(2, 2, 10, 2);
		
		add(footer, sendType, 0 , 90, 20, 10, 0.2, 0.3, GridBagConstraints.BOTH);
		bagConstraints.insets = new Insets(2, 2, 2, 2);
		add(footer, sendTf  , 20, 90, 60, 10, 0.6, 0.3, GridBagConstraints.BOTH);
		add(footer, sendBtn , 80, 90, 20, 10, 0.2, 0.3, GridBagConstraints.BOTH);
	}
	
	/**
	 * Container에 GridBagLayout 형태로 요소들을 추가
	 * @param container
	 * @param com
	 * @param gridx
	 * @param gridy
	 * @param gridwidth
	 * @param gridheight
	 * @param weightx
	 * @param weighty
	 * @param fill
	 */
	private void add(Container container, Component com, int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty, int fill) {
		
		bagConstraints.gridx = gridx;
		bagConstraints.gridy = gridy;
		bagConstraints.gridwidth = gridwidth;
		bagConstraints.gridheight = gridheight;
		bagConstraints.weightx = weightx;
		bagConstraints.weighty = weighty;
		
		bagConstraints.fill = fill;
		
		gridBagLayout.setConstraints(com, bagConstraints);
		container.add(com, bagConstraints);
	}
	
	private void exit() {
		setVisible(false);
		dispose();
		try {
			// 채팅방 퇴장한다고 메시지 전송
			String message = MessageType.CC_DISCONNECT + MessageType.DELEMITER + connTf.getText();
			chatClient.messageSend(message);
			chatClient.disConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
