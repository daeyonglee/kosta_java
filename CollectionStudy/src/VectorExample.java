import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * 순서가 있고 중복된 데이터를 허용하는 특징의 자료구조
 * 동기화 처리 자료구조
 * @author 이대용
 *
 */
public class VectorExample {
	public static void main(String[] args) {
		// 기본 용량이 크고, 기본 용량 이상 요소가 추가될 경우 용량이 2배로 늘어나므로
		// 생성 시 어느정도 크기의 용량과 추가될 경우의 늘어나는 크기를 지정해주는게 좋다.
		Vector vec = new Vector(10, 2);
		Vector<Integer> vector3 = new Vector<Integer>();
		
		int age = 51;
		double weight = 72.65;
		
		String name = "이대용";
		Integer in  = new Integer(100);
		Calendar today = Calendar.getInstance();
		Bicycle bicycle = new Bicycle(10, "삼천리", "카본");
		String[] array = {"세준", "종찬", "성민"};
		
		// AutoBoxing
		vec.addElement(age);
		vec.addElement(weight);
		vec.addElement(name);
		vec.addElement(in);
		vec.addElement(today);
		vec.addElement(bicycle);
		vec.addElement(array);
		vec.addElement("이대용");	// 중복허용
		
		vec.setElementAt("이대용", 0);
		
		System.out.println(vec.elementAt(0));
		System.out.println(vec.removeElement(0));
		
		// 전체목록 반환
		Enumeration e = vec.elements();
		
		while(e.hasMoreElements()) {
			Object obj = e.nextElement();
			
			if (obj instanceof String) {
				String[] arr = (String[])obj;
			}
		}
		
		/*for (Object o : vec) {
			System.out.println(o);
		}*/
		
		// 검색
		System.out.println(vec.contains("이대용"));
		System.out.println(vec.remove("이대용"));
		System.out.println(vec.size());
		vec.clear();
	}
}
