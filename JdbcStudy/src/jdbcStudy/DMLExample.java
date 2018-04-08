package jdbcStudy;

import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DML PreparedStatement 활용
 * @author 이대용
 *
 */
public class DMLExample {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@localhost:1521:xe";
		String id     = "hr";
		String pwd    = "1234";
		String sql    = "INSERT INTO departments(department_id, department_name, manager_id) "
				      + " VALUES (departments_seq.NEXTVAL, ?, ?)";
		
		String departmentName = "비비디바비디부";
		Integer managerId = 100;
		
		Connection con              = null;
		PreparedStatement pstmt     = null;
		ResultSet rs                = null;
		try {
//			Class.forName(driver).newInstance();
			
//			con   = DriverManager.getConnection(url, id, pwd);
			con = UserConnectionPool.getInstance().getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, departmentName);
			pstmt.setInt(2, managerId);
			int result = pstmt.executeUpdate();

			System.out.println(result + "건이 실행되었습니다.");
			
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			/*try {
				if (rs != null)    rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null)   con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
			try {
				if (con != null) UserConnectionPool.getInstance().releaseConnection(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}