package kr.or.kosta.ftp.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Vector;

public class FTPThread extends Thread{
	
	private Socket socket;
	private DataOutputStream out;
	private DataInputStream in;
	
	private FTPServer ftpServer;
	
	private boolean running;
	
	private String nickName;
	
	
	public String getNickName() {
		return nickName;
	}
	
	public DataOutputStream getOut() {
		return out;
	}

	public void setOut(DataOutputStream out) {
		this.out = out;
	}

	public DataInputStream getIn() {
		return in;
	}

	public void setIn(DataInputStream in) {
		this.in = in;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public FTPThread(FTPServer ftpServer, Socket socket) throws IOException {
		running=false;
		this.ftpServer = ftpServer;
		this.socket = socket;
		out = new DataOutputStream(socket.getOutputStream());
		in  = new DataInputStream(socket.getInputStream());
	}
	
	@Override
	public void run() {
		try {
			processFileSend();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
				/*try {
					if (in != null) in.close();
					if (out != null) out.close();
					if (socket != null) socket.close();
					System.out.println("in out socket 닫힘");
				} catch (IOException e) {
					e.printStackTrace();
				}*/
		}
	}
	
	public void processFileSend() throws IOException {
		String directory = in.readUTF();
		String fileName = in.readUTF();
		
		File file = new File(directory, fileName);
		long fileSize = file.length();
		
		// 다운로드 받고자 하는 파일 사이즈 출력
		out.writeLong(fileSize);
		
		FileInputStream fin = null;
		try{
			fin = new FileInputStream(file);
			byte[] buffer = new byte[1024];
			int count = 0;
			while((count=fin.read(buffer)) != -1){
				out.write(buffer, 0, count);
			}
		}finally{
			if(fin != null) fin.close();
		}
	}
}
