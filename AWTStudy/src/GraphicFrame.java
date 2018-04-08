import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;

public class GraphicFrame extends Frame{

	public static void main(String[] args) {
		GraphicFrame frame = new GraphicFrame();
		frame.setSize(500, 400);
		frame.setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		System.out.println("�� ȣ��Ǿ���..");
		super.paint(g);
		
		g.setColor(Color.blue);
		g.setFont(new Font("�ü�", Font.BOLD, 50));
		g.drawString("�ڹ� �׷��� ó�Ӥ� �׽�Ʈ", 100, 50);
		
	}
}
