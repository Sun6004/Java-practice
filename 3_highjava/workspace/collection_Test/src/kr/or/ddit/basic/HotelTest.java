//package kr.or.ddit.basic;
//
//import java.util.HashMap;
//import java.util.Scanner;
//
//public class HotelTest {
//	
//	String room;
//	static int roomNum;
//	private static String name;
//	
//	
//	static Scanner sc = new Scanner(System.in);
//	static HashMap<Integer,Room > map = new HashMap<>();
//	
//	//main
//	public static void main(String[] args) {
//		System.out.println("**************************************");
//		System.out.println("   호텔문을 열었습니다. 어서오십시오. ");
//		System.out.println("**************************************");
//		
//		new HotelTest(name, roomNum).start();
//	}
//	
//	public void start() {
//		menu();
//	}
//	
//	public HotelTest(String room, int roomNum) {
//		super();
//		this.room = room;
//		this.roomNum = roomNum;
//		
//		if(roomNum>200 && roomNum<210) {
//			room = "싱글룸";
//		}else if(roomNum>300 && roomNum<310) {
//			room = "더블룸";
//		}else if(roomNum>400 && roomNum<410) {		
//			room = "스위트룸";
//		}
//	}
//	private int menu() {
//		
//		System.out.println("-----------------------------------------------------------");
//		System.out.println(" 어떤 업무를 하시겠습니까?");
//		System.out.println(" 1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료");		
//		System.out.println("-----------------------------------------------------------");
//		System.out.print("선택: ");
//		int choice = sc.nextInt();
//		
//		switch (choice) {
//		case 1:
//			check();
//			break;
//		case 2:
//			checkOut();
//			break;
//		case 3:
//			serchRoom();
//			break;
//		case 4:
//			System.out.println("**************************************");
//			System.out.println("   		호텔문을 닫았습니다. 		  ");
//			System.out.println("**************************************");
//			System.exit(0);
//			break;
//
//		default:
//			
//			break;
//		}
//		
//		return 0;
//		
//	}
//	private static void serchRoom() {
//		System.out.println("----------------------------------------------");
//		System.out.println("		현재 객실 상태");
//		System.out.println("----------------------------------------------");
//		System.out.println("방 번호	 방 종류	 투숙객 이름");
//		System.out.println("----------------------------------------------");
//		for (Integer key : map.keySet()) {
//			Room value = map.get(key);
//			
//			System.out.println(key + ":" + value);
//		}
//	}
//	private static void checkOut() {
//		System.out.println("----------------------------------------------");
//		System.out.println("   체크아웃 작업");
//		System.out.println("----------------------------------------------");
//		System.out.println("체크아웃 할 방 번호를 입력하세요.");
//		System.out.print("방번호 입력: ");
//		int cNum = sc.nextInt();
//		if(map.containsKey(cNum) ==true) {
//			map.remove(cNum);
//			System.out.println(cNum+"호 객실의"+name+"님 체크아웃을 완료하였습니다.");
//		}else {
//			System.out.println(cNum+"호 객실에는 투숙객이 없습니다.");
//			return;
//		}
//	}
//	private static void check() {
//		System.out.println("----------------------------------------------");
//		System.out.println("   체크인 작업");
//		System.out.println("----------------------------------------------");
//		System.out.println("* 201~209 : 싱글룸");
//		System.out.println("* 301~309 : 더블룸");
//		System.out.println("* 401~409 : 스위트룸");
//		System.out.println("----------------------------------------------");
//		System.out.print("방 번호 입력: ");	
//		int choiceRoom = sc.nextInt();
//		//사용중인 객실인지 확인
//		if(map.containsKey(roomNum) ==true) {
//			System.out.println(roomNum+"호 객실은 이미 손님이 있습니다.");
//		}
//		if(choiceRoom>200 && choiceRoom<210) {
//			System.out.println("");
//			System.out.println("누구를 체크인 하시겠습니까?");
//			System.out.print("이름입력: ");
//			name = sc.nextLine();
//			System.out.println("체크인이 완료되었습니다.");	
//			//map.put(choiceRoom, Room);
//		}else if(choiceRoom>300 && choiceRoom<310) {
//			System.out.println("");
//			System.out.println("누구를 체크인 하시겠습니까?");
//			System.out.print("이름입력: ");
//			name = sc.nextLine();
//			System.out.println("체크인이 완료되었습니다.");		
//			//map.put(null, name);
//		}else if(choiceRoom>400 && choiceRoom<410) {
//			System.out.println("");
//			System.out.println("누구를 체크인 하시겠습니까?");
//			System.out.print("이름입력: ");
//			name = sc.nextLine();
//			System.out.println("체크인이 완료되었습니다.");
//			//map.put(null, name);
//		}else {
//			System.out.println(choiceRoom+"호 객실은 존재하지 않습니다.");
//			return;
//		}		
//	}
//	
//}
//class Room{
//	int roomNum;
//	String room;
//	String name;
//	
//	
//	public Room() {
//		super();
//	}
//	
//	public Room(String room, String name) {
//		super();
//		this.room = room;
//		this.name = name;
//	}
//
//	public Room(int roomNum, String room, String name) {
//		super();
//		this.roomNum = roomNum;
//		this.room = room;
//		this.name = name;
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
//		return "Room [roomNum=" + roomNum + "\t room=" + room + "\t name=" + name + "]";
//	}
//}
