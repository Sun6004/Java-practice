package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class SetTest {
	public static void main(String[] args) {
	/*
	*  -list와 set의 차이점
	* 1.List
	*  - 데이터의 순서(index)가 있다.
	*  - 중복되는 데이터를 저장할 수 있다.
	*  
	*  2.Set
	*   - 데이터의 순서(index)가 없다.
	*   - 중복되는 데이터를 저장할 수 없다.
	*/
		HashSet hs1 = new HashSet<>();
		//Set에 데이터를 추가할 때도 add()메소드를 이용한다.
		hs1.add("dd");
		hs1.add("aa");
		hs1.add(123);
		hs1.add("cc");
		hs1.add(1);
		hs1.add(3);
		
		//추가한 순서와 출력문으로 나오는 순서가 다를 수 있음.
		System.out.println("Set에 있는 데이터: "+hs1);
		System.out.println("Set의 개수: "+ hs1.size());
		//Set에 중복되는 데이터를 추가하면 false를 반환하고 데이터는 추가되지 않음.
		boolean isAdd = hs1.add("ff");
		System.out.println("중복되지 않는 데이터 추가: " + isAdd+ "/" + hs1);
		
		isAdd = hs1.add("aa");
		System.out.println("중복되는 데이터 추가: " + isAdd+ "/" + hs1);
		System.out.println("=================================================");
		
		//Set의 데이터 수정 ==> Set에는 데이터를 수정하는 메소드가 존재하지 않음.
		// 따라서 수정하려면 해당 자료를 삭제한 후에 추가해주는 방법밖에 없다.
		
		//데이터삭제 (반환값: true/false)
		//remove => 삭제할 데이터 선택/ clear() => 전체 데이터 삭제
		hs1.remove("aa");
		System.out.println("삭제한 후:"+hs1);
		/*hs1.clear();
		System.out.println("clear 후: " +hs1);*/
		
		/*   Set 의 데이터 꺼내오기
		 * Set의 데이터는 순서가 없기 때문에list처럼 불러올 데이터를 index로 선택할 수 없다
		 * 그래서 데이터를 하나씩 차례로 얻기 위해서는 Iterator형 객체로 변환해야 함.
		 * 
		 * -Set 형의 데이터들을 Iterator형 객체로 변환하는 메소드 => Iterator()
		 */
		
		Iterator it = hs1.iterator(); //Set데이터를 Iterator로 변환하기
		
		/*
		  Iterator의 hasNext() 메소드 => Iterator의 포인터가 가르키는 곳의 다음번째에 데이터가 있는지 검사
		  - 데이터가 있으면 true 없으면 false 를 반환
		 */
		while(it.hasNext()) { //hasNext가 true가 되면 while문이 실행
			/* Iterator의 next()메소드 
			 *   => Iterator의 포인터를 다음번째 위치로 이동시킨 후 그곳의 데이터를 꺼내서 반환 */
			System.out.println(it.next());//데이터가 없을때까지 반복
		}
			
		System.out.println("=================================================");
		//foreach 문을 사용해서 데이터를 차례로 가져오기
		for (Object obj : hs1) { //Set을 만들때 제네릭을 지정했으면 Object자리에 제네릭입력
			System.out.println(obj);
		}
		
		System.out.println("=================================================");
		
		//우리반 학생들 중 번호를 이용하여 추첨하는 프로그램을 작성해 보시오.
		//번호:1~28번까지 있고, 추첨할 인원이 3명이다.
		Random rand = new Random();
		//int num = rand.nextInt((28)+1);
		//36~ 77
		//rand.nextInt((41 +1)+36); (최대값-최소값+1)+최소값;
		
		HashSet<Integer> testSet = new HashSet<>();
		while (testSet.size() <3 ) {
			testSet.add(rand.nextInt(28)+1);
		}
		System.out.println("당첨자 번호: " + testSet);
		
		//Set유형의 자료를 List형으로 변환하기
		ArrayList<Integer> testList = new ArrayList<>(testSet);
		for (int i = 0; i < testList.size(); i++) {
			System.out.println(testList.get(i));
		}
	}

	
}
