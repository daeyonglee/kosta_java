import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * �ڹ� �����͸� ���ϴ� ��ġ�� ����Ʈ�� ���� �� �ִ� Stream
 * @author �̴��
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
