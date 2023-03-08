package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataIOTest {
	public static void main(String[] args) {
		
		try {
			FileOutputStream fout = new FileOutputStream("d:/d_Other/test.dat");
			
			//자료형 단위로 출력할 보조스트림 객체 생성
			DataOutputStream dout = new DataOutputStream(fout);
			
			dout.writeInt(200); //정수형으로 데이터 출력
			dout.writeFloat(123.45f); //실수형으로 출력
			dout.writeBoolean(false);
			dout.writeUTF("ASDFasdf");//문자열 형식으로 출력
			
			System.out.println("출력완료");
			System.out.println("-------------------------------------");
			
			dout.close();
			//
			
			//출력한 자료 읽어오기
			//입력용 스트림 객체 생성
			DataInputStream din = new DataInputStream(new FileInputStream("d:/d_Other/test.dat"));
			
			//DataInputStream으로 자료를 읽어올 때는 출력할 때와 순서와 구조가 같아야 한다.
			System.out.println("정수형: " + din.readInt());
			System.out.println("실수형: " + din.readFloat());
			System.out.println("논리형: " + din.readBoolean());
			System.out.println("문자열: " + din.readUTF());
			
			System.out.println();
			System.out.println("읽기 작업 끝!");
			
			din.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
