import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * �ڹ� �⺻������Ÿ��(8��)���� �� �� �ִ� ��� ������ ���ͽ�Ʈ��
 * @author �̴��
 *
 */
public class DataOutputStreamExample {
	public static void main(String[] args) throws IOException {
		String path = "sample2.dat";
		
		DataOutputStream out = new DataOutputStream(new FileOutputStream(path));
		
		char ch = '��';
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
		
		System.out.println("���Ͽ� ������ ��� �Ϸ�!");
	}
}
