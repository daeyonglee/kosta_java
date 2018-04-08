import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

public class DrawCanvas extends Canvas{

	@Override
	public void paint(Graphics g) {
		// 도형별 그리기 메소드 제공
		g.draw3DRect(  0, 0, 46, 36, true);
		g.drawOval(50, 0, 46, 36);
		int x1[] = new int[] { 100, 300, 273 };
		int y1[] = new int[] {   0,   0,  36 };
		g.drawPolygon(x1, y1, x1.length);
		g.setColor(Color.blue);
		g.fill3DRect(  0, 40, 46, 36, true);
		g.fillOval(50, 40, 46, 36);
		int x2[] = new int[] { 100, 300, 273 };
		int y2[] = new int[] {  40,  40,  76 };
		g.fillPolygon(x2, y2, x2.length);
		g.drawLine(150, 40, 396, 76);
		g.setColor(Color.black);
		g.drawString("www. bangry.com", 10, 115);
		g.setColor(Color.cyan);
		g.drawRoundRect( 0, 120, 46, 36, 10, 10);
		g.fillRoundRect(50, 120, 46, 36, 10, 10);
		g.clearRect(30, 30, 250, 30);
		super.paint(g);
	}
	
	public static void main(String[] args) {
		Frame frame = new Frame();
		DrawCanvas canvas = new DrawCanvas();
		frame.add(canvas);
		frame.setSize(500, 400);
		frame.setVisible(true);
	}
	
}
