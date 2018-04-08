package kr.or.kosta.echo.server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 원격 클라이언트와 통신을 담당하는 스레드
 * @author 이대용
 *
 */
public class ClientThread extends Thread{

	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	public ClientThread(Socket socket) throws IOException {
		this.socket = socket;
		
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
	}
	// setter/getter
	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public BufferedReader getIn() {
		return in;
	}

	public void setIn(BufferedReader in) {
		this.in = in;
	}

	public PrintWriter getOut() {
		return out;
	}

	public void setOut(PrintWriter out) {
		this.out = out;
	}

	public void echo() {
		String clientMessage = null;
		try {
			while(true) {
				clientMessage = in.readLine();
				if (clientMessage == null)                  break;
 				if (clientMessage.equalsIgnoreCase("quit")) break;
				
				System.out.println("▶ 클라이언트로부터 수신한 메시지 : " + clientMessage);
				
				// 에코
				out.println(clientMessage);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
				try {
					if (out != null) 	out.close();
					if (in != null) 	in.close();
					if (socket != null) socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	@Override
	public void run() {
		echo();
	}
}
