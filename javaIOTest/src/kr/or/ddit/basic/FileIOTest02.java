package kr.or.ddit.basic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOTest02 {
	public static void main(String[] args) {
		//바이트 기반의 출력용 스트림으로 파일 내용 읽기
				FileOutputStream fout = null; //파일 입력용 스트림 객체 변수 선언
				
				try {
					File f = new File("d:/D_Other/test.txt");
					fout = new FileOutputStream(f); //출력용스트림
					
					for(char ch='A'; ch<='z'; ch++) {
						fout.write(ch);
					}
						fout.flush(); //출력 버퍼에 남아있는 자료를 강제출력
						
						System.out.println("작업완료");
										
				} catch (IOException e) {
					System.err.println("어쩔에러~ \n" + e.getMessage());
				} finally {
					if(fout != null)try {fout.close(); } catch (IOException e2) {}
				}
				
			}
	}
