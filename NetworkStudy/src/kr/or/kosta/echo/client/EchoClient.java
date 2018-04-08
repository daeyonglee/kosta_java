package kr.or.kosta.echo.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient {
	
	public static final String IP = "127.0.0.1";
	public static final int PORT  = 2018;
	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;
	boolean connected;
	
	public EchoClient() {
		connected = false;
	}

	public Socket getSocket() {
		return socket;
	}

	public PrintWriter getOut() {
		return out;
	}

	public BufferedReader getIn() {
		return in;
	}
	
	public boolean isConnected() {
		return connected;
	}

	public void connect() throws UnknownHostException, IOException {
		connected = true;
		socket = new Socket(IP, PORT);
		if (out == null) out = new PrintWriter(socket.getOutputStream(), true);
		if (in == null)  in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}
	
	public void disConnect() throws IOException {
		if (in != null) out.close();
		if (out != null) out.close();
		if (socket != null) socket.close();
	}
	
	public void messageSend(String message) throws IOException {
		out.println(message);
	}
	
	public void messageListening() throws UnsupportedEncodingException, IOException {
		
		String serverMessage = in.readLine();
		
		if (serverMessage == null) return;
		
		System.out.println("�� ���� ���� �޽��� : " + serverMessage);
	}
	
	public static void main(String[] args) {
		EchoClient client = new EchoClient();
		Scanner scanner = null;
		try {
			client.connect();
			System.out.println("EchoServer connected...");

			scanner = new Scanner(System.in);
			String message = null;
			while(client.isConnected()) {
				message = scanner.nextLine();
				if ("quit".equalsIgnoreCase(message)) {
					System.out.println("������ �����մϴ�.");
					client.disConnect();
				}
				if (message != null) {
					client.messageSend(message);
					client.messageListening();
				}
			}
			
		} catch (UnknownHostException e) {
			System.out.println("���� IP�� �߸��Ǿ����ϴ�.");
		} catch (IOException e) {
			System.out.println("������ ������ �߻��Ͽ����ϴ�.");
		} finally {
			try {
				client.disConnect();
				if( scanner != null ) scanner.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
