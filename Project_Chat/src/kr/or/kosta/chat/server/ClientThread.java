package kr.or.kosta.chat.server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import kr.or.kosta.chat.entity.User;
import kr.or.kosta.chat.util.MessageType;
import kr.or.kosta.ftp.client.FTPClient;

/**
 * 원격 클라이언트와 통신을 담당하는 스레드
 * @author 이대용
 *
 */
public class ClientThread extends Thread{

	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	private ChatServer chatServer;
	private User user;
	
	private boolean running;
	
	public ClientThread(ChatServer chatServer, Socket socket) throws IOException {
		running = true;
		this.chatServer = chatServer;
		this.socket = socket;
		
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
	}
	// setter/getter
	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public BufferedReader getIn() {
		return in;
	}

	public void setIn(BufferedReader in) {
		this.in = in;
	}

	public PrintWriter getOut() {
		return out;
	}

	public void setOut(PrintWriter out) {
		this.out = out;
	}
	
	public void sendMessage(String message) {
		out.println(message);
		out.flush();
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public void requestMessage() {
		String clientMessage = null;
		try {
			while(running) {
				clientMessage = in.readLine();
				System.out.println("▶ 클라이언트로부터 수신한 메시지 : " + clientMessage);
				
				String[] tokens = clientMessage.split(MessageType.DELEMITER);
				String protocol = tokens[0];
				String nickName = tokens[1];
				String userList = "";
				
				OUT:
				switch(protocol) {
					case MessageType.CC_CONNECT :
						user = new User(nickName);
						chatServer.sendAllMessage(clientMessage);
						break;
					case MessageType.CC_MULTI_MESSAGE :
						chatServer.sendAllMessage(clientMessage);
						break;
					case MessageType.CC_SINGLE_MESSAGE :
						chatServer.sendMessageToPerson(clientMessage);
						break;
					case MessageType.CC_FILE_YN :
						chatServer.sendMessageToPerson(clientMessage);
						break;
					case MessageType.CC_SINGLE_FILE_RECEIVE :
						chatServer.sendMessageToPerson(clientMessage);
						break;
					case MessageType.CC_DISCONNECT :
						chatServer.removeUser(nickName);
						userList = chatServer.makeUserList();
						chatServer.sendAllMessage(clientMessage+MessageType.DELEMITER+userList);
						break OUT;
					case MessageType.SC_CONNECT_LIST :
						userList = chatServer.makeUserList();
						chatServer.sendAllMessage(MessageType.SC_CONNECT_LIST+MessageType.DELEMITER+MessageType.SERVER+MessageType.DELEMITER+userList);
						break;
					default : break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
				try {
					if (out != null) 	out.close();
					if (in != null) 	in.close();
					if (socket != null) socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	@Override
	public void run() {
		requestMessage();
	}
}
