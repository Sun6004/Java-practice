package chapter10;

import java.util.Scanner;

public class test05 {

	public static void main(String[] args) {
		
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		try (Scanner scanner = new Scanner(System.in)) {
			while(run){
				System.out.println("------------------------------------");
				System.out.println("1.학생수 |2.점수입력 |3.점수리스트 |4.분석 |5.종료");
				System.out.println("------------------------------------");
				System.out.print("선택> ");
				int sel = Integer.parseInt(scanner.nextLine());
				
				if(sel == 1) {
					System.out.print("학생수> ");
					studentNum = Integer.parseInt(scanner.nextLine());
					scores = new int[studentNum];
					
				}else if(sel == 2) {			
					for (int i=0; i <scores.length; i++) {
					System.out.print("scores[" +i+ "]> ");
					scores[i] = Integer.parseInt(scanner.nextLine());	
					}
				}else if(sel == 3) {
					for(int i=0; i <scores.length; i++) {
						System.out.println("scores[" +i+ "]:"+scores[i]);
					}	
				}else if(sel == 4) {
					int x=0;
					int tot=0;
					double avg = 0;
					for(int i=0; i <scores.length; i++) {
						if(scores[i] > x){
							x = scores[i];
						}
						tot += scores[i];
						//x = (x < scores[i]) ? scores[i] : x;
						//tot += scores[i];
					}	
					avg = (double)tot/ studentNum;
					System.out.println("최고점수: "+x);
					System.out.println("평균점수: "+avg);

				}else if(sel == 5) {

					run = false;
				}	
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("프로그램 종료");
	}

}
