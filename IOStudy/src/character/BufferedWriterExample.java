package character;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterExample {
	public static void main(String[] args) throws IOException {
		String file = "sample4.txt";
		String message = "요넘이 텍스트 데이터입니다.";
		
		BufferedWriter out = new BufferedWriter(new FileWriter(file));
		out.write(message);
		
		out.flush();
		out.close();
	}
}
