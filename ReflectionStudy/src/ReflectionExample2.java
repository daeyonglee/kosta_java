import java.lang.reflect.Method;
import java.util.Random;

public class ReflectionExample2 {

	public static void main(String[] args) throws ClassNotFoundException {
		Class cls = Class.forName("java.util.Vector");
		System.out.println(cls.getName());
		System.out.println(cls.getSimpleName());
		
		Class cls2 = Random.class;
		System.out.println(cls2);
		System.out.println(cls2.getSuperclass());

	}

}
