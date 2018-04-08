import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * FileInputStream�� FileOutputStream�� Ȱ���� ���� ����
 * @author �̴��
 *
 */
public class FileCopy {
	public static long copy(String src, String dest) {
		
		InputStream in = null;
		OutputStream out = null;
		BufferedOutputStream bout = null;
		int inSize = 0;
		long rtSize = 0;
		
		File file = new File(src);
		
		try {
			in = new FileInputStream(src);
			out = new FileOutputStream(dest);
			bout = new BufferedOutputStream(out);
			
			if (!file.exists()) throw new FileNotFoundException("������ ������.");
			
			rtSize = in.available();
			byte[] bf = new byte[1024*4];
			while((inSize = in.read(bf)) != -1) {
				bout.write(bf, 0, inSize);
			};
		} catch (FileNotFoundException e) {
			System.out.println("�а��� �ϴ� ������ �������� �ʽ��ϴ�.");
		} catch (IOException e) {
			System.out.println("������ �дµ� ������ �߻��Ͽ����ϴ�.");
		} finally {
			try {
				out.close();
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return rtSize;
	}
	
	public static void main(String[] args) {
		String src = "E:\\kosta178\\��ġ���α׷�\\jdk-8u161-windows-x64.exe";
		String dest = "jdk-8u161-windows-x64_copy.exe";
		
		long copySize = copy(src, dest);
		System.out.println(copySize + "����Ʈ�� ����Ǿ����ϴ�.");
	}
}
