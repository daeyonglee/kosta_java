import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 자바 데이터를 원하는 위치의 바이트를 읽을 수 있는 Stream
 * @author 이대용
 *
 */
public class BufferedInputStreamExample {
	public static void main(String[] args) throws IOException {
		String path = "src/DataInputStreamExample.java";
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(path));
		
		in.mark(0);
		int data = in.read();
		data = in.read();
		System.out.println(data);
		in.reset();
		data = in.read();
		System.out.println(data);
		in.skip(100);
		data = in.read();
		System.out.println(data);
		
		in.close();
	}
}
