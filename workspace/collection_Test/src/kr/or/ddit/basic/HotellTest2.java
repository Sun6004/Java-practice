//package kr.or.ddit.basic;
//
//import java.util.HashMap;
//import java.util.Scanner;
//
//public class HotellTest2 {
//	
//Scanner sc = new Scanner(System.in);
//HashMap<Integer, Room> map = new HashMap<>();
//public static void main(String[] args) {
//	new HotellTest2().start();
//	
//}
//	public void start() {
//		System.out.println("**************************************");
//		System.out.println("   호텔문을 열었습니다. 어서오십시오. ");
//		System.out.println("**************************************");
//		mainMenu();
//	}
//	public void mainMenu() {
//		while (true) {
//			System.out.println("-----------------------------------------------------------");
//			System.out.println(" 어떤 업무를 하시겠습니까?");
//			System.out.println(" 1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료");		
//			System.out.println("-----------------------------------------------------------");
//			System.out.print("선택: ");
//			int choice = Integer.parseInt(sc.nextLine());
//			
//			switch (choice) {
//			case 1:
//				checkIn();
//				break;
//			
//			case 2:
//				checkOut();
//				break;
//			case 3:
//				serchRoom();
//				break;
//			case 4:
//				System.out.println("**************************************");
//				System.out.println("   		호텔문을 닫았습니다. 		  ");
//				System.out.println("**************************************");
//				System.exit(0);
//				break;
//
//			default:
//				
//				break;
//			}
//		}
//	}
//	private void checkIn() {
//		System.out.println("----------------------------------------------");
//		System.out.println("   체크인 작업");
//		System.out.println("----------------------------------------------");
//		System.out.println("* 201~209 : 싱글룸");
//		System.out.println("* 301~309 : 더블룸");
//		System.out.println("* 401~409 : 스위트룸");
//		System.out.println("----------------------------------------------");
//		System.out.print("방 번호 입력: ");	
//		int choiceRoom = Integer.parseInt(sc.nextLine());
//		String name = "";
//		String room = "";
//		//사용중인 객실인지 확인
//		if(map.containsKey(choiceRoom) ==true) {
//			System.out.println(choiceRoom+"호 객실은 이미 손님이 있습니다.");
//		}
//		if(choiceRoom>200 && choiceRoom<210) {
//			room = "싱글룸";
//			System.out.println("");
//			System.out.println("누구를 체크인 하시겠습니까?");
//			System.out.print("이름입력: ");
//			name = sc.nextLine();
//			System.out.println("체크인이 완료되었습니다.");	
//		}else if(choiceRoom>300 && choiceRoom<310) {
//			room = "더블룸";
//			System.out.println("");
//			System.out.println("누구를 체크인 하시겠습니까?");
//			System.out.print("이름입력: ");
//			name = sc.nextLine();
//			System.out.println("체크인이 완료되었습니다.");		
//		}else if(choiceRoom>400 && choiceRoom<410) {
//			room = "스위트룸";
//			System.out.println("");
//			System.out.println("누구를 체크인 하시겠습니까?");
//			System.out.print("이름입력: ");
//			name = sc.nextLine();
//			
//			System.out.println("체크인이 완료되었습니다.");
//		}else {
//			System.out.println(choiceRoom+"호 객실은 존재하지 않습니다.");
//			return;
//		}		
//		map.put(choiceRoom, new Room(choiceRoom, room, name));
//		
//	}
//	private void checkOut() {
//		System.out.println("----------------------------------------------");
//		System.out.println("   체크아웃 작업");
//		System.out.println("----------------------------------------------");
//		System.out.println("체크아웃 할 방 번호를 입력하세요.");
//		System.out.print("방번호 입력: ");
//		int cNum = Integer.parseInt(sc.nextLine());
//		
//		if(map.containsKey(cNum) ==true) {
//			map.remove(cNum);
//			System.out.println(cNum+"호 객실의"+ cNum +"님 체크아웃을 완료하였습니다.");
//		}else if(!(cNum>200 && cNum<210 || cNum>300 && cNum<310 || cNum>400 && cNum<410)) {
//			System.out.println(cNum+"호 객실은 존재하지 않습니다.");
//		}
//		else {		
//			System.out.println(cNum+"호 객실에는 투숙객이 없습니다.");
//			return;
//		}	
//	}
//	private void serchRoom() {
//		System.out.println("----------------------------------------------");
//		System.out.println("		현재 객실 상태");
//		System.out.println("----------------------------------------------");
//		System.out.println("방 번호	 방 종류	 투숙객 이름");
//		System.out.println("----------------------------------------------");
//		Room room = new Room();
//		for (int i = 1; i <= 3; i++) {
//			for (int j = 1; j <= 9; j++) {
//				int roomNum = 0;
//				if(i==1) {
//					roomNum = 200;
//				} else if (i==2) {	
//					roomNum = 300;
//				} else {
//					roomNum = 400;
//				}
//				int r = roomNum+j;
//				room.setRoomNum(r);
//			}
//		}
//		for (Integer r : map.keySet()) {
//			Room value = map.get(r);
//			
//			System.out.println(r+":"+value);
//		}
//	}
//}
//
//class Room {
//	int roomNum;
//	String room;
//	String name;
//	
//	
//	public Room() {
//		super();
//	}
//	public Room(int roomNum, String room, String name) {
//		super();
//		this.roomNum = roomNum;
//		this.room = room;
//		this.name = name;
//	}
//	public Room(int roomNum, String room) {
//		super();
//		this.roomNum = roomNum;
//		this.room = room;
//	}
//	public int getRoomNum() {
//		return roomNum;
//	}
//	public void setRoomNum(int roomNum) {
//		this.roomNum = roomNum;
//	}
//	public String getRoom() {
//		return room;
//	}
//	public void setRoom(String room) {
//		this.room = room;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	@Override
//	public String toString() {
//		return "Room [roomNum=" + roomNum + ", room=" + room + ", name=" + name + "]";
//	}
//	
//	
//}