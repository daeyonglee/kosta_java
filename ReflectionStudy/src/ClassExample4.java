import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Method�� �̿��Ͽ� ���� �޼ҵ� ȣ��
 * 
 * @author �����
 *
 */
public class ClassExample4 {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String methodName = "length";
		String substring = "substring";
		String str = "Hello World";
//		str.length();
		
		Class cls = String.class;
		Method method =  cls.getMethod(methodName, null);
		Method method2 = cls.getMethod("concat", String.class);
		// �Ű����� ���� �޼ҵ� ȣ��
		Object ret = method.invoke(str, null);
		Object ret2 = method2.invoke(str, " ����!!");
		System.out.println(ret instanceof Integer);
		System.out.println(ret);
		System.out.println(ret2);
	}

}
