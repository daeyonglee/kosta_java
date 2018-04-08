package kr.or.kosta.chat.client;

import java.io.BufferedReader;
import java.io.IOException;

public class ServerThread extends Thread{
	
	private BufferedReader in;
	private boolean running;
	
	public ServerThread(BufferedReader in) {
		this.in = in;
		running = true;
	}
	
	public void processMessage() throws IOException {
		
		while (running) {
			String serverMessage = in.readLine();
			System.out.println("▶서버로부터 수신한 메시지 : " + serverMessage);

			if (serverMessage != null) {
				String[] tokens = serverMessage.split(MessageType.DELEMITER);
				String protocol = tokens[0];
				String nickName = tokens[1];
				
				switch(protocol) {
					case MessageType.CC_CONNECT :
						System.out.println("#### "+nickName+"님이 최초 연결하였습니다");
						break;
					case MessageType.CC_MULTI_MESSAGE :
						String chatMessage = tokens[2];
						System.out.println("["+nickName+"] : " + chatMessage);
						break;
					case MessageType.CC_DISCONNECT :
						System.out.println("$$$$ "+nickName+"님이 퇴장하였습니다.");
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
