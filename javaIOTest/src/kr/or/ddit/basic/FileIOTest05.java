package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class FileIOTest05 {
	public static void main(String[] args) {
		
		//파일의 인코딩 방식을 지정해서 읽어오기
		try {
			//FileReader fr = new FileReader("d:/D_Other/test_ansi.txt");
			//FileReader fr = new FileReader("d:/D_Other/test_UTF8.txt");
			
			//인코딩 방식을 지정해서 입출력하는 보조 스트링
			//=> InputStreamReader / OutputStreamWriter
			FileInputStream fin = new FileInputStream("d:/D_Other/test_ansi.txt");
			
			//기본 인코딩 방식으로 읽어온다.
			//InputStreamReader is = new InputStreamReader(fin);
			
			//인코딩 방식을 지정해서 읽어오기
			//인코딩 방식예시
			// - MS949 ==> 윈도우의 기본 한글 인코딩 방식(ANSI방식과 같음)
			// - UTF-8 ==> 유니코드 utf-8 인코딩 방식
			// - US-ASCII ==> 영문 전용 인코딩 방식
			InputStreamReader is = new InputStreamReader(fin, "MS949");

			int c;
			
			while((c = is.read()) != -1) {
				System.out.print((char)c);
			}
		} catch (Exception e) {
		}
	}
}
