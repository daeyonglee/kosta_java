package kr.or.kosta.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

import kr.or.kosta.chat.entity.User;
import kr.or.kosta.chat.util.MessageType;

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
	
	public Vector<ClientThread> getClients() {
		return clients;
	}

	public void setClients(Vector<ClientThread> clients) {
		this.clients = clients;
	}

	public void listen() throws IOException {
		running = true;
		System.out.println("ChatServer port["+ PORT + "] listening...");
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
	
	/**
	 * Ư�� 1�ο��� �޽��� ����
	 * @param message
	 */
	public void sendMessageToPerson(String message) {
		// protocol + �����»�� + �޴»�� + ������ġ + ���ϸ� + ���������㰡����
		String[] tokens = message.split(MessageType.DELEMITER);
		Enumeration<ClientThread> e = clients.elements();
		while(e.hasMoreElements()) {
			ClientThread client = e.nextElement();
			if (tokens[2].equals(client.getUser().getNickName())) {
				client.sendMessage(message);
				break;
			}
		}
	}
	
	/**
	 * CSV�� �����ڷ��Ͽ� ��������� ����
	 * @return => message : "user1,user2,user3,user4,...."
	 */
	public String makeUserList() {
		String message = "";
		Enumeration<ClientThread> e = clients.elements();
		while (e.hasMoreElements()) {
			ClientThread client = e.nextElement();
			if (client.getUser() != null) {
				message += client.getUser().getNickName() + ",";
			}
		}
		
		return message;
	}
	
	/**
	 * Ư�� ������ �����Ѵ�.
	 * @param nickName => �����ϰ��� �ϴ� ���� �г���
	 */
	public void removeUser(String nickName) {
		Enumeration<ClientThread> e = clients.elements();
		while(e.hasMoreElements()) {
			ClientThread client = e.nextElement();
			if (nickName.equals(client.getUser().getNickName())) {
				clients.removeElement(client);
			}
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
