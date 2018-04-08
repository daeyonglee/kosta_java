package kr.or.kosta.ftp.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class FTPServer {
	
	public static final int PORT = 2017;
	
	private ServerSocket serverSocket;
	
	private Vector<FTPThread> clients;
	
	boolean running;
	
	public FTPServer() {
		clients = new Vector<FTPThread>(100, 2);
	}
	
	public Vector<FTPThread> getClients() {
		return clients;
	}

	public ServerSocket getServerSocket() {
		return serverSocket;
	}
	
	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}
	
	/** 서버 구동 */
	public void startUp() throws IOException{
		serverSocket = new ServerSocket(PORT);
	}
	
	/** 서버 종료 */
	public void shutDown() throws IOException{
		if(serverSocket != null) serverSocket.close();
	}
	
	/** 클라이언트 연결 수신 */
	public void listen() throws IOException{
		while(!running){
			Socket socket = serverSocket.accept();
			InetAddress ia = socket.getInetAddress();
			System.out.println("FTP 클라이언트[" + ia.getHostAddress() + "] 접속 >>>");
			
			FTPThread client = new FTPThread(this, socket);
			clients.addElement(client);
			
			client.start();
		}		
	}
	
	public static void main(String[] args) {
		FTPServer server = new FTPServer();
		try {
			server.startUp();
			System.out.println("FTPServer["+PORT+"] Startup.....");
			server.listen();
		} catch (IOException e) {
			System.out.println("포트["+PORT+"] 충돌로 서버를 구동할 수 없습니다.");
		}
	}
}
