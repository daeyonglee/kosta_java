package kr.or.kosta.echo.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	
	private static final int PORT = 2018;
	
	ServerSocket serverSocket;
	
	boolean running;
	
	public EchoServer(){
		running = false;
	}
	
	// getter
	public ServerSocket getServer() {
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
		System.out.println("Echo Server "+ PORT + "port listening...");
		while(running) {
			Socket clientSocket = serverSocket.accept();
			ClientThread client = new ClientThread(clientSocket);
			client.start();
		}
	}
	
	public static void main(String[] args) {
		EchoServer server = new EchoServer();
		try {
			server.startUp();
			System.out.println("Echo Server Start....");
			
			server.listen();
			
		} catch (IOException e) {
			System.out.println("포트 충돌로 서버를 구동할 수 없습니다..");
		}
	}
}
