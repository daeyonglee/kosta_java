package kr.or.kosta.ams.bin;

import kr.or.kosta.ams.boundary.MainFrame;

public class AMS {
	public static void main(String[] args) {
		
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
		frame.setSize(550,550);
		frame.setTitle("KOSTA AMS - ����ȭ��");
		frame.setContents();
		frame.setEventRegister();
	}
}
