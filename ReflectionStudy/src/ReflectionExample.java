import java.lang.reflect.Method;

public class ReflectionExample {

	public static void main(String[] args) throws ClassNotFoundException {
		String message = "리플렉션이 뭐예요???";
		
		//Class cls = message.getClass();
		Class cls = Class.forName("java.lang.String");
		String className = cls.getName();
		System.out.println(className);
		
		Method[] methodList = cls.getMethods();
		for (Method method : methodList) {
//			System.out.println(method.getName());
//			System.out.println(method);
//			System.out.println(method);
//			System.out.println(method.getModifiers());
//			System.out.println(method.getModifiers() == Method.PUBLIC);
			Class[] params = method.getParameterTypes();
			if(params != null) {
				for (Class paramType : params) {
					System.out.print(method.getName() + paramType.getName() + ",");					
				}		
			}
			
		}

	}

}
