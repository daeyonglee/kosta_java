package kr.or.kosta.ftp.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class FTPClient {

	public static final String IP = "127.0.0.1";
	public static final int PORT = 2017;
	
	private Socket socket;
	private String nickName;
	
	DataInputStream in;
	DataOutputStream out;
	
	public FTPClient(String nickName) {
		this.nickName = nickName;
	}
	
	public void connect() throws UnknownHostException, IOException {
		socket = new Socket(IP, PORT);
		in = new DataInputStream(socket.getInputStream());
		out = new DataOutputStream(socket.getOutputStream());
	}
	public void messageSend(String message) throws IOException {
		out.writeUTF(message);
		out.flush();
	}
	
	public boolean fileDownload(String downFilePath, String downFileName, String downloadPath, String donwloadName) throws IOException {
		// �ٿ�ε��ϰ��� �ϴ� ���ϸ� FTP Server�� ����
		out.writeUTF(downFilePath);
		out.writeUTF(downFileName);
		
		// �ٿ�ε��ϰ��� �ϴ� ���� ������ ����
		long fileSize = in.readLong();
		
		File df = new File(downloadPath, donwloadName);
		FileOutputStream fos = new FileOutputStream(df);
		
		// ���ϴٿ�ε� ����â ����
		ProgressBarFrame frame = new ProgressBarFrame(donwloadName);
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
							
			// ������� ProgressBar�� ���
			frame.setProgress(copyRate);
		}
		System.out.println("��������");
		return true;
	}
}
