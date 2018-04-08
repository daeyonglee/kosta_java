package ftp.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 파일 목록 송신 및 파일 다운로드 서비스 제공 Simple FTP 서버
 * @author 김기정
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
		while(!stop){
			Socket socket = serverSocket.accept();
			InetAddress ia = socket.getInetAddress();
			System.out.println("FTP 클라이언트[" + ia.getHostAddress() + "] 접속 >>>");
			
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
			System.out.println("포트["+PORT+"] 충돌로 서버를 구동할 수 없습니다.");
		}

	}
}
