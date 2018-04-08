package memory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class MemoryStreamExample {
	public static void main(String[] args) throws IOException {
		String message = "¸à¾ö³Ä¾ö³Ä¤À¾ö³»¾ö³Ä¤À¾î¸Ï¾ö¤¤\r\n¤±³»¿È³»¤Á¿È³Ä¤À¤·";
		StringReader in = new StringReader(message);
		BufferedReader br = new BufferedReader(in);
		
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		
	}
}
