import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP주소 추상화 클래스
 * @author 이대용
 *
 */
public class InetAddressExample {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress address = InetAddress.getLocalHost();
		
		System.out.println(address.getHostName());
		System.out.println(address.getHostAddress());
		
		String domainName = "www.naver.com";
		domainName = "www.daum.net";
		address = address.getByName(domainName);
		
		System.out.println(address.getHostAddress());
		
		InetAddress[] a = InetAddress.getAllByName(domainName);
		for (InetAddress inetAddress : a) {
			System.out.println(inetAddress);
		}
	}
}
