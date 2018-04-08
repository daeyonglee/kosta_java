import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLExample {
	public static void main(String[] args){
		String urlString = "https://www.naver.com/index.html";
		
		URL url = null;
		InputStream in = null;
		try {
			url = new URL(urlString);
			System.out.println(url.getHost());
			System.out.println(url.getFile());
		 
			// url���� ���� ��������.
			in = url.openStream();
			System.out.println(in);
			// ��Ʈ��ũ�� 1��Ŷ ������ �ϴ°� ���� ����.
					
			BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			String line=null;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
		} catch (MalformedURLException e) {
			System.out.println("�������� �ʴ� �ּ��Դϴ�.");
		} catch (IOException e) {
			System.out.println("��Ʈ��ũ ���¸� Ȯ���Ͽ� �ּ���.");
		} finally {
			try {
				if (in != null) in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
