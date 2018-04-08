import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Window;

public class ContainerExample {
	public static void main(String[] args) throws InterruptedException {
		Frame frame = new Frame();
		
		Window window = new Window(frame);
		window.setSize(500, 400);
		window.setVisible(true);
//		Thread.sleep(3000);
		window.setVisible(false);
		
//		frame.setLocation(100, 100);
//		frame.setSize(800, 700);
		frame.setBounds(100, 100, 800, 500);
		frame.setVisible(true);
		
		Dialog dialog = new Dialog(frame, "대화상자", false);
		dialog.setSize(400, 400);
		dialog.setVisible(true);
		
		FileDialog fd = new FileDialog(frame, "열기", FileDialog.LOAD);
		fd.setVisible(true);
	}
}
