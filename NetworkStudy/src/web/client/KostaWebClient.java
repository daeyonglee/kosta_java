package web.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;

/**
 * ��Ŭ���̾�Ʈ(������) ����
 * #1.HTTP �����������ݿ� ���� ��û�޽���(�ؽ�Ʈ ������)�� �������� �����ϰ�
 * #2.�������κ��� ����޽���(�ؽ� Ʈ������)�� �����Ͽ� �м��ϰ�, 
 * #3.����޽����� �ٵ𳻿�(HTML, CSS, JavaScript ��)�� �������Ͽ� ���
 * @author �����
 */
public class KostaWebClient {

	public static void main(String[] args) throws IOException {
		String urlString = "http://www.kbs.co.kr:80/index.html";
		//String urlString = "http://localhost:80/index.html";
		URL url = new URL(urlString);
		
		Socket socket = new Socket(url.getHost(), url.getPort());
		System.out.println("Web Server Connected ...");
		
		OutputStream out = socket.getOutputStream();
		InputStream in = socket.getInputStream();
		PrintWriter pw = new PrintWriter(out, true);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		// HTTP ��û �޽��� ����
		String requestMessage = "GET " + url.getPath() + " HTTP/1.0\r\n\r\n";
		System.out.println(requestMessage);
		pw.println(requestMessage);		
		
		// ����(����)���κ��� ����޽��� ����
//		System.out.println(br.readLine());
		String html = null;
		while((html=br.readLine()) != null){
			System.out.println(html);
		}
		pw.close();
		br.close();
		
		// html ������ ����...
	}
}






