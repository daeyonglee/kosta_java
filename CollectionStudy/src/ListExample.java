import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/**
 * ������ �ְ� �ߺ��� �����͸� ����ϴ� Ư¡�� �ڷᱸ��
 * @author �̴��
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
		
		String name = "�̴��";
		Integer in  = new Integer(100);
		Calendar today = Calendar.getInstance();
		Bicycle bicycle = new Bicycle(10, "��õ��", "ī��");
		String[] array = {"����", "����", "����"};
		
		// AutoBoxing
		set.add(age);
		set.add(weight);
		set.add(name);
		set.add(in);
		set.add(today);
		set.add(bicycle);
		set.add(array);
		set.add("�̴��");	// �ߺ����
		
		System.out.println(set.isEmpty());
		System.out.println(set.size());
		
		// ��ü��� ��ȯ
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
		
		// �˻�
		System.out.println(set.contains("�̴��"));
		System.out.println(set.remove("�̴��"));
		System.out.println(set.size());
		set.clear();
	}
}
