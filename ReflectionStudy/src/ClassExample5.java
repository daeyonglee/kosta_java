import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Method�� �̿��Ͽ� ���� �޼ҵ� ȣ��
 * 
 * @author �����
 *
 */
public class ClassExample5 {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String methodName = "substring";
		
		String str = "Hello World";
//		str.length();
		
		Class cls = String.class;
		Method method =  cls.getMethod(methodName, int.class,  int.class);
		// �Ű����� ���� �޼ҵ� ȣ��
		Object ret = method.invoke(str, 6, 11);
		System.out.println(ret);
	}
}
