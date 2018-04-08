import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class Mission {
	public static void main(String[] args) {
		// ���� �����Ÿ� ���� ��Ƴ��� �;� ��򰡿�.
		// �����Ŵ� �������� �־ ��
		// �׷��� Set�� �����ž�
		Set<Bicycle> set = new HashSet<Bicycle>();
		
		set.add(new Bicycle(10, "��õ��", "��ö"));
		set.add(new Bicycle(11, "��õ��", "ī��"));
		set.add(new Bicycle(10, "��õ��", "��ö"));
		
		System.out.println(set.size());
		
		set.forEach(new Consumer<Bicycle>() {
			@Override
			public void accept(Bicycle t) {
				System.out.println(t);
			}
		});
		
	}
}
