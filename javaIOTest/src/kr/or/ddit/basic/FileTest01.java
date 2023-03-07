package kr.or.ddit.basic;

import java.io.File;

public class FileTest01 {
	public static void main(String[] args) {
		
	//File객체 만들기 연습
		
	// 1. new File(String 파일 또는 경로);
	// ==> 디렉토리와 디렉토리 사이 또는 디렉토리와 파일명 사이의 구분자는 '\'를 사용하거나 '/'사용 가능
		
		File file1 = new File("d:/D_Other/test.txt"); //구분 문자를 /로 사용한 경우
		//File file2 = new File("d:\\D_Other\\test.txt"); //구분 문자를 \\로 사용한 경우(두개씩 써야함)
		
		System.out.println("파일명: "+ file1.getName());
		System.out.println("디렉토리인지 구별: " + file1.isDirectory());
		System.out.println("파일인지 구별: " + file1.isFile());
		System.out.println();
		System.out.println("--------------------------------");
		
		File file2 = new File("d:/D_Other");
	
		System.out.println("파일명: "+ file2.getName());
		System.out.println("디렉토리인지 구별: " + file2.isDirectory());
		System.out.println("파일인지 구별: " + file2.isFile());
		System.out.println();
		
		// 2. new File(File parent, String child);
		// ==> 'parent'디렉토리 안에 있는 'child'파일을 갖는다.
		File file3 = new File(file2, "test.txt"); //file2가 가지고있는 디렉토리 정보
		
		
		System.out.println("--------------------------------");
		System.out.println("파일명: "+ file3.getName());
		System.out.println("디렉토리인지 구별: " + file3.isDirectory());
		System.out.println("파일인지 구별: " + file3.isFile());
		System.out.println();
		
		// 3.new File(String parent, String child);
		// ==> 'parent'디렉토리 안에 있는 'child'파일을 갖는다.
		File file4 = new File("d:/D_Other", "test.txt");
		
		System.out.println("--------------------------------");
		System.out.println("파일명: "+ file4.getName());
		System.out.println("디렉토리인지 구별: " + file4.isDirectory());
		System.out.println("파일인지 구별: " + file4.isFile());
		System.out.println();
		
		//디렉토리(폴더) 만들기
		/*
		 *  -mkdir()  ==> File객체의 경로 중 마지막 위치의 디렉토리를 만든다.
		 *  	      ==> 반환값: 만들기성공/실패  true/false
		 *  		  ==> 중간 부분의 경로가 모두 만들어져 있어야 마지막 위치의 경로를 만들 수 있다.
		 *  -mkdirs() ==> 중간 부분의 경로가 없으면 중간부분의 경로도 같이 만들어준다.
		 *  
		 */
		File file5 = new File("d:/D_Other/연습용");
		System.out.println(file5.getName()+"의 존재여부: " + file5.exists());
		
		if(!file5.exists()) {
			if(file5.mkdir()) {
				System.out.println(file5.getName()+"만들기 성공");
			}else {
			System.out.println(file5.getName()+"만들기 실패");
			}
		}
		
		System.out.println();
		File file6 = new File("d:/D_Other/test/java/src");
		
		if(file6.mkdirs()) {
			System.out.println(file6.getName() + "만들기 성공!");
		}else {
			System.out.println(file6.getName() + "만들기 실패ㅋ~");
		}
	}
}
