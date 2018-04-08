package user;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UserDao {
	
	
	/** ����� ��� 
	 * @throws Exception */
	public void create(User user) throws RuntimeException;
	
	/** ���̵�� ����� ��ȸ 
	 * @throws SQLException */
	public User read(String id) throws RuntimeException;

	/** ����� �̸����� �˻� */
	public List<User> search(String name) throws RuntimeException;
	
	/** ����� ��ü ��ȸ */
	public List<User> listAll() throws RuntimeException;
	
	/** ����� ���� ���� */
	public void update(User user) throws RuntimeException;
	
	/** ����� ���� ���� */
	public void delete(String id) throws RuntimeException;
	
	public List<Map<String, Object>> employeeList();
}
