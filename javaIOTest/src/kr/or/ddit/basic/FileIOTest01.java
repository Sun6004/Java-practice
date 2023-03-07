package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileIOTest01 {
	public static void main(String[] args) {
		//바이트 기반의 파일 입력용 스트림으로 파일 내용 읽기
		FileInputStream fin = null; //파일 입력용 스트림 객체 변수 선언
		try {
			//읽어올 파일을 인수값으로 지정해서 FileInputStream객체 생성하기
			
			//방법1
			//fin = new FileInputStream("d:/D_Other/test.txt");
			
			//방법 2
			File file = new File("d:/D_Other/test.txt");
			fin = new FileInputStream(file);
			
			int c; //읽어온 데이터를 저장할 변수
			while ((c=fin.read()) !=  -1) {
				//읽어온 데이터를 화면에 출력하기
				System.out.print((char)c);
			}
			
		} catch (IOException e) {
			System.err.println("어쩔에러~ \n" + e.getMessage());
		} finally {
			if(fin != null)try {fin.close(); } catch (IOException e2) {}
		}
		
	}
}
