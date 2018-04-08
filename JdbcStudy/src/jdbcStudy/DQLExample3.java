package jdbcStudy;

import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DQL PreparedStatement 활용
 * @author 이대용
 *
 */
public class DQLExample3 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@localhost:1521:xe";
		String id     = "hr";
		String pwd    = "1234";
		String sql    = "SELECT employee_id, last_name, salary, to_char(hire_date, 'YYYY-MM-DD HH24:MI:SS DAY') as hire_date";
		       sql   += "  FROM employees";
		       sql   += " WHERE last_name = ?";
		       
		String searchValue = "Lee";
		
		Connection con              = null;
		PreparedStatement pstmt     = null;
		ResultSet rs                = null;
		try {
			Class.forName(driver).newInstance();
			
			con   = DriverManager.getConnection(url, id, pwd);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, searchValue);
			rs    = pstmt.executeQuery();
			
			while(rs.next()) {
				Integer employeeId   = rs.getInt("employee_id");
				String lastName      = rs.getString("last_name");
				Integer salary       = rs.getInt("salary");
				String hireDate      = rs.getString("hire_date");
				System.out.println(employeeId + "\t" + lastName + "\t" + salary + "\t" + hireDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)    rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null)   con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}