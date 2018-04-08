import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Calendar;

/**
 * 자바의 모든 데이터를 문자열로 변환하여 출력
 * @author 이대용
 *
 */
public class PrintStreamExample {
	public static void main(String[] args) throws IOException {
		String path = "sample2.dat";
		
		PrintStream out = new PrintStream(new FileOutputStream(path));
		
		char ch = '김';
		int passwd = 1111;
		long money = 98172389213L;
		double weight = 45.677;
		String accountNum = "1111-2222-3333";
		
		out.print(ch);
		out.print(passwd);
		out.print(money);
		out.print(weight);
		out.print(accountNum);
		out.println();
		out.printf("%1$tF %1$tT", Calendar.getInstance());

		System.out.println(ch);
		System.out.println(passwd);
		System.out.println(money);
		System.out.println(weight);
		System.out.println(accountNum);
		
		out.close();
		
		System.out.println("파일에 데이터 입력 완료!");
	}
}
