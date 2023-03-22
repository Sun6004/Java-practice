package basic;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//myBatis를 이용하여 DB자료를 처리하는 순서 및 방법
public class LprodMybatisTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1. myBatis의 환경 설정 파일을 읽어와서 실행한다.(Config.xml)
		
		Reader rd = null;
		SqlSessionFactory sqlSessionFactory = null;
		
		try {
			// 1-1. 환경 설정 파일을 읽어 올 스트림 객체를 생성한다.
			// (이 때 읽어올 환경설정 파일을 지정해 준다.)
			rd = Resources.getResourceAsReader("mybatis/config/Config.xml");
			
			// 1-2. 환경 설정 파일을 읽어와 환경 설정을 완성한 후 SQL문을 호출해서 실행할 수 있는
			// 		객체를 생성하는 SqlSessionFactory객체를 생성한다.
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(rd);
		} catch (Exception e) {
			System.out.println("myBatis 초기화 실패ㅜ");
			e.printStackTrace();
		}finally {
			if(rd != null) {
				try {
					rd.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		//2. mapper에 등록된 SQL문 중에서 실행 할 SQL문을 호출해서 원하는 작업을 수행한다.
		
		SqlSession session = null; //SqlSession객체: 실제 sql문을 읽어와 처리하고 결과를 얻어오는 객체
		
		//2-1. insert 작업
//		System.out.println("insert start");
//		
//		System.out.print("Lprod_id입력: ");
//		int lprodId = sc.nextInt();
//		
//		System.out.print("Lprod_gu입력: ");
//		String lprodGu = sc.next();
//		
//		System.out.print("Lprod_nm입력: ");
//		String lprodNm = sc.next();
//		
//		//입력한 데이터를 Vo에 저장한다.
//		LprodVO vo = new LprodVO();
//		vo.setLprod_id(lprodId);
//		vo.setLprod_gu(lprodGu);
//		vo.setLprod_nm(lprodNm);
//		
//		try {
//			// SqlSessionFactory 객체를 이용하여 SqlSession 객체를 구한다.
//			//		=> openSession()메서드를 이용한다.
//			// 형식) SqlSessionFactory객체.openSession(논리값)
//			//		=> '논리값'이 true면 'AutoCommit'이 활성화된 상태이고,
//			//		=> 논리값이 false면 AutoCommit이 비활성화 상태 (기본값)
//			session = sqlSessionFactory.openSession();
//			
//			// SQlSession객체변수를 이용하여 처리할 sql문을 호출해서 실행
//			// 형식) session.insert("namespace속성값.id속성값",파라미터클래스)
//			//		 ==> 반환값: 작업에 성공한 레코드 수
//			int insertCnt = session.insert("lprod.insertLprod", vo);
//			
//			if(insertCnt > 0) {
//				System.out.println("insert Susses");
//			}else {
//				System.out.println("insert false");
//			}
//			
//		} finally {
//			//SqlSession을 생성할 때 AutoCommit이 비활성화 된 상태일 때는 commit을 직접 실행해야 한다.
//			session.commit();
//			
//			// 작업이 완료되면 SqlSession 객체를 닫아준다.
//			session.close();
//		}
//	
		
//		//2-2. update연습
//		System.out.println("update start");
//
//		System.out.print("수정할 Lprod_gu입력: ");
//		String lprodGu2 = sc.next();
//		
//		System.out.print(" 새로운 Lprod_id입력: ");
//		int lprodId2 = sc.nextInt();
//		
//		
//		System.out.print("새로운 Lprod_nm입력: ");
//		String lprodNm2 = sc.next();
//		
//		// 입력 받은 데이터를 VO객체에 저장한다.
//		LprodVO vo = new LprodVO();
//		vo.setLprod_gu(lprodGu2);
//		vo.setLprod_id(lprodId2);
//		vo.setLprod_nm(lprodNm2);
//		
//		try {
//			session = sqlSessionFactory.openSession();
//		
//		// SQlSession객체변수를 이용하여 처리할 sql문을 호출해서 실행
//			// 형식) session.update("namespace속성값.id속성값, 파라미터클래스)
//			//		==> 반환값: 작업에 성공한 레코드 수
//			int updateCnt = session.update("lprod.updateLprod", vo);
//			
//			if(updateCnt>0) {
//				System.out.println(" Update 성공");
//			}else {
//				System.out.println("업데이트 실패");
//			}
//			
//		} finally {
//			session.commit();
//			session.close();
//		}
		
		//2-3. delete연습
		
//		System.out.println("delete start");
//		
//		System.out.print("삭제할gu입력: ");
//		String lprodGu3 = sc.next();
//		
//		try {
//			session = sqlSessionFactory.openSession();
//			
//			//SQlSession객체변수를 이용하여 처리할 sql문을 호출해서 실행
//			//형식) session.update("namespace속성값.id속성값, 파라미터클래스)
//			// 반환값: 작업에 성공한 레코드 수
//			int delCnt = session.delete("lprod.deleteLprod",lprodGu3);
//			if(delCnt>0) {
//				System.out.println("삭제성공");
//			}else {
//				System.out.println("삭제실패");
//			}
//		}catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			session.commit();
//			session.close();
//		}
		
		//2-4 select작업
		
		//1)처리한 결과가 여러개의 레코드일 경우
//		System.out.println("select start 결과가 여러개일 경우");
//		try {
//			session = sqlSessionFactory.openSession();
//			
//			// SQlSession객체변수를 이용하여 처리할 sql문을 호출해서 실행
//			// select문의 처리 결과가 여러개일 경우에는 selectList()메서드를 사용하는데
//			// 이 메서드는 여러개의 레코드 각각을 VO객체에 담은 후 이 vo객체를 List에 추가해 주는
//			// 작업을 자동으로 수행한다.
//			// 형식) session.selectList("namespace속성값.id속성값", 파라미터클래스)
			// 반환값: resultType에 지정한 객체가 저장된 List객체
//			List<LprodVO> lprodList = session.selectList("lprod.selectAll");
//			
//			System.out.println("결과출력");
//			for (LprodVO vo : lprodList) {				
//				System.out.println("id: " + vo.getLprod_id());
//				System.out.println("gu: " + vo.getLprod_gu());
//				System.out.println("nm: " + vo.getLprod_nm());
//				System.out.println("-----------------------------");
//			}
//			System.out.println("출력끝");
					
//		} finally {
//			session.close();
//		}
		
		//2) 처리한 결과가 한개의 레코드일 경우
		
		System.out.println("select start 결과가 한개일 경우");
		
		System.out.print("gu입력: ");
		String gu4 = sc.next();
		try {
			
			session = sqlSessionFactory.openSession();
			
			//select문의 처리 결과가 1개일 경우에는 selectOne() 메서드를 사용한다.
			// 형식) session.selectOn("namespace속성값.id속성값", 파라미터클래스)
			//		반환값: resultType에 설정한 자료형으로 반환한다.
			// 				검색할 자료가 없으면 null을 반환한다.
			LprodVO vo2 = session.selectOne("lprod.getLprod",gu4);
			
			if(vo2 ==null) {
				System.out.println("검색된 데이터가 존재하지 않습니다.");
			}else{
				System.out.println("id: " + vo2.getLprod_id());
				System.out.println("gu: " + vo2.getLprod_gu());
				System.out.println("nm: " + vo2.getLprod_nm());
				System.out.println("-----------------------------");
				System.out.println("출력끝");
			}
		} finally {
			session.close();
		}
	}	
}

