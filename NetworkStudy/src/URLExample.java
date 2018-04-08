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
		 
			// url에서 정보 가져오기.
			in = url.openStream();
			System.out.println(in);
			// 네트워크는 1패킷 단위로 하는게 가장 좋다.
					
			BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			String line=null;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
		} catch (MalformedURLException e) {
			System.out.println("존재하지 않는 주소입니다.");
		} catch (IOException e) {
			System.out.println("네트워크 상태를 확인하여 주세요.");
		} finally {
			try {
				if (in != null) in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
