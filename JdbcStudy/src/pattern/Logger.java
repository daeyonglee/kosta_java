package pattern;

/**
 * �̱��� ���� ���� �α� ��� Ŭ����
 * @author �̴��
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
		
		logger.log("�̰��� �̱����̴�");
		
		System.out.println(logger.hashCode());
		
		logger = Logger.getInstance();
		
		logger.log("�̰��� �̱����̴�2");
		
		System.out.println(logger.hashCode());
	}
}
