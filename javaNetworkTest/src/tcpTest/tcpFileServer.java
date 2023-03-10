package tcpTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class tcpFileServer {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(7777);
		
		System.out.println("서버가 준비 중입니다..");
		
		Socket socket = server.accept(); //클라이언트의 접속 요청 기다리기..
		
	
	         try {
	             System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "에서 접속하였습니다.");

	             // 클라이언트로부터 전송된 파일을 저장할 경로를 지정합니다.
	             File file = new File("d:/d_other/연습용/오리_복사본.png");
	             
	             InputStream inputStream = socket.getInputStream();
	             
	             FileOutputStream fileOutputStream = new FileOutputStream(file);
	             
	             DataInputStream din = new DataInputStream(inputStream);
	             
	             System.out.println(din.readUTF());
	             
	             int c;
	             while((c=inputStream.read())!= -1) {
	            	 fileOutputStream.close();
	             }
	             fileOutputStream.close();
	             socket.close();
	   

	         } catch (IOException e) {
	             e.printStackTrace();
	         }

	 }
	}

