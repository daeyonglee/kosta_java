import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamExample2 {
	public static void main(String[] args) {
//		String path = "E:\\kosta178\\��ġ���α׷�\\jdk-9.0.4_windows-x64_bin.exe";
		String path = "src/OutputStreamExample.java";
		
		InputStream in = null;
		try {
			in = new FileInputStream(path);
			byte[] buffer = new byte[1024*4];
			/*in.read(buffer);
			for (byte b : buffer) {
				System.out.println(b);
			}*/
			
			int count = 0;
			while((count=in.read(buffer)) != -1) {
				for (int i = 0; i < count; i++) {
					System.out.println(buffer[i]);
				}
			}
			System.out.println("������ �Է� �Ϸ�");
			
		} catch (FileNotFoundException e) {
			System.out.println("�а��� �ϴ� ������ �������� �ʽ��ϴ�.");
		} catch (IOException e) {
			System.out.println("������ �дµ� ������ �߻��Ͽ����ϴ�.");
		} finally {
			try {
				if (in != null) in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
