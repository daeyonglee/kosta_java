package memory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class MemoryStreamExample {
	public static void main(String[] args) throws IOException {
		String message = "����ľ��Ĥ��������Ĥ���Ͼ���\r\n�����ȳ����ȳĤ���";
		StringReader in = new StringReader(message);
		BufferedReader br = new BufferedReader(in);
		
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		
	}
}
