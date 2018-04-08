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
 * 웹클라이언트(브라우저) 구현
 * #1.HTTP 응용프로토콜에 따라 요청메시지(텍스트 데이터)를 웹서버로 전송하고
 * #2.웹서버로부터 응답메시지(텍스 트데이터)를 수신하여 분석하고, 
 * #3.응답메시지의 바디내용(HTML, CSS, JavaScript 등)을 렌더링하여 출력
 * @author 김기정
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
		
		// HTTP 요청 메시지 생성
		String requestMessage = "GET " + url.getPath() + " HTTP/1.0\r\n\r\n";
		System.out.println(requestMessage);
		pw.println(requestMessage);		
		
		// 서버(소켓)으로부터 응답메시지 수신
//		System.out.println(br.readLine());
		String html = null;
		while((html=br.readLine()) != null){
			System.out.println(html);
		}
		pw.close();
		br.close();
		
		// html 렌더링 생략...
	}
}






