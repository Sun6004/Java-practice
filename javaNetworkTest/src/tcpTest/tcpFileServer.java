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
	//클라이언트가 보내온 파일을 받아서 연습용 폴더에 저장한다.
	public static void main(String[] args) throws IOException {
//		ServerSocket server = new ServerSocket(7777);
//		
//		System.out.println("서버가 준비 중입니다..");
//		
//		Socket socket = server.accept(); //클라이언트의 접속 요청 기다리기..
//		
//	
//	         try {
//	             System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "에서 접속하였습니다.");
//
//	             // 클라이언트로부터 전송된 파일을 저장할 경로를 지정합니다.
//	             File file = new File("d:/d_other/연습용/오리_복사본.png");
//	             
//	             InputStream inputStream = socket.getInputStream();
//	             
//	             FileOutputStream fileOutputStream = new FileOutputStream(file);
//	             
//	             DataInputStream din = new DataInputStream(inputStream);
//	             
//	             System.out.println(din.readUTF());
//	             
//	             int c;
//	             while((c=inputStream.read())!= -1) {
//	            	 fileOutputStream.close();
//	             }
//	             fileOutputStream.close();
//	             socket.close();
//	   
//
//	         } catch (IOException e) {
//	             e.printStackTrace();
//	         }
		
		new tcpFileServer().serverStart();
	 }
	public void serverStart() {
		ServerSocket server = null;
		Socket socket = null;
		
		DataInputStream din = null;
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;
		
		//저장할 폴더 정보를 갖는 File객체 생성
		File saveDir = new File("d:/d_other/연습용");
		if(!saveDir.exists()) { //저장할 폴더가 없으면 새로 만든다.
			saveDir.mkdir();
		}
		
		try {
			server = new ServerSocket(7777);
			System.out.println("서버가 준비되었습니다.");
			socket = server.accept(); //클라이언트의 요청 기다리기..
			
			System.out.println("파일 수신 시작");
			
			//클라이언트가 첫번째로 보낸 데이터(파일명)를 받을 스트림 객체 생성
			din = new DataInputStream(socket.getInputStream());
			
			String fileName = din.readUTF(); //파일명 받기
			
			//저장할 폴더와 수신받은 파일명을 결합한File 객체 생성
			File saveFile = new File(saveDir,fileName);
			
			bin = new BufferedInputStream(socket.getInputStream()); //수신용
			bout = new BufferedOutputStream(new FileOutputStream(saveFile)); //파일 저장용
			
			byte[] temp = new byte[1024];
			int len = 0;
			while((len = bin.read(temp))>0) {
				bout.write(temp, 0, len);
			}
			bout.flush();
			System.out.println("파일 수신 완료");
		} catch (Exception e) {
			System.out.println("파일 수신 실패");
			 e.printStackTrace();
		}finally {
			if(din != null) try {
				din.close();
			} catch (Exception e) {
			}
			if(bin != null) try {
				bin.close();
			} catch (Exception e) {
			}
			if(bout != null) try {
				bout.close();
			} catch (Exception e) {
			}
			if(socket != null) try {
				socket.close();
			} catch (Exception e) {
			}
			if(server != null) try {
				server.close();
			} catch (Exception e) {
			}
		}
	}
}

