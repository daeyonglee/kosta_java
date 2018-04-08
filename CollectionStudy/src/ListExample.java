import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/**
 * 순서가 있고 중복된 데이터를 허용하는 특징의 자료구조
 * @author 이대용
 *
 */
public class ListExample {
	public static void main(String[] args) {
		List set = new ArrayList();
		List<String> list2 = new ArrayList<String>();
		
		list2.add("asdasd");
//		list2.add(123123);
		
		int age = 51;
		double weight = 72.65;
		
		String name = "이대용";
		Integer in  = new Integer(100);
		Calendar today = Calendar.getInstance();
		Bicycle bicycle = new Bicycle(10, "삼천리", "카본");
		String[] array = {"세준", "종찬", "성민"};
		
		// AutoBoxing
		set.add(age);
		set.add(weight);
		set.add(name);
		set.add(in);
		set.add(today);
		set.add(bicycle);
		set.add(array);
		set.add("이대용");	// 중복허용
		
		System.out.println(set.isEmpty());
		System.out.println(set.size());
		
		// 전체목록 반환
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Object obj = it.next();
			
			if (obj instanceof String[]) {
				String[] list = (String[])obj;
				for(String n : list) System.out.println(n+",");
			}
			System.out.println(obj);
			
		}
		
		for (Object o : set) {
			System.out.println(o);
		}
		
		// 검색
		System.out.println(set.contains("이대용"));
		System.out.println(set.remove("이대용"));
		System.out.println(set.size());
		set.clear();
	}
}
