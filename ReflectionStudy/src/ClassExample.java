import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Class�� �̿��Ͽ� Ŭ���� ���� �پ��� ���� ���
 * 
 * @author �����
 *
 */
public class ClassExample {
	
	public void exampleMethod() {
		System.out.println("exampleMethod ����");
	}

	public static void main(String[] args) {
		try {
			Class cls = Class.forName("ClassExample");
			System.out.println("----- ����Ŭ���� ��� -----");
			Class supercls = cls.getSuperclass();
			System.out.println(supercls.toString());
			
			System.out.println("----- ������ ��� -----");
			Constructor[] cons =  cls.getConstructors();
			for (Constructor constructor : cons) {
				System.out.println(constructor.toString());
			}
			
			System.out.println("----- �޼ҵ� ��� -----");
			Method[] methods = cls.getMethods();
			for (Method method : methods) {
				System.out.println(method.toString());
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
