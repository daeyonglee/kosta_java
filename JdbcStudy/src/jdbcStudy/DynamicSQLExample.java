package jdbcStudy;

import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 동적 SQL 실행
 * PreparedStatement 활용
 * @author 이대용
 *
 */
public class DynamicSQLExample {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@localhost:1521:xe";
		String id     = "hr";
		String pwd    = "1234";
		String sql    = "SELECT employee_id, last_name, salary, to_char(hire_date, 'YYYY-MM-DD HH24:MI:SS DAY') as hire_date";
		   	   sql   += "  FROM employees";
		
		/*String sql    = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME = '유어마이부' "
				      + "WHERE DEPARTMENT_ID = 300";*/
		
		String departmentName = "비비디바비디부";
		Integer managerId = 100;
		
		Connection con              = null;
		PreparedStatement pstmt     = null;
		ResultSet rs                = null;
		// 컬럼정보 가져올때 사용하는 인터페이스
		ResultSetMetaData rsmd      = null;
		try {
			Class.forName(driver).newInstance();
			
			con   = DriverManager.getConnection(url, id, pwd);
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(sql);
			
			// 리턴이 true면 Select문을, false면 update,insert,delete가 실행되었음.
			boolean rsExist = pstmt.execute();
			
			if (rsExist) {
				rs = pstmt.getResultSet();
				rsmd = rs.getMetaData();
				String hid       = rsmd.getColumnLabel(1);
				String hname     = rsmd.getColumnLabel(2);
				String hsalary   = rsmd.getColumnLabel(3);
				String hhireDate = rsmd.getColumnLabel(4);
				System.out.println(hid + "\t" + hname + "\t" + hsalary + "\t" + hhireDate + "\t");
				System.out.println("==========================================================");
				while(rs.next()) {
					Integer employeeId   = rs.getInt("employee_id");
					String lastName      = rs.getString("last_name");
					Integer salary       = rs.getInt("salary");
					String hireDate      = rs.getString("hire_date");
					System.out.println(employeeId + "\t" + lastName + "\t" + salary + "\t" + hireDate);
				}
			} else {
				int count = pstmt.getUpdateCount();
				System.out.println(count+"건이 실행되었습니다.");
			}
			
			con.commit();
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