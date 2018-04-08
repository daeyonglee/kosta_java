package kr.or.kosta.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Vector;

public class ChatServer {
	
	private static final int PORT = 2018;
	
	ServerSocket serverSocket;
	
	boolean running;
	
	private Vector<ClientThread> clients;
	
	public ChatServer(){
		running = false;
		clients = new Vector<ClientThread>(100, 2);
	}
	
	// getter
	public ServerSocket getServer() {
		return serverSocket;
	}
	
	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	public boolean isRunning() {
		return running;
	}
	
	public void startUp() throws IOException {
		serverSocket = new ServerSocket(PORT);
	}
	
	public void shutDown() throws IOException {
		serverSocket = null;
	}
	
	public void listen() throws IOException {
		running = true;
		System.out.println("Chat Server "+ PORT + "port listening...");
		while(running) {
			Socket clientSocket = serverSocket.accept();
			ClientThread client = new ClientThread(this, clientSocket);
			clients.addElement(client);
			
			client.start();
			System.out.println("����� Ŭ���̾�Ʈ�� : " + clients.size());
		}
	}
	
	/**
	 * ������ ��� Ŭ���̾�Ʈ�鿡�� �޽��� ����
	 * @param args
	 */
	public void sendAllMessage(String message) {
		Enumeration<ClientThread> e = clients.elements();
		while(e.hasMoreElements()) {
			ClientThread client = e.nextElement();
			client.sendMessage(message);
		}
	}
	
	public static void main(String[] args) {
		ChatServer server = new ChatServer();
		try {
			server.startUp();
			System.out.println("Chat Server Start....");
			
			server.listen();
			
		} catch (IOException e) {
			System.out.println("��Ʈ �浹�� ������ ������ �� �����ϴ�..");
		}
	}
}
