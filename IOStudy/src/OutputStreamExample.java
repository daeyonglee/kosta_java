import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamExample {
	public static void main(String[] args) throws IOException {

		String path = "sample.dat";
		
		OutputStream out = null;
		out = new FileOutputStream(path, true);
		
		byte date = 127;
		out.write(date);
		byte[] array = new byte[127];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = (byte)i;
		}
		
		out.write(array);
		
		out.close();
		
		System.out.println(path + "파일에 데이터 출력 완료..");
		
	}
}
