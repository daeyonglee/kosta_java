package kr.or.kosta.chat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatClient{
	
	public static final String IP = "127.0.0.1";
	public static final int PORT  = 2018;
	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;
	boolean connected;
	
	private String nickName;
	
	public ChatClient(String nickName) {
		connected = false;
		this.nickName = nickName;
	}

	public Socket getSocket() {
		return socket;
	}

	public PrintWriter getOut() {
		return out;
	}

	public BufferedReader getIn() {
		return in;
	}
	
	public boolean isConnected() {
		return connected;
	}

	public String getNickName() {
		return nickName;
	}
	
	public void connect() throws UnknownHostException, IOException {
		connected = true;
		socket = new Socket(IP, PORT);
		if (out == null) out = new PrintWriter(socket.getOutputStream(), true);
		if (in == null)  in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}
	
	public void disConnect() throws IOException {
		if (in != null) out.close();
		if (out != null) out.close();
		if (socket != null) socket.close();
	}
	
	public void messageSend(String message) throws IOException {
		out.println(message);
	}
	
	public void messageListening() throws UnsupportedEncodingException, IOException {
		
		/*String serverMessage = in.readLine();
		
		if (serverMessage == null) return;
		
		System.out.println("▶ 서버 수신 메시지 : " + serverMessage);*/
		
		ServerThread thread = new ServerThread(in);
		thread.start();
	}
	
	public static void main(String[] args) {
		Scanner scanner = null;
		
		scanner = new Scanner(System.in);
		System.out.println("사용하고자 하는 대화명 : ");
		String nickName = scanner.nextLine();
		
		ChatClient client = new ChatClient(nickName);
		
		try {
			client.connect();
			System.out.println("ChatServer connected...");
			client.messageListening();
			
			// 최초 연결 메시지 전송
			client.messageSend(MessageType.CC_CONNECT+MessageType.DELEMITER+nickName);
			
			String message = null;
			while(client.isConnected()) {
				message = scanner.nextLine();
				if ("quit".equalsIgnoreCase(message)) {
					client.messageSend(MessageType.CC_DISCONNECT+MessageType.DELEMITER+nickName);
					break;
				}
				client.messageSend(MessageType.CC_MULTI_MESSAGE+MessageType.DELEMITER+nickName+MessageType.DELEMITER+message);
			}
		} catch (UnknownHostException e) {
			System.out.println("서버 IP가 잘못되었습니다.");
		} catch (IOException e) {
			System.out.println("서버에 문제가 발생하였습니다.");
		} finally {
			try {
				client.disConnect();
				if( scanner != null ) scanner.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
