package kr.or.ddit.basic;

import java.util.Vector;

public class VectorTest {
	public static void main(String[] args) {
		// 벡터 객체 생성
		Vector v1 = new Vector<>();

		System.out.println("처음 크기: " + v1.size());

		// 데이터 추가하기: add(추가할 데이터)
		// 반환값: 추가성공(true) 추가실패(false)
		v1.add("aaaa");
		v1.add(new Integer(123)); // int형 데이터를 객체화(wrapper class)
		// char ==> Character
		v1.add(11111); // 벡터는 auto boxing/ auto Unboxing 지원
		v1.add('a'); // 문자 데이터
		v1.add(true); // 논리형 데이터
		boolean r = v1.add(3.14);

		System.out.println("현재 크기: " + v1.size());
		System.out.println("반환값: " + r);// 데이터 추가성공

		// 데이터 추가하기2: addElement(추가할데이터)
		// add랑 똑같음 예전에 만들어둔 프로그램과 호환을 위해 남아있는 메소드
		v1.addElement("ccc");

		System.out.println("v1: " + v1.toString());

		// 데이터 추가하기3: add(index, 데이터)
		//					 ==> 'index'번째에 '데이터'를 끼워 넣는다.
		//					 ==> 'index'는 0부터 시작한다.
		// 					==> 반환값이 없다.
		v1.add(1, "kkk");
		System.out.println("v1: " + v1.toString()); // 1번째 배열에 끼워넣어짐

		// 데이터 꺼내오기: get(index)  ==> 'index'번째 데이터를 꺼내서 반환한다.
		System.out.println("0번째 데이터: " + v1.get(0));
		System.out.println(v1.get(2));
		int temp = (int)v1.get(2); //데이터가 오브젝트로 저장되기 때문에 (int)로 형변환을 해줘야함
		System.out.println(temp);
		
		//데이터 수정하기: set(index, 새로운데이터) => index번째의 데이터를 지우고 새로운데이터로 덮어씀
		// 반환값: 원래의 데이터
		v1.set(1, "abc");
		System.out.println(v1.get(1));
		String sTemp = (String) v1.set(0, "zzzz"); //원래있던 데이터(오브젝트)가 반환되어야 하기 때문에 (String)으로 형변환
		System.out.println("v1 ==> " +v1);
		System.out.println(sTemp); //원래의 데이터 확인
		
		//데이터 삭제하기: remove(index) index번째 데이터를 삭제
		// 반환값: 삭제된 데이터
		v1.remove(0);
		System.out.println(v1);
		String dTemp = (String)v1.remove(0);
		System.out.println("삭제후:"+v1);
		System.out.println("삭제한 데이터: "+dTemp);
		
		//데이터 삭제하기 2: remove(삭제할 데이터) 직접지정
		//삭제할 데이터가 여러개이면 가장 앞 순번 배열이 삭제
		//반환값: 삭제성공/실패 true/false
		//삭제할 데이터가 정수형이거나 char형일경우 반드시 객체로 변환해서 사용해야함.
		v1.remove("ccc");
		v1.add(123);
		
		//v1.remove(123); :데이터가 아닌 인덱스 번호로 인식해서 ArrayIndex오류가 뜸
		//123을 객체화
		v1.remove(new Integer(123)); //방법1 ==>자바 1.9버전부터는 사용불가
		v1.remove(Integer.valueOf(123)); //방법2 
		System.out.println(v1);
		
		
		//v1.remove('a'); //문자의 코드값이 저장되서 ArrayIndex오류가 뜸
		v1.add('a');
		v1.remove(new Character('a'));
		v1.remove(Character.valueOf('a'));
		System.out.println(v1);
		
		v1.remove(true);
		v1.remove(3.14);
		System.out.println(v1);
		
		
		//전체 데이터 삭제하기: clear();
		v1.clear();
		System.out.println(v1);
		/*
		  제네릭 타입(Generic Type) ==> 클래스 내부에서 사용할 데이터 타입을 객체를 생성할 때
		  외부에서 지정해주는 기법으로 객체를 선언할 때 < >안에 그 객체의 내부에서 사용할 데이터의 타일을 정해주는것
		
		* 이런식으로 선언하게 되면 그 데이터 타입 이외의 다른 종류의 데이터를 저장할 수 없다. 
		* 이때 제네릭으로 선언 될 수 있는 데이터 타입은 클래스형 이어야 한다.
		* 그래서 int는 Integer, boolean은 Boolean, char는 Character 등으로 대체해서 사용해야 함.
		*/
		
		Vector<Integer> v2 = new Vector<>();  //int형 자료만 저장할 수 있는 벡터
		Vector<String> v3 = new Vector<>(); // String 형 자료만 저장할 수 있는 벡터
		
		v3.add("안녕하세요."); 
		//v3.add(2); 다른종류의 데이터를 저장하면 오류
		System.out.println(v3);
		
		String sTemp2 = v3.get(0); //처음부터 String 타입만 저장한다고 지정했기 때문에 형변환이 필요없음.
		System.out.println(sTemp2);
		
		Vector<Vector> vv = new Vector<>(); //2차원 벡터
		Vector<Vector<Vector>> vvv = new Vector<>(); //3차원 벡터도 가능.
		v3.clear();
		System.out.println(v3.size());
		
		v3.add("aaa");
		v3.add("bbb");
		v3.add("ccc");
		v3.add("ddd");
		v3.add("eee");
		
		Vector<String> v4 = new Vector<>();
		v4.add("bbb");
		v4.add("ccc");
		System.out.println(v3);
		System.out.println(v4);
		//데이터 삭제하기3: removeAll(Collection객체)
		// ==> 벡터의 데이터 중에서 'Collection객체' 가 가지고 있는 모든 데이터를 삭제한다.
		// ==> 반환값: 삭제 성공/실패 true/false
		
		v3.removeAll(v4); //v3의 데이터 중에서 v4가 가지고있는 데이터를 모두 삭제한다.
		System.out.println("v3 : " +v3);
		System.out.println("---------------------------------------");
		
		
		//벡터의 데이터를 순서대로 모두 가져와 사용하고 싶으면 반복문을 사용하면 된다.
		//(주로 for문 사용)
		v3.clear();
		
		v3.add("aaa");
		v3.add("bbb");
		v3.add("ccc");
		v3.add("ddd");
		v3.add("eee");
		
		for (int i = 0; i < v3.size(); i++) {
			System.out.println(i+"번째 자료" + v3.get(i));
		}
		System.out.println("---------------------------------------");
		
		//향상된 for문
		for (String str : v3) {
			System.out.println(str);
		}
		

	}
}
