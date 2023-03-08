package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class PhoneBookTest {
	//	 - 추가조건)
	//	  
	//	  1. 6. 전화번호저장 메뉴를 추가하고 구현한다.(저장파일명은'phoneData.bin)
	//	  2. 프로그램이 시작될 때 저장된 파일이 있으면 그 데이터를 읽어와 Map에 저장한다.
	//	  3. 프로그램을 종료할 때 Map의 데이터의 변화가 있으면(데이터의 추가, 수정, 삭제작업 후 저장하지 않은 상태) 자료를 저장한 후 종료되도록 한다.
	
	private HashMap<String, Phone> phoneBookMap;
	   private Scanner scanner;
	   
	   public PhoneBookTest() {
	      phoneBookMap = new HashMap<>();
	      scanner = new Scanner(System.in);
	   }
	   
	   public static void main(String[] args) {
	      new PhoneBookTest().phoneBookStart();
	   }
	   
	   private void phoneBookStart() {
	      System.out.println("*****************************************");
	      System.out.println("  전 화 번 호 관 리 프 로 그 램  ");
	      System.out.println("*****************************************");
	      System.out.println();
	      
	      while (true) {
	         int choice = disPlayMenu();
	         switch (choice) {
	         case 1:
	            insert();
	            break;
	         case 2:
	            update();
	            break;
	         case 3:
	            delete();
	            break;
	         case 4:
	            search();
	            break;
	         case 5:
	            disPlayAll();
	            break;
	         case 6:
	        	 save();
	        	 break;            
	         case 0:
	            System.out.println("시스템을 종료합니다 감사합니다...");
	            return;
	         default:
	            
	            break;
	         }
	      }
	   }
	   

	public int disPlayMenu() {
	      System.out.println("--------------------------------------");
	      System.out.println("다음 메뉴를 선택하세요.");
	      System.out.println("1. 전화번호 등록");
	      System.out.println("2. 전화번호 수정");
	      System.out.println("3. 전화번호 삭제");
	      System.out.println("4. 전화번호 검색");
	      System.out.println("5. 전화번호 전체 출력");
	      System.out.println("6. 현재 전화번호부 저장");
	      System.out.println("0. 프로그램 종료");
	      System.out.println("--------------------------------------");
	      System.out.print("번호입력 >> ");
	      return Integer.parseInt(scanner .nextLine());
	   }
	   
	private void save() {
		try {
			FileOutputStream fo = new FileOutputStream("d:/d_Other/phoneData.bin");
			BufferedOutputStream bout = new BufferedOutputStream(fo);
			ObjectOutputStream out = new ObjectOutputStream(bout);
			
			System.out.println("전화번호 저장을 시작합니다.");
			out.writeObject(phoneBookMap);
			out.writeObject(null);
			
			System.out.println("전화번호 저장 완료");
			
			out.close();
			bout.close();
			fo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	   private void insert() {
	      System.out.println();
	      System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
	      System.out.print("이 름 > ");
	      String name = scanner.nextLine();
	      
	      if(phoneBookMap.containsKey(name)) {
	         System.out.println(name + "씨는 이미 등록된 사람입니다.");
	         return ;
	      }
	      
	      System.out.print("전 화 번 호 > ");
	      String tel = scanner.nextLine();
	      
	      System.out.print("주 소 > ");
	      String addr = scanner.nextLine();
	      
	      phoneBookMap.put(name, new Phone(name, tel, addr));         
	      System.out.println(name + "씨 전화번호 정보 등록 완료!!!");
	   }
	   
	   private void update() {
	      System.out.println();
	      System.out.println("수정할 전화번호 정보를 입력하세요...");
	      System.out.print("이 름 > ");
	      String name = scanner.nextLine();
	      
	      if(!(phoneBookMap.containsKey(name))) {
	         System.out.println(name + "씨는 전화번호 정보가 등록되지 않은 사람입니다...");
	         return;
	      }
	      System.out.println("새로운 전화번호 > ");
	      String newTel = scanner.nextLine();
	      
	      System.out.println("새로운 주소 > ");
	      String newAddr = scanner.nextLine();
	      
	      phoneBookMap.put(name, new Phone(name, newTel, newAddr));
	      System.out.println(name + "씨의 전화번호 정보를 변경했습니다.");
	      
	   }
	   
	   private void delete() {
	      System.out.println();
	      System.out.println("삭제할 전화번호 정보를 입력하세요...");
	      System.out.print("이 름 > ");
	      String name = scanner.nextLine();
	      
	      if(!(phoneBookMap.containsKey(name))) {
	         System.out.println(name + "씨는 전화번호 정보가 등록되지 않은 사람입니다...");
	         return;
	      }
	      
	      phoneBookMap.remove(name);
	      System.out.println(name + "씨의 전화번호 정보를 삭제되었습니다.");
	   }
	   
	   private void search() {
	      System.out.println();
	      System.out.println("검색할 전화번호 정보를 입력하세요...");
	      System.out.print("이 름 > ");
	      String name = scanner.nextLine();
	      
	      if(!(phoneBookMap.containsKey(name))) {
	         System.out.println(name + "씨는 전화번호 정보가 등록되지 않은 사람입니다...");
	         return;
	      }
	      Phone p = phoneBookMap.get(name);
	      System.out.println(name + "씨의 전화번호 정보");
	      System.out.println("-----------------------------------");
	      System.out.println("이 름 : " + p.getName());
	      System.out.println("전 화 : " + p.getTel());
	      System.out.println("주 소 : " + p.getAddr());
	      System.out.println("-----------------------------------");
	      System.out.println();
	      
	   }
	   
	   private void disPlayAll() {
	      System.out.println("--------------------------------------");
	      System.out.println("번호\t이 름\t전화번호\t주소");
	      System.out.println("--------------------------------------");
	      Set<String> keySet = phoneBookMap.keySet();
	      if (keySet.size() == 0) {
	         System.out.println(" 등록된 전화번호 정보가 하나도 없습니다.");
	      } else {
	         int num = 0;
	         for (String name : keySet) {
	            num++;
	            Phone p = phoneBookMap.get(name);
	            System.out.println(num + "\t  " + p.getName() + "\t  " + p.getTel() + "\t" + p.getAddr() + "\n");
	         }
	      }
	   }
	}

	class Phone{
	   private String name;
	   private String tel;
	   private String addr;
	   
	   public Phone(){};
	   
	   public Phone(String name, String tel, String addr) {
	      super();
	      this.name = name;
	      this.tel = tel;
	      this.addr = addr;
	   }
	   
	   public String getName() {
	      return name;
	   }
	   
	   public void setName(String name) {
	      this.name = name;
	   }
	   
	   public String getTel() {
	      return tel;
	   }
	   
	   public void setTel(String tel) {
	      this.tel = tel;
	   }
	   
	   
	   public String getAddr() {
	      return addr;
	   }
	   
	   public void setAddr(String addr) {
	      this.addr = addr;
	   }
	   
	   @Override
	   public String toString() {
	      return String.format("Phone [name=%s, tel=%s, addr=%s]", name, tel, addr);
	   }
	}
