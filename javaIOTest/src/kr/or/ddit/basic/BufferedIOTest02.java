package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedIOTest02 {
	public static void main(String[] args) {
		//문자 기반의 Buffered스트림 사용하기
		
		BufferedReader br = null;
		try {
			// 버퍼 스트림 객체 생성
			// 이클립스에서의 자바 프로그램이 실행되는 현재 위치는
			// 실행중인 프로그램이 속한 프로젝트 폴더 위치가 현재 위치가 된다.
			br = new BufferedReader(new FileReader("./src/kr/or/ddit/basic/FileTest01.java")); //상대경로
			
			String temp = ""; //읽어온 문자열이 저장될 변수
			
			//문자기반의 입력용 버퍼스트림은 데이터를 한 줄 단위로 읽어오는 메서드를 지원한다.
			// ==> readLine()메서드 ==> 더 이상 읽어올 데이터가 없으면 null을 반환
			for (int i = 1;(temp = br.readLine()) != null; i++) {
				System.out.printf("%4d : %s\n", i, temp);
			}
		
////			while 문 사용시
//			int j = 1;
//			while ((temp = br.readLine()) != null) {
//			System.out.printf("%4d : %s\n", j, temp);
//				j++;
//			}
			
		} catch (Exception e) {
		}finally {
			if(br != null) try {br.close(); }catch(Exception e) {}
		}
	}
}
