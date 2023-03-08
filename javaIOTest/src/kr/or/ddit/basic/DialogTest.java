package kr.or.ddit.basic;

import java.awt.Panel;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DialogTest {
	public static void main(String[] args) {
		//SWING의 파일열기, 저장 창 연습
		
		JFileChooser chooser = new JFileChooser();
		
		//선택할 파일의 확장자 설정
		FileNameExtensionFilter doc = new FileNameExtensionFilter("MS Word", "doc","docx");
		FileNameExtensionFilter img = new FileNameExtensionFilter("Image Files", new String[]{"png","jpg","gif"}); 
		FileNameExtensionFilter pdf = new FileNameExtensionFilter("PDF Files", "pdf"); 		
		FileNameExtensionFilter txt = new FileNameExtensionFilter("txt file", "txt");
		
		//구성한 확장자 추가
		chooser.addChoosableFileFilter(doc);
		chooser.addChoosableFileFilter(img);
		chooser.addChoosableFileFilter(pdf);
		chooser.addChoosableFileFilter(txt);
		
		//구성한 확장자 목록 중에서 현재 선택된 상태가 될 확장자 지정
		chooser.setFileFilter(txt); // 이것을 설정하지 않으면 첫번째로 추가한 확장자가 기본적으로 선택됨.
		
		//확장자 목록에 모든파일 목록을 표시할지 여부 설정 ==> 생략시 기본값 true
		chooser.setAcceptAllFileFilterUsed(false);
		
		//Dialog창 나타내기(열기용과 저장용을 구분해서 나타낸다.)
		//int result = chooser.showOpenDialog(new Panel()); //열기용
		int result = chooser.showSaveDialog(new Panel()); //저장용
		
		if(result == JFileChooser.APPROVE_OPTION) { // 저장/열기 버튼을 눌렀을 경우
			// 선택한 파일 정보 구하기
			File select = chooser.getSelectedFile();
			
			System.out.println("선택한 파일: " + select.getAbsolutePath());
		}
		
	}
}
