package objectstream;

import java.io.*;
import java.net.*;

/**
 * ��ü(Object) ������ ��Ʈ��ũ �����
 * @author �����
 */
public class ObjectStreamClient{
	
	public static void main(String[] args){
		Socket clientSocket = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		
		try{
			clientSocket = new Socket("localhost", 2018);
			         			
			oos = new ObjectOutputStream(clientSocket.getOutputStream());
			ois = new ObjectInputStream(clientSocket.getInputStream());
			
			// ������ ��ü�� ����
			User user = new User("�����", "bangry", 30);
			oos.writeObject(user);
			oos.flush();
			
			User readUser = (User)ois.readObject();
			System.out.println("[�����]������ ���� ������ ��ü : " + readUser);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(ois != null){try {ois.close();} catch (IOException e) {}}
			if(oos != null){try {oos.close();} catch (IOException e) {}}
			if(clientSocket != null){try {clientSocket.close();} catch (IOException e) {}}
		}
	}
}
