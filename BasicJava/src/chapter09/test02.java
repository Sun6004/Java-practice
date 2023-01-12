package chapter09;

import java.util.Random;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class test02 {

	public static void main(String[] args) {
		Random random = null; //아직은 아무것도 참조하고싶지 않을때 null로 우선 초기화
		
		//메모리 사용영역 
		String a = "홍길동";//"홍길동"을 스택에 저장해두고 a가 그 주소값을 가짐
		String b = new String("홍길동");//새로운 주소에 저장 new=1
		String c = "홍길동"; //
		
		System.out.println(a == c);//힙 영역안에 string풀 안에 a,c가 같이저장되어있으므로true
		System.out.println(a == b);//저장된 위치가 달라 false
		//참조 변수의 ==,!= 연산은 동일한 객체를 참조하는지를 조사.
		System.out.println(a.equals(c));
		
		//문자열비교
		String strVar1 = "신민철";
		String strVar2 = "신민철";
		
		if(strVar1 == strVar2) {
			System.out.println("참조가 같음");
		}else {
			System.out.println("참조가 다름");
		}
		
		if(strVar1.equals(strVar2)) {
			System.out.println("문자열 같음");
		}
		
		String strVar3 = new String("신민철");
		String strVar4 = new String("신민철");
		
		if(strVar3 == strVar4) {
			System.out.println("참조가 같음");
		}else {
			System.out.println("참조가 다름");
		}
		
		if(strVar3.equals(strVar4)) {
			System.out.println("문자열이 같음");
		}else {
			System.out.println("문자열이 다름");
		}
		
		
	}

}
