package kr.or.ddit.basic;

import java.io.FileReader;
import java.io.IOException;

public class FileIOTest03 {
	public static void main(String[] args) {
		//문자기반 스트림을 이용하여 파일 내용 읽어와 출력하기
		FileReader fr = null; //문자 기반 피일 입력용 스트림 객체변수 선언
		
		try {
			//스트림객체 생성
			fr = new FileReader("d:/D_Other/test.txt");
			
			int c;
			
			while((c=fr.read())!= -1) {
				System.out.print((char)c);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fr!=null) try {
				fr.close();
			} catch (IOException e) {
			}
		}
	}
}
