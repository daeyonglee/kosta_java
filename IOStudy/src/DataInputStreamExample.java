import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 자바 기본데이터타입(8개)별로 읽을 수 있는 기능 제공의 필터스트림
 * @author 이대용
 *
 */
public class DataInputStreamExample {
	public static void main(String[] args) throws IOException {
		String path = "sample2.dat";
		
//		DataOutputStream out = new DataOutputStream(new FileOutputStream(path));
		DataInputStream in = new DataInputStream(new FileInputStream(path));
		
		char ch = 0;
		int passwd = 0;
		long money = 0L;
		double weight = 0.0;
		String accountNum = null;
		
		ch = in.readChar();
		passwd = in.readInt();
		money = in.readLong();
		weight = in.readDouble();
		accountNum = in.readUTF();

		System.out.println(ch);
		System.out.println(passwd);
		System.out.println(money);
		System.out.println(weight);
		System.out.println(accountNum);
		
		in.close();
		
		System.out.println("파일에 데이터 입력 완료!");
	}
}
