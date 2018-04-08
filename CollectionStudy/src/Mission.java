import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class Mission {
	public static void main(String[] args) {
		// 내가 자전거를 많이 담아놓고 싶어 어딘가에.
		// 자전거는 순서없이 넣어도 됨
		// 그래서 Set에 담을거야
		Set<Bicycle> set = new HashSet<Bicycle>();
		
		set.add(new Bicycle(10, "삼천리", "강철"));
		set.add(new Bicycle(11, "삼천리", "카본"));
		set.add(new Bicycle(10, "삼천리", "강철"));
		
		System.out.println(set.size());
		
		set.forEach(new Consumer<Bicycle>() {
			@Override
			public void accept(Bicycle t) {
				System.out.println(t);
			}
		});
		
	}
}
