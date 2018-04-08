package kr.or.kosta.chat.entity;

import java.net.Socket;

import kr.or.kosta.chat.server.ClientThread;

public class User {

	private String nickName;
	
	public User() {}
	
	public User(String nickName) {
		this.nickName = nickName;
	}
	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "User [nickName=" + nickName + "]";
	}
}