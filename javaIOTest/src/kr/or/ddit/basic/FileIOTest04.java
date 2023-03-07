package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileIOTest04 {
	public static void main(String[] args) {
		//사용자가 입력한 내용을 그대로 파일로 저장하기
		
		//Scanner sc =new Scanner(System.in); // in = inputStream
		
		try {
			//System.out.print("입력 ㄱ: ");
			//int c = System.in.read();  system.in ==>콘솔 입력장치와 연결된 스트림
			//System.out.println("입력값: "+(char)c);
			
			// 바이트 기반 스트림을 문자기반 스트림으로 변환하는 보조 스트림 객체
			// InputStreamReader ==> 입력용
			// OutputStreamWriter ==> 출력용
			InputStreamReader is = new InputStreamReader(System.in);
			
			FileWriter fw = new FileWriter("d:/D_Other/test.txt");
			
			System.out.println("입력 ㄱㄱ(입력끝은 ctrl+z): ");
			
			int c;
			
			//콘솔에서 입력할 때 입력의 끝은 Ctrl+z키를 누르면됨.
			while((c = is.read()) != -1) {
				fw.write(c); //콘솔로 입력받은 데이터를 파일에 출력
			}
			fw.close();
			is.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
