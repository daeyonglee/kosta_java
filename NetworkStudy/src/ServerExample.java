import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP/IP 기반의 Echo서버 구현
 * @author 이대용
 *
 */
public class ServerExample {
	public static void main(String[] args) {
		
		int port = 7777;
		boolean running = true;
		
		ServerSocket server = null;
		Socket clientSocket = null;
		BufferedReader br = null;
		PrintWriter pw  = null;
		// Client가 보낸 것을 응답하는 Socket인 ServerSocket 클래스 사용한다.
		try {
				server = new ServerSocket(port);
				System.out.println("서버가 정상적으로 구동되었습니다.");
			while(running) {
				System.out.println("원격클라이언트 연결 대기중...");
				// 아무도 연결하지 않으면 여기서 계속 머물러 있음.
				clientSocket = server.accept();
				
				System.out.println("클라이언트[" + clientSocket.getInetAddress() + "] 연결해옴..." + clientSocket);
				
				ClientThread c = new ClientThread(clientSocket);
				c.start();
			}
		} catch (IOException e) {
			System.out.println("포트("+port+") 충돌로 서버를 구동할 수 없습니다.");
		} finally {
				/*try {
					if (pw != null) pw.close();
					if (br != null) br.close();
					if (clientSocket != null) clientSocket.close();
					if (server != null) server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}*/
		}
	}
}
