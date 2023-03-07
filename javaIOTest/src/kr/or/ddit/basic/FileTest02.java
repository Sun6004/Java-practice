package kr.or.ddit.basic;

import java.io.File;

public class FileTest02 {
	public static void main(String[] args) {
		File f1 = new File("d:/D_Other/test.txt");
		
		System.out.println(f1.getName()+"의 크기" + f1.length()+"byte(s)");
		System.out.println("path: " + f1.getPath());
		System.out.println("absolutePath: " + f1.getAbsolutePath());
		System.out.println();
		
		//path: File객체를 만들때 내가 지정한 위치
		//AbsoulutePath: 절대경로
		File f2 = new File("."); //현재폴더라는 뜻
		System.out.println("path: " + f2.getPath());
		System.out.println("absolutePath: " + f2.getAbsolutePath());
		System.out.println();
		
		if(f1.isFile()) {
			System.out.println(f1.getName() + "은 파일입니다.");
		}else if(f1.isDirectory()){
			System.out.println(f1.getName() + "은 디렉토리입니다."); 
		}else {
			System.out.println(f1.getName()+"이건 뭐임?");
		}
		
		if(f2.isFile()) {
			System.out.println(f2.getName() + "은 파일입니다.");
		}else if(f1.isDirectory()){
			System.out.println(f2.getName() + "은 디렉토리입니다."); 
		}else {
			System.out.println(f2.getName()+" 이건 뭐임?");
		}
		
		File f3 = new File("d:/D_Other/sample.exe"); //현재 존재하지 않는 파일 지정
		if(f3.isFile()) {
			System.out.println(f3.getName() + "은 파일입니다.");
		}else if(f1.isDirectory()){
			System.out.println(f3.getName() + "은 디렉토리입니다."); 
		}else {
			System.out.println(f3.getName()+" 이건 뭐임?");
		}
		
	}
}
