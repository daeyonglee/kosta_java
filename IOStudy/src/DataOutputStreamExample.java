import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 자바 기본데이터타입(8개)별로 쓸 수 있는 기능 제공의 필터스트림
 * @author 이대용
 *
 */
public class DataOutputStreamExample {
	public static void main(String[] args) throws IOException {
		String path = "sample2.dat";
		
		DataOutputStream out = new DataOutputStream(new FileOutputStream(path));
		
		char ch = '김';
		int passwd = 1111;
		long money = 98172389213L;
		double weight = 45.677;
		String accountNum = "1111-2222-3333";
		
		out.writeChar(ch);
		out.writeInt(passwd);
		out.writeLong(money);
		out.writeDouble(weight);
		out.writeUTF(accountNum);
		
		out.close();
		
		System.out.println("파일에 데이터 출력 완료!");
	}
}
