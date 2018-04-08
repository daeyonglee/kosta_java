package ftp.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import ftp.server.FTPServer;

/**
 * FTP 파일 클라이언트
 * @author 김기정
 */
public class FTPClient {
	
	private static final String IP = "localhost";
	private static final int PORT = 2018;
	
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private boolean stop;
	
	public Socket getSocket() {
		return socket;
	}
	
	public DataInputStream getIn() {
		return in;
	}
	
	public DataOutputStream getOut() {
		return out;
	}
	
	public boolean isStop() {
		return stop;
	}
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	public void connect() throws UnknownHostException, IOException{
		socket = new Socket(IP,PORT);
		out = new DataOutputStream(socket.getOutputStream());
		in = new DataInputStream(socket.getInputStream());
	}
	
	public void disConnect(){
		try {
			if(in != null)	in.close();
			if(out != null)	out.close();
			if(socket != null)	socket.close();
		} catch (IOException e) {}
	}
	
	
	/** 파일 다운로드 */
	public void fileDownload() throws IOException{
		// 파일 목록 수신
		//"파일명1(사이즈),파일명2(사이즈)" CSV 데이터
		String fileList = in.readUTF();
		System.out.println("========== FTP Server File List ==========");
		String[] files = fileList.split(",");
		for (String fileName : files) {
			System.out.println(fileName);
		}
		
		// 사용자로부터 다운로드하고자 하는 파일명 입력
		System.out.print("다운로드 하고자하는 파일명 : ");
		Scanner scanner = new Scanner(System.in);
		String downFileName = scanner.nextLine();
		
		// 다운로드하고자 하는 파일명 FTP Server에 전송
		out.writeUTF(downFileName);
					
		// 다운로드하고자 하는 파일 사이즈 수신
		long fileSize = in.readLong();
		
		
		// 다운로드 파일 저장 위치
		String downloadPath = "C:\\Users\\ldy\\Desktop\\새폴더";
		
		File df = new File(downloadPath, downFileName);
		FileOutputStream fos = new FileOutputStream(df);
		
		// 파일다운로드 진행창 생성
		ProgressBarFrame frame = new ProgressBarFrame(downFileName);
		frame.setComponents();
		frame.setSize(380, 130);
		frame.eventRegist();
		frame.setVisible(true);
		
		byte[] buffer = new byte[1024];
		int count = 0;
		
		int copyRate = 0;
		double copySize = 0;
		
		
		while((count=in.read(buffer)) != -1){
			fos.write(buffer, 0, count);
			copySize += count;
			copyRate = (int)((copySize/fileSize) * 100);
							
			// 복사비율 ProgressBar에 출력
			frame.setProgress(copyRate);
		}
		System.out.println(downFileName +" 파일 다운로드 완료...");
		
	}
	
	public static void main(String[] args) throws UnknownHostException {
		FTPClient client = new FTPClient();
		try {
			client.connect();
			System.out.println("FTPServer Connected.....");
			
			client.fileDownload();
			
		} catch (IOException e) {
			System.out.println("서버와 연결할 수 없습니다.");
		}finally{
			client.disConnect();
		}

	}
	
}












