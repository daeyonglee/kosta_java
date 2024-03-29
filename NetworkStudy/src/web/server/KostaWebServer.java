package web.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * HTTP 응용프로토콜에 따라 웹클라이언트(브라우저)의 HTTP 요청을 수신하여 분석하고,
 * HTTP 응답메시지를 생성하여 웹클라이언트로 응답(전송)하는 웹서버의 기본적인 기능 구현
 * @author 김기정
 */
public class KostaWebServer {
	
	public static final int PORT = 80; // HTTP에서 사용하는 잘 알려진 포트
	
	// 인터넷상의 모든 웹클라이언트들에게 서비스(공유)하고자 하는 리소스(파일) 저장 웹 디렉토리 경로
//	public static final String WEB_DIRECTORY = "C:/some/WebContents";
	public static final String WEB_DIRECTORY = "WebContents";
	
	public static void main(String[] args) {
		boolean running = true;
		
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(PORT);
			System.out.println("☆☆☆ Http Web Server["+PORT+"] Start ☆☆☆");
			while(running){
				Socket socket = serverSocket.accept();
				System.out.println("Web Client(Browser) 연결...");
				
				// 접속한 웹클라이언트 요청 메시지 파싱 및 응답메시지를 전송하는 스레드 생성 및 시작
				HttpRequestHandler requestHandler = new HttpRequestHandler(socket);
				requestHandler.start();
			}
			System.out.println("★★★ Web Server("+PORT+") Stop ★★★");
			
		} catch (IOException e) {
			System.out.println("포트("+PORT+") 충돌로 Web Server를 구동할 수 없습니다..");
		} finally{
			try {
				if(serverSocket != null) serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
