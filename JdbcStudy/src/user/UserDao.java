package user;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UserDao {
	
	
	/** 사용자 등록 
	 * @throws Exception */
	public void create(User user) throws RuntimeException;
	
	/** 아이디로 사용자 조회 
	 * @throws SQLException */
	public User read(String id) throws RuntimeException;

	/** 사용자 이름으로 검색 */
	public List<User> search(String name) throws RuntimeException;
	
	/** 사용자 전체 조회 */
	public List<User> listAll() throws RuntimeException;
	
	/** 사용자 정보 수정 */
	public void update(User user) throws RuntimeException;
	
	/** 사용자 정보 삭제 */
	public void delete(String id) throws RuntimeException;
	
	public List<Map<String, Object>> employeeList();
}
