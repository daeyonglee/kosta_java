import java.io.File;
import java.util.Calendar;

public class FileExample {
	public static void main(String[] args) {
		String filePath = "sample.dat";
		
		File file = new File(filePath);
		
		System.out.println(file.getAbsolutePath());
		System.out.println(file.toURI());
		
		System.out.println(file.exists());
		System.out.println(file.lastModified());
		
		long ms = file.lastModified();
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(ms);
		
		System.out.println(String.format("%1$tF %1$tT", calendar));
		System.out.println(file.length());
		
		File dir = new File("C:\\Windows");
		File[] list = dir.listFiles();
		for (File file2 : list) {
			if (file2.isFile()) {
				System.out.println("ÆÄÀÏ : " + file2.getName());
			} else {
				System.out.println("<DIR> " + file2.getName());
			}
		}
		
		File dir2 = new File("MyDirectory");
		System.out.println(dir2.mkdir());
		System.out.println(dir2.delete());
		
		for (File f : File.listRoots()) {
			System.out.println(f);
		}
	}
}
