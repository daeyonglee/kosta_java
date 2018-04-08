import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamExample {
	public static void main(String[] args) {
		String path = "E:\\kosta178\\설치프로그램\\jdk-9.0.4_windows-x64_bin.exe";
		
		InputStream in = null;
		try {
			in = new FileInputStream(path);
			//byte[] buffer = new byte[1024*4];
			/*in.read(buffer);
			for (byte b : buffer) {
				System.out.println(b);
			}*/
			
			// 읽어 들일 수 있는 파일 크기
			System.out.println(in.available());
			
			
			int byteDate = 0;
			while((byteDate=in.read()) != -1) {
				System.out.println(byteDate);
			}
			
			/*
			int byteDate=0;
			while((byteDate = in.read()) != -1) {
				System.out.println(byteDate);
			}
			*/
		} catch (FileNotFoundException e) {
			System.out.println("읽고자 하는 파일이 존재하지 않습니다.");
		} catch (IOException e) {
			System.out.println("파일을 읽는데 문제가 발생하였습니다.");
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
