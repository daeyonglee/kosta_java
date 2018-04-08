import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Vector;

/**
 * Class�� �̿��Ͽ� ���� ��ü(�ν��Ͻ�) ����
 * 
 * @author �����
 *
 */
public class ClassExample3 {

	public static void main(String[] args) {
//		String className = "java.lang.String";
		
		Object object = null;		
		try {
//			Class cls = Class.forName(className);
			Class cls = String.class;
			
			// �Ű����� �ִ� ������ ȣ��
			Constructor constructor = cls.getConstructor(String.class);
			object = constructor.newInstance("������ü����");
			System.out.println(object instanceof String);
			System.out.println(((String)object).length());
			
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}

}
