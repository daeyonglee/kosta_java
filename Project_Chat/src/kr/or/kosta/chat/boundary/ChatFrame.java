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
	
	private TextField connTf;					// ��ȭ�� TextField
	private Button connBtn;						// ���� Button
	
	private TextArea chatTa;					// ��ȭ���� TextArea
	private List connList;						// �����ڸ�� List
	private PopupMenu connListPopup;			// �������˾��޴� PopupMenu 
	private MenuItem fileItem;					// ���������� ���� MenuItem
	private FileDialog dialog;					// ���������� ���� FileDialog

	private Choice sendType;					// �޽��� ���� ��� Choice 
	private TextField sendTf;					// �޽��� ���� TextField
	private Button sendBtn;						// �޽��� ���� Button
	
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
		
		connTf = new TextField("��ȭ���� �Է��ϼ���.");
		connBtn = new Button("�����ϱ�");
		
		chatTa        = new TextArea(20, 50);
		connList      = new List(50, false);
		connListPopup = new PopupMenu("File");
		fileItem      = new MenuItem("��������");
		dialog        = new FileDialog(this, "��������", FileDialog.LOAD);
		
		chatTa.setEditable(false);
		connListPopup.add(fileItem);
		
		sendType = new Choice();
		sendTf   = new TextField();
		sendBtn  = new Button("������");
		
		/******************************************************/
		//Test��
		sendType.add("��ο���");
		
		/*****************************************************/
		
		gridBagLayout  = new GridBagLayout();
		bagConstraints = new GridBagConstraints();
		
		setting(0);
	}

	/**
	 * ȭ�� ���� ����
	 * @param flag : 0 => �����ϱ��� ����
	 * 			   : 1 => ���� �� ����
	 */
	public void setting(int flag) {
		
		if (flag == 0) {
			sendType.setEnabled(false);
			sendTf.setEnabled(false);
			sendBtn.setEnabled(false);
		} else if (flag == 1) {
			
			// ��� disable
			connTf.setEnabled(false);
			connBtn.setEnabled(false);
			
			// �ϴ� enable
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
	 * ��üȭ�� ��ܺκ� Event ���
	 */
	private void setHeaderEventRegist() {
		// �����ϱ� ��ư Event
		connBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chatClient = new ChatClient(connTf.getText());
				connection();
			}
		});
	}
	
	private void connection() {
		// ������ ����
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
	 * ��üȭ�� �߾Ӻκ� Event ���
	 */
	private void setCenterEventRegist() {
		
		// ���������� ���� �˾��޴� ����
		fileItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// protocol + �����»�� + �޴»�� + ������ġ + ���ϸ� + ���������㰡����
				dialog.setVisible(true);
				chatClient.messageSend(MessageType.CC_FILE_YN+MessageType.DELEMITER+connTf.getText()+MessageType.DELEMITER+connList.getSelectedItem()+MessageType.DELEMITER+dialog.getDirectory()+MessageType.DELEMITER+dialog.getFile());
				dialog.setVisible(false);
				dialog.dispose();
			}
		});
		
		// ������ Ŭ�� �� �������� �˾��޴� show
		connList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				connListPopup.show(connList, e.getX(), e.getY());
			}
		});
	}
	
	/**
	 * ��üȭ�� �ϴܺκ� Event ���
	 */
	private void setFooterEventRegist() {
		// ������ ��ư Event
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

	// ä�� �޽��� ����
	private void send() {
		if (!"".equals(sendTf.getText())) {
			
			if (sendType.getSelectedIndex() == 0) {
				chatClient.messageSend(MessageType.CC_MULTI_MESSAGE+MessageType.DELEMITER+connTf.getText()+MessageType.DELEMITER+sendTf.getText());
				sendTf.setText("");
			} else {
				// protocol + �����»�� + �޴»�� + ������ ����
				chatClient.messageSend(MessageType.CC_SINGLE_MESSAGE+MessageType.DELEMITER+connTf.getText()+MessageType.DELEMITER+sendType.getSelectedItem()+MessageType.DELEMITER+sendTf.getText());
			}
		}
	}
	
	/**
	 * List �� Choice ������Ʈ�� ������ �߰� �� ����
	 * @param nickName	=> �߰��ϰ����ϴ� ������ �г���
	 * @param flag		=> 0 : ���� �����̹Ƿ� ��ܿ� �߰�
	 * 					   1 : ���� ��� �߰��̹Ƿ� ��� ���� �� �߰�
	 */
	public void writeList(String nickName, int flag) {
		
		if (flag == 0) {
			connList.add(nickName);
			sendType.add(nickName);
		}
		
		if (flag == 1) {
			connList.removeAll();
			sendType.removeAll();
			sendType.add("��ο���");
			String[] s = nickName.split(",");
			for (int i = 0; i < s.length; i++) {
				connList.add(s[i]);
				sendType.add(s[i]);
			} 
		}
	}
	
	/**
	 * ä��â�� �޽����� ���
	 * @param message => ����� �޽���
	 */
	public void writeMessage(String message) {
		chatTa.append(message);
	}
	
	/**
	 * FileFrame�� �����Ѵ�
	 * @param serverMessage => �������� ������ �޽���.
	 */
	public void executeFileFrame(String serverMessage) {
		// ServerMessage ���� : protocol,�����»�� ,�޴»�� ,������ġ ,���ϸ�
		
		String[] tokens = serverMessage.split(MessageType.DELEMITER);
		
		File file = new File(tokens[3] + tokens[4]);
		// ��â ����.
		FileFrame fileFrame = new FileFrame(tokens[1], tokens[2], tokens[3], tokens[4], file.length(), serverMessage, chatClient);
		fileFrame.init();
		fileFrame.setLocation(500, 0);
		fileFrame.setSize(400,100);
		fileFrame.setVisible(true);
	}
	
	public void setContents() {
		setLayout(new BorderLayout());
		// ������Ʈ ���� ����
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
	 * Container�� GridBagLayout ���·� ��ҵ��� �߰�
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
			// ä�ù� �����Ѵٰ� �޽��� ����
			String message = MessageType.CC_DISCONNECT + MessageType.DELEMITER + connTf.getText();
			chatClient.messageSend(message);
			chatClient.disConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
