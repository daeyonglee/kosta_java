package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP��� Ŭ���̾�Ʈ
 */
public class UDPClient {
	String serverIP;
	DatagramSocket dataSocket;	
	DatagramPacket sendPacket;
	
	public UDPClient(){
		this("localhost");
	}
	public UDPClient(String serverIP){
		this.serverIP = serverIP;
	}
	
	
	public void clientStart() throws Exception{
		// DatagramPacket �ۼ����� ���� DatagramSocket ����
		dataSocket  = new DatagramSocket(8282);// ������ ���� ��Ʈ

		String inputMessage = "�ȳ��ϼ���. ������Դϴ�..";
		byte[] buffer = inputMessage.getBytes();
		
		// ������ ������ ���� ����
		sendPacket = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(serverIP), UDPServer.PORT);
		
		// ������ ������(����) ����
		dataSocket.send(sendPacket);
		
		// ������ ������ ���� DatagramPacket(�����) ����
		DatagramPacket dataReceivePacket = new DatagramPacket(buffer, buffer.length);
		dataSocket.receive(dataReceivePacket);
		System.out.println("�����κ��� ���ڵ� �޽���: " + new String(buffer, 0, buffer.length));			
	}
	
	public void close() {
		if (dataSocket != null) {
			dataSocket.close();
		}
	}
	
	
	public static void main(String[] args) {
		UDPClient client = new UDPClient();
		try {
			client.clientStart();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			client.close();
		}
	}

}
