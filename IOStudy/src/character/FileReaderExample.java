package character;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class FileReaderExample {
	public static void main(String[] args) {
//		String path = "E:\\kosta178\\��ġ���α׷�\\jdk-9.0.4_windows-x64_bin.exe";
		String path = "src/OutputStreamExample.java";
		
		Reader in = null;
		
		try {
			in = new FileReader(path);
			
//			int data = in.read();
//			System.out.println((char)data);
			
			char[] buffer = new char[1024];
			
			int count = 0;
			while((count=in.read(buffer)) != -1) {
				//���� ���ڵ� ó��
				String txt = new String(buffer, 0, count);
				System.out.print(txt);
			}
			
			/*
			int byteDate=0;
			while((byteDate = in.read()) != -1) {
				System.out.println(byteDate);
			}
			*/
			
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
