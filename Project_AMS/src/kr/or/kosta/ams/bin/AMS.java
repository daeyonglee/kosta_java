package kr.or.kosta.ams.bin;

import kr.or.kosta.ams.boundary.MainFrame;
import kr.or.kosta.ams.entity.Account;
import kr.or.kosta.ams.entity.MinusAccount;

public class AMS {
	public static void main(String[] args) {
		
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
		frame.setSize(550,550);
		frame.setTitle("KOSTA AMS - 메인화면");
		frame.setContents();
		frame.setEventRegister();
		
		frame.addAccount(new Account("1111-2222-3333", "임꺽정", 1111, 100000));
		frame.addAccount(new Account("2222-3333-4444", "홍길동", 2222, 200000));
		frame.addAccount(new MinusAccount("3333-4444-5555", "이순신", 3333, 300000, 400000));
		frame.addAccount(new Account("6666-7777-8888", "이순신", 3333, 300000));
		
		frame.listAll();
		
	}
}
