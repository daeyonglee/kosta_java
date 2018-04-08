import java.awt.Point;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Field를 이용하여 동적 필드값 읽기
 * 
 * @author 김기정
 *
 */
public class ClassExample6 {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Point point = new Point(50, 50);
//		point.x;
		
		Class cls = Point.class;
		Class cls2 = Integer.class;
		Field field = cls.getField("x");
		Field field2 = cls2.getField("MAX_VALUE");
		Object x = field.get(point);
		Object x2 = field2.get(Integer.class);
		System.out.println(x.toString());
		System.out.println(x2.toString());
		System.out.println(Integer.MAX_VALUE);
	}
	

}
