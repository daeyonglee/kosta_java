package character;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterExample {
	public static void main(String[] args) throws IOException {
		String file = "sample4.txt";
		String message = "요넘이 텍스트 데이터입니다.";
		
		PrintWriter out = new PrintWriter(new FileWriter(file));
		out.write(message);
		out.println("이대용");
		out.println("이대용");
		out.printf("%,-20d", 293490234);
		
		out.flush();
		out.close();
	}
}
