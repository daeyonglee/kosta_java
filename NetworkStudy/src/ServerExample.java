import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP/IP ����� Echo���� ����
 * @author �̴��
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
		// Client�� ���� ���� �����ϴ� Socket�� ServerSocket Ŭ���� ����Ѵ�.
		try {
				server = new ServerSocket(port);
				System.out.println("������ ���������� �����Ǿ����ϴ�.");
			while(running) {
				System.out.println("����Ŭ���̾�Ʈ ���� �����...");
				// �ƹ��� �������� ������ ���⼭ ��� �ӹ��� ����.
				clientSocket = server.accept();
				
				System.out.println("Ŭ���̾�Ʈ[" + clientSocket.getInetAddress() + "] �����ؿ�..." + clientSocket);
				
				ClientThread c = new ClientThread(clientSocket);
				c.start();
			}
		} catch (IOException e) {
			System.out.println("��Ʈ("+port+") �浹�� ������ ������ �� �����ϴ�.");
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
