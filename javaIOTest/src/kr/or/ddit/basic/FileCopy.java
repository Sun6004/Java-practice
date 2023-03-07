package kr.or.ddit.basic;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

//문제 d:/d_other 폴더에 있는 오리.png 파일을
//	   d:/d_other/연습용 폴더에 복사본_오리.png 파일로 복사하는 프로그램을 작성하시오.	
public class FileCopy {
	
	public static void main(String[] args) {
		
		try {
			File f = new File("d:/d_other/오리.png");
			File nf = new File("d:/d_other/연습용/복사본_오리.png");
			
			Files.copy(f.toPath(), nf.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
