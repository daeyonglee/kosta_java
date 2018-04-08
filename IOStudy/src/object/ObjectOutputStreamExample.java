package object;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Calendar;

public class ObjectOutputStreamExample {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String path = "sample6.ser";
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
		
		String message = "���� ���� ���Դϴ�.";
		Calendar now = Calendar.getInstance();
		Account account = new Account("1111", "�̴��", 1234, 1234);
		
		oos.writeObject(message);
		oos.writeObject(now);
		oos.writeObject(account);
		
		oos.flush();
		oos.close();
		
		System.out.println("���Ͽ� ��ü ���� �Ϸ�");
	}
}
