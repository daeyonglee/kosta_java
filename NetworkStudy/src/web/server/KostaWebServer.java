package web.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * HTTP �����������ݿ� ���� ��Ŭ���̾�Ʈ(������)�� HTTP ��û�� �����Ͽ� �м��ϰ�,
 * HTTP ����޽����� �����Ͽ� ��Ŭ���̾�Ʈ�� ����(����)�ϴ� �������� �⺻���� ��� ����
 * @author �����
 */
public class KostaWebServer {
	
	public static final int PORT = 80; // HTTP���� ����ϴ� �� �˷��� ��Ʈ
	
	// ���ͳݻ��� ��� ��Ŭ���̾�Ʈ�鿡�� ����(����)�ϰ��� �ϴ� ���ҽ�(����) ���� �� ���丮 ���
//	public static final String WEB_DIRECTORY = "C:/some/WebContents";
	public static final String WEB_DIRECTORY = "WebContents";
	
	public static void main(String[] args) {
		boolean running = true;
		
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(PORT);
			System.out.println("�١١� Http Web Server["+PORT+"] Start �١١�");
			while(running){
				Socket socket = serverSocket.accept();
				System.out.println("Web Client(Browser) ����...");
				
				// ������ ��Ŭ���̾�Ʈ ��û �޽��� �Ľ� �� ����޽����� �����ϴ� ������ ���� �� ����
				HttpRequestHandler requestHandler = new HttpRequestHandler(socket);
				requestHandler.start();
			}
			System.out.println("�ڡڡ� Web Server("+PORT+") Stop �ڡڡ�");
			
		} catch (IOException e) {
			System.out.println("��Ʈ("+PORT+") �浹�� Web Server�� ������ �� �����ϴ�..");
		} finally{
			try {
				if(serverSocket != null) serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
