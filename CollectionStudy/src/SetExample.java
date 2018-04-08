import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 순서가 없고 중복된 데이터를 허용하지 않는 특징의 자료구조
 * @author 이대용
 *
 */
public class SetExample {
	public static void main(String[] args) {
		List list = new ArrayList();
		Set<String> set2 = new HashSet<String>();
		set2.add("abc");
//		set2.add(new Integer(123213));
		int age = 51;
		double weight = 72.65;
		
		String name = "이대용";
		Integer in  = new Integer(100);
		Calendar today = Calendar.getInstance();
		Bicycle bicycle = new Bicycle(10, "삼천리", "카본");
		String[] array = {"세준", "종찬", "성민"};
		
		// AutoBoxing
		list.add(age);
		list.add(weight);
		list.add(name);
		list.add(in);
		list.add(today);
		list.add(bicycle);
		list.add(array);
		list.add("이대용");
		
		list.add(list.size()-1, "이대용");
		list.set(0, "이대용");
		
		System.out.println(list.get(0));
		System.out.println(list.remove(0));
		
		System.out.println(list.isEmpty());
		System.out.println(list.size());
		
		// 전체목록 반환
		Iterator it = list.iterator();
		while(it.hasNext()) {
			Object obj = it.next();
			
			if (obj instanceof String[]) {
				String[] l = (String[])obj;
				for(String n : l) System.out.println(n+",");
			}
			System.out.println(obj);
			
		}
		
		for (Object o : list) {
			System.out.println(o);
		}
		
		// 검색
		System.out.println(list.contains("이대용"));
		System.out.println(list.remove("이대용"));
		System.out.println(list.size());
		list.clear();
	}
}
