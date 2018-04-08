import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * Key�� Value�� ������ ������ ����
 * @author �̴��
 *
 */
public class MapExample {
	public static void main(String[] args) {
		Map<String, Student<String>> map = new HashMap<String, Student<String>>();
		
		map.put("010-8376-8171", new Student<String>("�̴��", "201734-358335"));
		map.put("010-1234-5678", new Student<String>("������", "2010934503472"));
		
		System.out.println(map.get("010-8376-8171"));
		
		if (map.containsKey("010-1234-5678")) {
			System.out.println("������ �̹� ���� ���Դ�");
		} else {
			map.put("010-1234-5678", new Student<String>("������2", "74598275927598"));
		}
		System.out.println(map.get("010-1234-5678"));
		
		Iterator it = map.entrySet().iterator();
		
		while(it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
		
		Hashtable<String, String> ht = new Hashtable<String, String>();
		
		ht.put("1111", "�̴��");
		ht.put("2222", "��浿");
		
		ht.elements();
	}
}
