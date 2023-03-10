package tcpTest;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class tcpFileClient {
	public static void main(String[] args) {
		try {
			
			File file = new File("d:/d_other/오리.png");

			Socket socket = new Socket("localhost",7777);
			System.out.println("서버에 연결되었습니다");

			FileInputStream fin = new FileInputStream(file);
			
			OutputStream out = socket.getOutputStream();
			
			DataOutputStream dout = new DataOutputStream(out);
			
			System.out.println("서버한테 전송하는 파일: " + file.getName());

			dout.writeUTF(file.getName());
			
			int c;
			while((c=fin.read()) != -1) {
				out.write(c);
			}
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
