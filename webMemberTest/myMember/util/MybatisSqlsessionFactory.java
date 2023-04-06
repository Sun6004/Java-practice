package util;
/**
 * myBatis의 환경 설정 파일(mybatis-config.xml)을 읽어와서 실행하고
 * SqlSession객체를 반환하는 메서드를 갖는 클래스
 * @author PC-10
 *
 */

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisSqlsessionFactory {
	private static SqlSessionFactory sqlSessionFactory = null;
	
	static {
		Reader rd = null;
		
		try {
			rd = Resources.getResourceAsReader("config/Config.xml");
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(rd);
		} catch (Exception e) {
			System.out.println("myBatis초기화 실패");
			e.printStackTrace();
		}finally {
			if(rd != null) {
				try {
					rd.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 
	 * @return
	 */
	public static SqlSession getSqlSession() {
		SqlSession session = sqlSessionFactory.openSession();
		return session;
	}
}
