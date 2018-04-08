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
 * Socket�� �̿��� Client ����
 * @author �̴��
 *
 */
public class SocketExample {
	public static void main(String[] args) {
		// Client���忡�� IP�� Port��ȣ�� �ݵ�� �˾ƾ��Ѵ�.
		String domainName = "www.naver.com";
		int port = 80;
		
		Socket socket = null;
		PrintWriter pw = null;
		BufferedReader br = null;
		
		try {
//			Socket socket = new Socket(InetAddress.getByName(domainName), port);
			socket = new Socket(InetAddress.getLocalHost(), 7777);
			System.out.println("������ ����Ǿ����ϴ�.");
			
			// ���ϰ��� ��Ʈ�� ����
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
				System.out.println("�� ���� ���� �޽��� : " + serverMessage);
			}
			
			System.out.println("���� ����...");
			
		} catch (UnknownHostException e) {
			System.out.println("������ ã�� �� �����ϴ�.");
		} catch (IOException e) {
			System.out.println("��Ʈ��ũ ��ְ� �߻��Ͽ����ϴ�.");
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
