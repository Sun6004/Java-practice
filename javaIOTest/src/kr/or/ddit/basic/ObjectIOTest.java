package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectIOTest {
	public static void main(String[] args) {
		//Member의 인스턴스 생성
		Member mem1 = new Member("홍길동",20,"대전");
		Member mem2 = new Member("홍길서",23,"서울");
		Member mem3 = new Member("홍길남",24,"강릉");
		Member mem4 = new Member("홍길북",25,"부산");
		
		try {
			//객체를 파일에 저장하기
			FileOutputStream fout = new FileOutputStream("d:/d_Other/memObj.bin");
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			ObjectOutputStream obj = new ObjectOutputStream(bout);
			
			//쓰기 작업(저장작업)
			System.out.println("객체 저장 시작..");
			obj.writeObject(mem1);
			obj.writeObject(mem2);
			obj.writeObject(mem3);
			obj.writeObject(mem4);
			obj.writeObject(null); //마지막에null값을 적장하면 읽어올때 EOF오류를 방지할 수 있다.
			
			
			System.out.println("객체 저장 끝..");
			
			obj.close(); //스트림닫기
			
			//저장된 객체를 읽어와 그 내용을 화면에 출력하기
			
			//입력용 스트림 객체 생성
			ObjectInputStream oin = new ObjectInputStream(new BufferedInputStream(new FileInputStream("d:/d_Other/memObj.bin")));
			
			Object ob; //읽어온 객체를 저장한 변수
			
			System.out.println("객체 읽기 작업을 시작합니다..");
			
			// readObject 메서드는 데이터를 끝까지 다 읽으면 EOFException을 발생함.
			while( (ob = oin.readObject())!=null ) {
				//읽어온 데이터를 원래의 객체형으로 형변환 후 사용한다.
				Member mem = (Member)ob;
				
				System.out.println("----------------------------------");
				System.out.println("이름: " + mem.getName());
				System.out.println("나이: " + mem.getAge());
				System.out.println("주소: " + mem.getAddr());
			}
			
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Member implements Serializable{
	
	// transient ==> 직렬화가 되지 않을 멤버변수에 지정
	private String name;
	private transient int age;
	private String addr;
	
	public Member(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}