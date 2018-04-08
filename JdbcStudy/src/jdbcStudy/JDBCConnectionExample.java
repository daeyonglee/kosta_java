package jdbcStudy;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * JDBC API�� �̿��� Database ����
 * @author �̴��
 *
 */
public class JDBCConnectionExample {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@localhost:1521:xe";
		String id     = "hr";
		String pwd    = "1234";
		
		// Oracle JDBC Driver �ε�(���� ��ü ����)
		try {
			// newInstance()�� ���� �ʾƵ� ���������� �ڵ� ����.
			Class.forName(driver).newInstance();
			System.out.println("JDBC ����̹� �ε� �Ϸ�..");
			// Oracle ����
			// mySql Driver �ε�
			// Class.forName("com.mysql.jdbc.Driver").newInstance();
			// MS-SQL Driver �ε�
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
