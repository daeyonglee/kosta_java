package ftp.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * ����Ŭ���̾�Ʈ(Socket)���� ���� �ۼ��� ������
 * @author �����
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
	
	// FileDirectory�� ���� ��� ����
	public void sendFileList() throws IOException{
		//"���ϸ�1,���ϸ�2,���ϸ�n" - CSV(Comma Separator Value)�� ���ϸ� ����
		File directory = new File(FILE_DIRECTORY);
		// ���ϵ��丮�� �������� ���� ��� ���� ���丮 ����
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
		
		// Ŭ���̾�Ʈ�� �ٿ�ε� �ް��� �ϴ� ���ϸ� ����
		String downFile = in.readUTF();
		
		sendFile(downFile);
	}
	
	public void sendFile(String fileName) throws IOException{
		File file = new File(FILE_DIRECTORY, fileName);
		long fileSize = file.length();
		
		// �ٿ�ε� �ް��� �ϴ� ���� ������ ���
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
			// ���� ���ӽ� ���� ��� ����
			sendFileList();			
		} catch (IOException e) {
			System.out.println("��Ʈ��ũ ��ַ� ������ ������ �� �����ϴ�.");
		} finally{
			try{
				if(in != null)     in.close();
				if(out != null)    out.close();
				if(socket != null) socket.close();
				
			}catch(IOException e){}	
		}
	}
}
