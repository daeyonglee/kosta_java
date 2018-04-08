import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Method를 이용하여 동적 메소드 호출
 * 
 * @author 김기정
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
		// 매개변수 없는 메소드 호출
		Object ret = method.invoke(str, null);
		Object ret2 = method2.invoke(str, " 만세!!");
		System.out.println(ret instanceof Integer);
		System.out.println(ret);
		System.out.println(ret2);
	}

}
