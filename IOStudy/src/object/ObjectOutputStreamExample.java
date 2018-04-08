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
		
		String message = "오늘 수업 끝입니다.";
		Calendar now = Calendar.getInstance();
		Account account = new Account("1111", "이대용", 1234, 1234);
		
		oos.writeObject(message);
		oos.writeObject(now);
		oos.writeObject(account);
		
		oos.flush();
		oos.close();
		
		System.out.println("파일에 객체 저장 완료");
	}
}
