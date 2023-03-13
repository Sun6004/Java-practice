package tcpTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;


//서버에 접속하면 d:/d_other/오리.png 파일을 서버로 전송한다.
public class tcpFileClient {
	public static void main(String[] args) {
		
//		try {
//			
//			File file = new File("d:/d_other/오리.png");
//
//			Socket socket = new Socket("localhost",7777);
//			System.out.println("서버에 연결되었습니다");
//
//			FileInputStream fin = new FileInputStream(file);
//			
//			OutputStream out = socket.getOutputStream();
//			
//			DataOutputStream dout = new DataOutputStream(out);
//			
//			System.out.println("서버한테 전송하는 파일: " + file.getName());
//
//			dout.writeUTF(file.getName());
//			
//			int c;
//			while((c=fin.read()) != -1) {
//				out.write(c);
//			}
//			out.close();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		new tcpFileClient().clientStart();
		
	}
	public void clientStart() {
		Socket socket = null;
		BufferedOutputStream bout = null;
		BufferedInputStream bin =null;
		DataOutputStream dout = null;
		
		// 전송할 파일 정보를 갖는 File객체를 생성
		File file = new File("d:/d_other/오리.png");
		String fileName = file.getName();
		
		if(!file.exists()) {
			System.out.println("전송할 "+fileName+" 파일이 없습니다.");
			return;
		}
		
		try {
			socket = new Socket("loclahost",7777);
			
			System.out.println("파일 전송 시작");
			dout = new DataOutputStream(socket.getOutputStream());
			dout.writeUTF(fileName);
			
			//파일 읽기용 스트림 객체 생성
			bin = new BufferedInputStream(new FileInputStream(file));
			
			//서버로 전송할 출력용 스트림 객체
			bout = new BufferedOutputStream(socket.getOutputStream());
			
			byte[] temp = new byte[1024];
			int len = 0;
			
			//파일 내용을 읽어서 서버로 전송한다.
			while((len = bin.read())>0) {
				bout.write(temp, 0 , len);
			}
			bout.flush();
			System.out.println("파일 전송 완료");
			
		} catch (Exception e) {
			System.out.println("파일 전송 실패");
		}finally {
			if(dout != null) try {dout.close();}catch(Exception e) {}
			if(dout != null) try {bout.close();}catch(Exception e) {}
			if(bin != null) try {bin.close();}catch(Exception e) {}
			if(socket != null) try {socket.close();}catch(Exception e) {}
		}
	}
}
