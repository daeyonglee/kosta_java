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
public class DQLExample2 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@localhost:1521:xe";
		String id     = "hr";
		String pwd    = "1234";
		String sql    = "SELECT E.EMPLOYEE_ID" + 
						"     , E.FIRST_NAME" + 
						"     , D.DEPARTMENT_ID" + 
						"     , L.CITY" + 
						"  FROM DEPARTMENTS D INNER JOIN LOCATIONS L" + 
						"    ON D.LOCATION_ID = L.LOCATION_ID" + 
						" INNER JOIN EMPLOYEES E" + 
						"    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID" + 
						" WHERE L.CITY = 'London'";
		
		Connection con      = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			Class.forName(driver).newInstance();
			
			con       = DriverManager.getConnection(url, id, pwd);
			statement = con.createStatement();
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				Integer employeeId   = resultSet.getInt("EMPLOYEE_ID");
				String firstName     = resultSet.getString("FIRST_NAME");
				Integer departmentId = resultSet.getInt("DEPARTMENT_ID");
				String city          = resultSet.getString("CITY");
				System.out.println(employeeId + "\t" + firstName + "\t" + departmentId + "\t" + city);
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