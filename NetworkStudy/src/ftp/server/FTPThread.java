package ftp.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 원격클라이언트(Socket)와의 파일 송수신 스레드
 * @author 김기정
 */
public class FTPThread extends Thread {
	
	private static final String FILE_DIRECTORY = "C:\\Users\\ldy\\Desktop";
	
	Socket socket;
	DataOutputStream out;
	DataInputStream in;
	
	public FTPThread(Socket socket) throws IOException{
		this.socket = socket;
		out = new DataOutputStream(socket.getOutputStream());
		in = new DataInputStream(socket.getInputStream());
	}
	
	// FileDirectory의 파일 목록 전송
	public void sendFileList() throws IOException{
		//"파일명1,파일명2,파일명n" - CSV(Comma Separator Value)로 파일명 구분
		File directory = new File(FILE_DIRECTORY);
		// 파일디렉토리가 존재하지 않을 경우 최초 디렉토리 생성
		if(!directory.exists()){
			directory.mkdir();
		}
		
		File[] list = directory.listFiles();
		StringBuilder sb = new StringBuilder();
		for (File file : list) {
			String name = file.getName();
			sb.append(name + ",");
		}
		out.writeUTF(sb.toString());
		
		//----------------------------------------------------
		
		// 클라이언트가 다운로드 받고자 하는 파일명 수신
		String downFile = in.readUTF();
		
		sendFile(downFile);
	}
	
	public void sendFile(String fileName) throws IOException{
		File file = new File(FILE_DIRECTORY, fileName);
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
	
	
	public void run(){
		try {
			// 최초 접속시 파일 목록 전송
			sendFileList();			
		} catch (IOException e) {
			System.out.println("네트워크 장애로 파일을 전송할 수 없습니다.");
		} finally{
			try{
				if(in != null)     in.close();
				if(out != null)    out.close();
				if(socket != null) socket.close();
				
			}catch(IOException e){}	
		}
	}
}
