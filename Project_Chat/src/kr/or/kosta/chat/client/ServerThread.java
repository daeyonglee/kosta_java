package kr.or.kosta.chat.client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

import kr.or.kosta.chat.boundary.ChatFrame;
import kr.or.kosta.chat.boundary.FileFrame;
import kr.or.kosta.chat.entity.User;
import kr.or.kosta.chat.server.ChatServer;
import kr.or.kosta.chat.util.MessageType;
import kr.or.kosta.ftp.client.FTPClient;

public class ServerThread extends Thread{
	
	private BufferedReader in;
	private boolean running;
	
	public ServerThread(BufferedReader in) {
		this.in = in;
		running = true;
	}
	
	public void processMessage() throws IOException {
		
		ChatFrame frame = ChatFrame.getInstance();
		
		while (running) {
			String serverMessage = in.readLine();
			System.out.println("�������κ��� ������ �޽��� : " + serverMessage);
			
			if (serverMessage != null) {
				String[] tokens = serverMessage.split(MessageType.DELEMITER);
				String protocol = tokens[0];
				String nickName = tokens[1];
				
				switch(protocol) {
					case MessageType.CC_CONNECT :
						frame.writeMessage("#### "+nickName+"���� �����Ͽ����ϴ�.\n");
						frame.writeList(nickName, 0);
						frame.setting(1);
						break;
					case MessageType.CC_MULTI_MESSAGE :
						String chatMessage = tokens[2];
						frame.writeMessage("["+nickName+"] : " + chatMessage + "\n");
						break;
					case MessageType.CC_SINGLE_MESSAGE : 
						// protocol + �����»�� + �޴»�� + ������ ����
						String sendUser    = tokens[1];
						String message     = tokens[3];
						frame.writeMessage("["+sendUser+"]"+"���� �ӼӸ� : "+ message + "\n");
						break;
					case MessageType.CC_SINGLE_FILE_RECEIVE : 
						FTPClient client = new FTPClient(nickName);
						client.connect();
						boolean result = client.fileDownload(tokens[3], tokens[4], tokens[5], tokens[6]);
						if (result) {
							frame.writeMessage("���������� �Ϸ�Ǿ����ϴ�.");
						}
						break;
					case MessageType.CC_FILE_YN : 
						// protocol + �����»�� + �޴»�� + ������ġ + ���ϸ�
						frame.executeFileFrame(serverMessage);
						break;
					case MessageType.CC_DISCONNECT :
						// tokens[2]�� ��������Ʈ.
						frame.writeMessage("$$$$ "+nickName+"���� �����Ͽ����ϴ�.");
						frame.writeList(tokens[2], 1);
						break;
					case MessageType.SC_CONNECT_LIST :
						String list = "";
						if (tokens.length > 2) {
							list = tokens[2];
						}
						if (!"".equals(list)) frame.writeList(list, 1);
						break;
				default : break;
				}
			}
		}
	}
	
	@Override
	public void run() {
		try {
			processMessage();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
				try {
					if (in != null) in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
