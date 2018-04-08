package kr.or.kosta.chat.boundary;

import java.awt.Button;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.UnknownHostException;

import kr.or.kosta.chat.client.ChatClient;
import kr.or.kosta.chat.util.MessageType;
import kr.or.kosta.ftp.client.FTPClient;
import kr.or.kosta.ftp.server.FTPServer;

@SuppressWarnings("serial")
public class FileFrame extends Frame {
	
	Button confirm;
	Button reject;
	
	Label label;
	Label label1;
	
	private String sendUser;
	private String receiveUser;
	private String fileName;
	private String fileDirectory;
	private long fileLength;
	private String serverMessage;
	
	private ChatClient chatClient;
	
	public FileFrame (String sendUser, String receiveUser, String fileDirectory, String fileName, long fileLength, String serverMessage, ChatClient chatClient) {
		this.sendUser      = sendUser;
		this.receiveUser   = receiveUser;
		this.fileName      = fileName;
		this.fileDirectory = fileDirectory;
		this.fileLength    = fileLength;
		this.serverMessage = serverMessage;
		this.chatClient    = chatClient;
	}

	public void init() {
		
		confirm = new Button("수락");
		reject  = new Button("거부");
		
		label   = new Label("["+sendUser+"]" + "님이 파일을 전송하려고합니다.");
		label1  = new Label(" 수락하시겠습니까?" + fileName + ", " + fileLength);
		setLayout(new FlowLayout());
		
		add(label);
		add(label1);
		add(confirm);
		add(reject);
		
		setEventRegist();
	}
	
	public void setEventRegist() {
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					executeFileSend();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		reject.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		
	}

	public void executeFileSend() throws IOException {
		FileDialog fileDialog = new FileDialog(this, "저장", FileDialog.SAVE);
		fileDialog.setVisible(true);
		System.out.println(fileDialog.getDirectory());
		System.out.println(fileDialog.getFile());
		
		// protocol + 보내는사람 + 받는사람 + 보내는 파일경로 + 보내는 파일명 + 받는 파일경로 + 받는 파일명
		String message = MessageType.CC_SINGLE_FILE_RECEIVE + MessageType.DELEMITER 
				+ sendUser + MessageType.DELEMITER + receiveUser + MessageType.DELEMITER
				+ fileDirectory + MessageType.DELEMITER + fileName + MessageType.DELEMITER
				+ fileDialog.getDirectory() + MessageType.DELEMITER + fileDialog.getFile();
		
		connectFTPServer(fileDialog.getDirectory(), fileDialog.getFile());
		chatClient.messageSend(message);
		
 		exit();
	}
	
	private void connectFTPServer(String directory, String fileName) throws UnknownHostException, IOException {
		FTPClient client = new FTPClient(receiveUser);
		client.connect();
		//client.messageSend("FIRST,"+receiveUser);
		//client.messageSend("RECEIVE,"+directory+fileName);
	}
	
	public void exit() {
		setVisible(false);
		dispose();
	}
}
