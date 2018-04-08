package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcUserDao implements UserDao{
	
	ConnectionFactory factory;

	Connection con          = null;
	PreparedStatement pstmt = null;
	ResultSet rs            = null;
	
	public JdbcUserDao() {}
	
	
	public JdbcUserDao(ConnectionFactory factory) {
		this.factory = factory;
	}

	public ConnectionFactory getFactory() {
		return factory;
	}

	public void setFactory(ConnectionFactory factory) {
		this.factory = factory;
	}


	/** 사용자 등록 
	 * @throws Exception */
	public void create(User user) throws RuntimeException{
		
		String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
		
		try {
			con = factory.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPasswd());
			pstmt.setString(4, user.getEmail());
			
			pstmt.executeUpdate();
			
			con.commit();
			
			
		} catch (Exception e) {
			try {
				con.rollback();
				throw new RuntimeException("UserDao.create(User user) : " + e.toString());
			} catch (SQLException e1) {}
		} finally {
			close(null, pstmt, con);
		}
	}
	
	/** 아이디로 사용자 조회 
	 * @throws SQLException */
	public User read(String id) throws RuntimeException {
		
		String sql = "SELECT ID, NAME, PASSWD, EMAIL FROM USERS WHERE ID = ?";
		
		User user = null;
		try {
			con   = factory.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user = new User();
				user.setId(rs.getString("ID"));
				user.setName(rs.getString("NAME"));
				user.setPasswd(rs.getString("PASSWD"));
				user.setEmail(rs.getString("EMAIL"));
			}
			
		} catch (Exception e) {
			throw new RuntimeException("UserDao.read(String id) : " + e.toString());
		} finally {
			close(rs, pstmt, con);
		}
		
		return user;
	}

	/** 사용자 이름으로 검색 */
	public List<User> search(String name) throws RuntimeException {
		
		String sql = "SELECT ID, NAME, PASSWD, EMAIL FROM USERS WHERE NAME LIKE '%' || ? || '%'";
		List<User> list = new ArrayList<User>();
		
		try {
			con   = factory.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getString("ID"));
				user.setName(rs.getString("NAME"));
				user.setPasswd(rs.getString("PASSWD"));
				user.setEmail(rs.getString("EMAIL"));
				list.add(user);
			}
			
		} catch (Exception e) {
			throw new RuntimeException("UserDao.search(String name) : " + e.toString());
		} finally {
			close(rs, pstmt, con);
		}
		
		return list;
	}
	
	/** 사용자 전체 조회 */
	public List<User> listAll() throws RuntimeException{
		
		String sql = "SELECT ID, NAME, PASSWD, EMAIL FROM USERS";
		
		List<User> list = new ArrayList<User>();
		try {
			con = factory.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getString("ID"));
				user.setName(rs.getString("NAME"));
				user.setPasswd(rs.getString("PASSWD"));
				user.setEmail(rs.getString("EMAIL"));
				list.add(user);
			}
		} catch (Exception e) {
			throw new RuntimeException("UserDao.listAll() : " + e.toString());
		} finally {
			close(rs, pstmt, con);
		}
		
		return list;
	}
	
	/** 사용자 정보 수정 */
	public void update(User user) throws RuntimeException{
		
		String sql = "UPDATE USERS SET NAME = ?, PASSWD = ?, EMAIL = ? WHERE ID = ?";
		
		try {
			con = factory.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPasswd());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getId());
			
			pstmt.executeUpdate();
			
			con.commit();
			
		} catch (Exception e) {
			try {
				con.rollback();
				throw new RuntimeException("UserDao.update(User user) : " + e.toString());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	/** 사용자 정보 삭제 */
	public void delete(String id) throws RuntimeException{
		
		String sql = "DELETE FROM USERS WHERE ID = ?";
		
		try {
			con = factory.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
			con.commit();
		} catch (Exception e) {
			try {
				con.rollback();
				throw new RuntimeException("UserDao.delete(String id) : " + e.toString());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	public List<Map<String, Object>> employeeList() {
		
		String sql = "SELECT E.EMPLOYEE_ID" + 
					 "     , E.LAST_NAME" + 
					 "     , D.DEPARTMENT_ID" + 
					 "     , D.DEPARTMENT_NAME" + 
					 "  FROM EMPLOYEES E " + 
					 " INNER JOIN DEPARTMENTS D" + 
					 "    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID"; 
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = null;
		ResultSetMetaData rsmd = null;
		try {
			con   = factory.getConnection();
			pstmt = con.prepareStatement(sql);
			rs    = pstmt.executeQuery();
			rsmd = rs.getMetaData();
			System.out.println(rsmd.getColumnLabel(1) + "\t" + rsmd.getColumnLabel(2) + "\t" + rsmd.getColumnLabel(3) + "\t" + rsmd.getColumnLabel(4));
			System.out.println("====================================================");
			while(rs.next()) {
				map = new HashMap<String, Object>();
				map.put("user", new User(rs.getString("EMPLOYEE_ID"), rs.getString("LAST_NAME"), null, null));
				map.put("department_id", rs.getString("DEPARTMENT_ID"));
				map.put("department_name", rs.getString("DEPARTMENT_NAME"));
				list.add(map);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	
	private void close(ResultSet rs, PreparedStatement pstmt, Connection con) {
		try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		UserDao dao = new JdbcUserDao(new ConnectionFactory());
		try {
//			dao.create(new User("abcd1", "홍길동", "1234", "dd@dd.dd"));
//			System.out.println("사용자 등록 완료!");
//			List<User> list = dao.listAll();
//			for (User user : list) {
//				System.out.println(user);
//			}
//			dao.create(new User("abcd2", "임꺽정", "2345", "aa@aa.aa"));
//			dao.update(new User("abcd1", "이순신", "5555", "abc@abc.com"));
//			dao.delete("abcd1");
//			System.out.println(dao.read("abcd2"));
//			dao.create(new User("bbbb", "임꺽정", "6666", "apap@apap.com"));
			
//			List<User> list = dao.search("임꺽정");
//			
//			if (list.isEmpty()) {
//				System.out.println("등록된 사용자가 없습니다");
//			} else {
//				for (User user : list) {
//					System.out.println(user);
//				}
//			}
			
			List<Map<String, Object>> list = dao.employeeList();
			if (list.isEmpty()) {
				System.out.println("등록된 사원이 없습니다.");
			} else {
				for (Map<String, Object> map : list) {
					User user              = (User)map.get("user");
					String department_id   = (String)map.get("department_id");
					String department_name = (String)map.get("department_name");
					System.out.println(user.getId() + "\t" + user.getName() + "\t" + department_id + "\t" + department_name);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

