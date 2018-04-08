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
		System.out.println("나 호출되었당..");
		super.paint(g);
		
		g.setColor(Color.blue);
		g.setFont(new Font("궁서", Font.BOLD, 50));
		g.drawString("자바 그래픽 처ㅣㄹ 테스트", 100, 50);
		
	}
}
