package basic;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	public static void main(String[] args) throws UnknownHostException {
		// InetAddress 클래스 ==> IP주소를 다루기 위한 클래스
		
		//www.naver.com
		InetAddress ip = Inet4Address.getByName("www.naver.com");
		
		System.out.println("HostName: " + ip.getHostName());
		System.out.println("HostAddress: " + ip.getHostAddress());
		System.out.println("toString: " + ip.toString());
		System.out.println();
		
		//자신의 컴퓨터의 ip정보 가져오기
		InetAddress localIp = InetAddress.getLocalHost();
		System.out.println("HostName: " +localIp.getHostName());
		System.out.println("HostAddress: " + localIp.getHostAddress());
		System.out.println();
		
		//IP주소가 여러개인 호스트의 정보 가져오기
		InetAddress[] ipArr = InetAddress.getAllByName("www.naver.com");
		for (InetAddress tempIp : ipArr) {
			System.out.println(tempIp.toString());
		}
		System.out.println();
		InetAddress[] ipArr2 = InetAddress.getAllByName("www.google.com");
		for (InetAddress tempIp2 : ipArr2) {
			System.out.println(tempIp2.toString());
		}
		
	}
}
