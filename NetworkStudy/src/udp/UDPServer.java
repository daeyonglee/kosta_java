package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * DatagramSocket�� DatagramPacket�� �̿��� UDP ��� ���ڼ���
 * ���ǻ� �����带 �̿��� ��Ƽ ���ڴ� ����
 */
public class UDPServer {
	public static final int PORT = 2018;
	
	boolean stop;
	DatagramSocket dataSocket;
	DatagramPacket receivePacket;

	public void serverStart() throws SocketException {
		// DatagramPacket ����/�۽��� ���� DatagramSocket ����
		dataSocket = new DatagramSocket(PORT);
		System.out.println("### UDP EchoServer Start!! ###");
		while (!stop) {
			// Ŭ���̾�Ʈ ������ ������ ���� DatagramPacket ����(�����)
			byte[] buffer = new byte[512];
			receivePacket = new DatagramPacket(buffer, buffer.length);

			try {
				// Ŭ���̾�Ʈ ������ ����
				dataSocket.receive(receivePacket); // ������ ���Žñ��� ��
				
				InetAddress clientIP = receivePacket.getAddress();
				// ���ŵ� ������ �б�
				byte[] clientData = receivePacket.getData();
				// Ŭ���̾�Ʈ���� �׽�Ʈ�� ������ �����Ͱ� ���ڿ��̱� ������ ���� ���ڵ�ó��..
				String clientMessage = new String(clientData, 0, clientData.length);
				System.out.println("Ŭ���̾�Ʈ("+clientIP + ")�κ����� ���� �޽��� : " + clientMessage);

				// Ŭ���̾�Ʈ�� ������ ����(����)
				// Ŭ���̾�Ʈ�� �����ͼ۽��� ���� DatagramPacket ����
				DatagramPacket dataSendPacket = new DatagramPacket(clientData, clientData.length, clientIP,	receivePacket.getPort());
				dataSocket.send(dataSendPacket);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void stopServer() {
		if (dataSocket != null) {
			dataSocket.close();
		}
	}

	public static void main(String[] args) {
		UDPServer server = new UDPServer();
		try {
			server.serverStart();
		} catch (SocketException e) {
			e.printStackTrace();
		} finally {
			server.stopServer();
		}

	}

}
