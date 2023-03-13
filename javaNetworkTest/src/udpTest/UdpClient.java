package udpTest;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

// 송신할 메세지를 입력받아 상대방에게 송신하고, 상대방이 보낸 메세지를 받아서 화면에 출력한다.
public class UdpClient {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//송신용, 수신용 패킷 객체 변수 선언
		DatagramPacket inpacket, outpacket;
		
		// 수신 받은 데이터가 저장될 byte형 배열 변수 선언
		byte[] bMsg = new byte[512];
		
		try {
			
			DatagramSocket socket = new DatagramSocket(); // socket객체 생성
			
			//접속할 상대방의 주소 정보 객체 생성
			InetAddress addr = InetAddress.getByName("localhost");
			
			while(true) {
				// 전송할 메세지 입력
				System.out.print("보낼 메세지 입력>> ");
				String msg = sc.nextLine();
				
				//송신용 패킷 객체 생성
				outpacket = new DatagramPacket(msg.getBytes("utf-8"),msg.getBytes("utf-8").length,addr,8888);
				//전송
				socket.send(outpacket);
				
				if("/end".equals(msg)) { // '/end' 입력시 작업종료
					break;
				}
				
				// 서버가 보내온 데이터 받아서 출력하기
				
				// 수신용 패킷 생성
				inpacket = new DatagramPacket(bMsg, bMsg.length);
				
				//수신
				socket.receive(inpacket);
				
				//String sendMsg = new String(bMsg, 0, inpacket.getLength(), "utf-8"); // 방법1
				String sendMsg = new String(inpacket.getData(), 0, inpacket.getLength(), "utf-8"); // 방법2
				
				if("/end".equals(msg)) { // 수신 문자열이 '/end' 이면 작업 끝
					break;
				}
				
				System.out.println();
				System.out.println("서버의 응답 메세지: " + sendMsg);
				System.out.println();
				
			} //while문 종료
			
			System.out.println("통신종료");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
		
	}