package jdbcStudy;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * JDBC API를 이용한 Database 연동
 * @author 이대용
 *
 */
public class JDBCConnectionExample {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@localhost:1521:xe";
		String id     = "hr";
		String pwd    = "1234";
		
		// Oracle JDBC Driver 로드(동적 객체 생성)
		try {
			// newInstance()를 쓰지 않아도 내부적으로 자동 생성.
			Class.forName(driver).newInstance();
			System.out.println("JDBC 드라이버 로딩 완료..");
			// Oracle 연결
			// mySql Driver 로딩
			// Class.forName("com.mysql.jdbc.Driver").newInstance();
			// MS-SQL Driver 로딩
			// Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection(url, id, pwd);
			
			System.out.println(con);
			// mySql Connection
			// DriverManager.getConnection("jdbc:mysql://localhost:3306:SID", "UserId", "UserPw");

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
