package kr.or.kosta.chat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
	
	private static final String IP = "127.0.0.1";
	private static final int PORT = 2018;
	
	private Socket socket;
	private String nickName;
	
	BufferedReader in;
	PrintWriter out;
	
	public ChatClient(String nickName) {
		this.nickName = nickName;
	}

	public String getNickName() {
		return nickName;
	}

	public void connect() throws UnknownHostException, IOException {
		socket = new Socket(IP, PORT);
		if (in == null) in   = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		if (out == null) out = new PrintWriter(socket.getOutputStream(), true);
	}

	public void messageListening() {
		ServerThread thread = new ServerThread(in);
		thread.start();
	}

	public void messageSend(String message) {
		out.println(message);
	}
	
	public void disConnection() throws IOException {
		if (out != null) out.close();
		if (in != null) in.close();
		if (socket != null) socket.close();
	}
}
