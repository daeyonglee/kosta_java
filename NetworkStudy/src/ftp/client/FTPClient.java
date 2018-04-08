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
 * FTP ���� Ŭ���̾�Ʈ
 * @author �����
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
	
	
	/** ���� �ٿ�ε� */
	public void fileDownload() throws IOException{
		// ���� ��� ����
		//"���ϸ�1(������),���ϸ�2(������)" CSV ������
		String fileList = in.readUTF();
		System.out.println("========== FTP Server File List ==========");
		String[] files = fileList.split(",");
		for (String fileName : files) {
			System.out.println(fileName);
		}
		
		// ����ڷκ��� �ٿ�ε��ϰ��� �ϴ� ���ϸ� �Է�
		System.out.print("�ٿ�ε� �ϰ����ϴ� ���ϸ� : ");
		Scanner scanner = new Scanner(System.in);
		String downFileName = scanner.nextLine();
		
		// �ٿ�ε��ϰ��� �ϴ� ���ϸ� FTP Server�� ����
		out.writeUTF(downFileName);
					
		// �ٿ�ε��ϰ��� �ϴ� ���� ������ ����
		long fileSize = in.readLong();
		
		
		// �ٿ�ε� ���� ���� ��ġ
		String downloadPath = "C:\\Users\\ldy\\Desktop\\������";
		
		File df = new File(downloadPath, downFileName);
		FileOutputStream fos = new FileOutputStream(df);
		
		// ���ϴٿ�ε� ����â ����
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
							
			// ������� ProgressBar�� ���
			frame.setProgress(copyRate);
		}
		System.out.println(downFileName +" ���� �ٿ�ε� �Ϸ�...");
		
	}
	
	public static void main(String[] args) throws UnknownHostException {
		FTPClient client = new FTPClient();
		try {
			client.connect();
			System.out.println("FTPServer Connected.....");
			
			client.fileDownload();
			
		} catch (IOException e) {
			System.out.println("������ ������ �� �����ϴ�.");
		}finally{
			client.disConnect();
		}

	}
	
}












