package tcpTest;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

//이 쓰레드 클래스는 소켓을 통해서 메세지를 보내는 역할을 담당한다.
public class sender extends Thread{
	private Socket socket;
	private DataOutputStream dout;
	private String name;
	private Scanner sc;
	
	//생성자
	public sender(Socket socket){
		this.socket = socket;
		sc = new Scanner(System.in);
		
		System.out.println("이름입력>> ");
		name = sc.nextLine();
		
		//출력용 스트림 객체
		try {
			dout = new DataOutputStream(this.socket.getOutputStream());

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public void run() {
		while (dout!=null) {
			try {
				dout.writeUTF(name+" : "+sc.nextLine());
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		super.run();
	}
}
