import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Socket을 이용한 Client 구현
 * @author 이대용
 *
 */
public class SocketExample {
	public static void main(String[] args) {
		// Client입장에서 IP와 Port번호는 반드시 알아야한다.
		String domainName = "www.naver.com";
		int port = 80;
		
		Socket socket = null;
		PrintWriter pw = null;
		BufferedReader br = null;
		
		try {
//			Socket socket = new Socket(InetAddress.getByName(domainName), port);
			socket = new Socket(InetAddress.getLocalHost(), 7777);
			System.out.println("서버와 연결되었습니다.");
			
			// 소켓과의 스트림 생성
			OutputStream out = socket.getOutputStream();
			InputStream in = socket.getInputStream();
			
			pw = new PrintWriter(out, true);
			br = new BufferedReader(new InputStreamReader(in));

			Scanner scanner = new Scanner(System.in);
			while(true) {
				String inputMessage = scanner.nextLine();
				if (inputMessage.equalsIgnoreCase("quit")) {
					break;
				}
				
				pw.println(inputMessage);
				
				String serverMessage = br.readLine();
				System.out.println("▶ 서버 수신 메시지 : " + serverMessage);
			}
			
			System.out.println("연결 종료...");
			
		} catch (UnknownHostException e) {
			System.out.println("서버를 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("네트워크 장애가 발생하였습니다.");
		} finally {
			try {
				if (br != null) br.close();
				if (pw != null) pw.close();
				if (socket != null) socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
