package jdbcStudy;

import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DQL Statement 활용
 * @author 이대용
 *
 */
public class DQLExample {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@localhost:1521:xe";
		String id     = "hr";
		String pwd    = "1234";
		String sql    = "SELECT employee_id, last_name, salary, to_char(hire_date, 'YYYY-MM-DD HH24:MI:SS DAY') as hire_date";
			   sql   += "  FROM employees";
		
		Connection con      = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			Class.forName(driver).newInstance();
			
			con       = DriverManager.getConnection(url, id, pwd);
			statement = con.createStatement();
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				Integer employeeId = resultSet.getInt("employee_id");
				String lastName    = resultSet.getString("last_name");
				Integer salary     = resultSet.getInt("salary");
				String hireDate    = resultSet.getString("hire_date");
				System.out.println(employeeId + "\t" + lastName + "\t" + salary + "\t" + hireDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) resultSet.close();
				if (statement != null) statement.close();
				if (con != null)       con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}