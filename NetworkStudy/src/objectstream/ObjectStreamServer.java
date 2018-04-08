package objectstream;

import java.net.*;

/**
 * ��ü(Object) ������ ��Ʈ��ũ �����
 * @author �����
 */
public class ObjectStreamServer{
	public static final int PORT = 2018;
   
   public static void main(String[] args){
    boolean stop = false;  
   	ServerSocket serverSocket = null;
   	
   	Socket socket = null;
   	EchoThread echoThread = null;
 
   	System.out.println("Object Echo Server Start!!!");
   	
   	try{
   		serverSocket = new ServerSocket(PORT);
   		
		while(!stop){
   			socket = serverSocket.accept();
   			System.out.println("["+socket.getInetAddress() + "] Connected...");
   			echoThread = new EchoThread(socket);
   			echoThread.start();
   		}
   	}
   	catch (Exception ex){
   		ex.printStackTrace();
   	}
   }
}




