import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class DrawImage extends Panel{

	Button button;
	Image image;
	String imagePath;
	
	int x, y;
	
	public DrawImage() {
		// TODO Auto-generated constructor stub
		button = new Button("이미지와 함께 있는 버튼");
		add(button);
		imagePath = "resources/icons6771.png";
		image = Toolkit.getDefaultToolkit().getImage(imagePath);
		Toolkit.getDefaultToolkit().beep();
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(image, x, y, this);
	}
	
	@Override
	public void update(Graphics g) {
		paint(g);
	}
	
	public void setEventRegist() {
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				repaint();
			}
		});
	}
	
	public static void main(String[] args) {
		Frame frame = new Frame();
		DrawImage canvas = new DrawImage();
		frame.add(canvas);
		frame.setSize(500, 400);
		frame.setVisible(true);
		canvas.setEventRegist();
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frame.setVisible(false);
				frame.dispose();
				System.exit(0);
			}
		});
		
	}
	
}
