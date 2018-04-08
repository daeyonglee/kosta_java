package ftp.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ���� ��� �۽� �� ���� �ٿ�ε� ���� ���� Simple FTP ����
 * @author �����
 */
public class FTPServer {
	
	public static final int PORT = 2018;
	
	private boolean stop;
	private ServerSocket serverSocket;
	
	// setter/getter
	public boolean isStop() {
		return stop;
	}
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	public ServerSocket getServerSocket() {
		return serverSocket;
	}
	
	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}
	
	/** ���� ���� */
	public void startUp() throws IOException{
		serverSocket = new ServerSocket(PORT);
	}
	
	/** ���� ���� */
	public void shutDown() throws IOException{
		if(serverSocket != null) serverSocket.close();
	}
	
	/** Ŭ���̾�Ʈ ���� ���� */
	public void listen() throws IOException{
		while(!stop){
			Socket socket = serverSocket.accept();
			InetAddress ia = socket.getInetAddress();
			System.out.println("FTP Ŭ���̾�Ʈ[" + ia.getHostAddress() + "] ���� >>>");
			
			FTPThread thread = new FTPThread(socket);
			thread.start();
		}		
	}
	
	public static void main(String[] args) {
		FTPServer server = new FTPServer();
		try {
			server.startUp();
			System.out.println("FTPServer["+PORT+"] Startup.....");
			server.listen();
		} catch (IOException e) {
			System.out.println("��Ʈ["+PORT+"] �浹�� ������ ������ �� �����ϴ�.");
		}

	}
}
