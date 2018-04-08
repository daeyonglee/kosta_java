import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class StandardInOutExample {
	public static void main(String[] args) throws IOException {
//		int data = System.in.read();
//		System.out.println((char)data);
		
		System.out.print("당신의 이름을 입력하세요 : ");
		/*
		byte[] buffer = new byte[20];
		int count = System.in.read(buffer);
		String name = new String(buffer, 0, count-2);
		*/
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String name = in.readLine();
		System.out.print("당신의 이름은 " + name +"이군요..");
	}
}
