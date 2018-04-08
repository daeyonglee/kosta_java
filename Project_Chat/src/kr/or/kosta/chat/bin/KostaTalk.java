package kr.or.kosta.chat.bin;

import kr.or.kosta.chat.boundary.ChatFrame;

public class KostaTalk {
	public static void main(String[] args) {
		
		ChatFrame frame = ChatFrame.getInstance();
		
		frame.setTitle("KOSTA TALK");
		frame.init();
		frame.setSize(400,600);
		frame.setLocation(500, 0);
		frame.setContents();
		frame.setEventRegist();
		frame.setVisible(true);
	}
}
