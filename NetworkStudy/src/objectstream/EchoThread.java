package objectstream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * ObjectStream�� �̿��� ��ü ��Ʈ��ũ ��� ������
 *
 * @author �����
 */
public class EchoThread extends Thread {
	Socket socket = null;
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;

	public EchoThread() {}

	public EchoThread(Socket socket) {
		this.socket = socket;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void readNWrite() {
		try {
			// ��ü ������ �б�
			User user = (User) ois.readObject();
			System.out.println("[�����] Ŭ���̾�Ʈ�� ���� �о���� ��ü : " + user.toString());
			
			// ��ü ������ ����
			oos.writeObject(user);
			oos.flush();
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally{
			if(ois != null){try {ois.close();} catch (IOException e) {}}
			if(oos != null){try {oos.close();} catch (IOException e) {}}
			if(socket != null){try {socket.close();} catch (IOException e) {}}
		}
	}
	
	public void run() {
		readNWrite();
	}

}