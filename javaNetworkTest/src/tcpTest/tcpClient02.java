package tcpTest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class tcpClient02 {
	public static void main(String[] args) throws IOException {
		try {
			Socket socket = new Socket("192.168.146.60",7777);
			System.out.println("서버에 연결되었습니다");
			
			sender sender = new sender(socket);
			Receiver receiver = new Receiver(socket);
			
			sender.start();
			receiver.start();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
