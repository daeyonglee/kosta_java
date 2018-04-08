import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * ������ ���� �ߺ��� �����͸� ������� �ʴ� Ư¡�� �ڷᱸ��
 * @author �̴��
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
		
		String name = "�̴��";
		Integer in  = new Integer(100);
		Calendar today = Calendar.getInstance();
		Bicycle bicycle = new Bicycle(10, "��õ��", "ī��");
		String[] array = {"����", "����", "����"};
		
		// AutoBoxing
		list.add(age);
		list.add(weight);
		list.add(name);
		list.add(in);
		list.add(today);
		list.add(bicycle);
		list.add(array);
		list.add("�̴��");
		
		list.add(list.size()-1, "�̴��");
		list.set(0, "�̴��");
		
		System.out.println(list.get(0));
		System.out.println(list.remove(0));
		
		System.out.println(list.isEmpty());
		System.out.println(list.size());
		
		// ��ü��� ��ȯ
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
		
		// �˻�
		System.out.println(list.contains("�̴��"));
		System.out.println(list.remove("�̴��"));
		System.out.println(list.size());
		list.clear();
	}
}
