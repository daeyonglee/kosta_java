package pattern;

/**
 * 싱글톤 패턴 적용 로그 기록 클래스
 * @author 이대용
 *
 */
public class Logger {
	
	private static Logger instance;
	
	private Logger() {
		
	}
	
	public static Logger getInstance() {
		
		if (instance == null) {
			synchronized (Logger.class) {
				instance = new Logger();
			}
		}
		return instance;
	}
	
	public void log(String message) {
		System.out.println(message);
	}
	
	public static void main(String[] args) {
		Logger logger = Logger.getInstance();
		
		logger.log("이것이 싱글톤이다");
		
		System.out.println(logger.hashCode());
		
		logger = Logger.getInstance();
		
		logger.log("이것이 싱글톤이다2");
		
		System.out.println(logger.hashCode());
	}
}
