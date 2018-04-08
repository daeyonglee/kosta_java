import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * ������ �ְ� �ߺ��� �����͸� ����ϴ� Ư¡�� �ڷᱸ��
 * ����ȭ ó�� �ڷᱸ��
 * @author �̴��
 *
 */
public class VectorExample {
	public static void main(String[] args) {
		// �⺻ �뷮�� ũ��, �⺻ �뷮 �̻� ��Ұ� �߰��� ��� �뷮�� 2��� �þ�Ƿ�
		// ���� �� ������� ũ���� �뷮�� �߰��� ����� �þ�� ũ�⸦ �������ִ°� ����.
		Vector vec = new Vector(10, 2);
		Vector<Integer> vector3 = new Vector<Integer>();
		
		int age = 51;
		double weight = 72.65;
		
		String name = "�̴��";
		Integer in  = new Integer(100);
		Calendar today = Calendar.getInstance();
		Bicycle bicycle = new Bicycle(10, "��õ��", "ī��");
		String[] array = {"����", "����", "����"};
		
		// AutoBoxing
		vec.addElement(age);
		vec.addElement(weight);
		vec.addElement(name);
		vec.addElement(in);
		vec.addElement(today);
		vec.addElement(bicycle);
		vec.addElement(array);
		vec.addElement("�̴��");	// �ߺ����
		
		vec.setElementAt("�̴��", 0);
		
		System.out.println(vec.elementAt(0));
		System.out.println(vec.removeElement(0));
		
		// ��ü��� ��ȯ
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
		
		// �˻�
		System.out.println(vec.contains("�̴��"));
		System.out.println(vec.remove("�̴��"));
		System.out.println(vec.size());
		vec.clear();
	}
}
