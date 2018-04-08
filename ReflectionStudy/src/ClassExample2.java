import java.util.Vector;

/**
 * Class�� �̿��Ͽ� ���� ��ü(�ν��Ͻ�) ����
 * 
 * @author �����
 *
 */
public class ClassExample2 {

	public static void main(String[] args) {
		String className = "java.util.Vector";
		
		Object object = null;		
		try {
			Class cls = Class.forName(className);
			// ����Ʈ������ ȣ��
			object = cls.newInstance();
			System.out.println(object instanceof Vector);
			
			// �ʿ信 ���� Down Casting
			Vector vector = (Vector)object;
			vector.addElement("���� ��ü ����");
			System.out.println(vector.elementAt(0));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

}
