package memberDao;

import org.apache.ibatis.session.SqlSession;

import memberVo.MemberVO;
import util.MybatisSqlsessionFactory;

public class MemberDao {
	private static MemberDao dao;
	
	private MemberDao() {
		
	}
	
	public static MemberDao getInstance() {
		if(dao == null) dao = new MemberDao();
		return dao;
	}
	
	public MemberVO getMember(MemberVO memVo) {
		SqlSession session = null;
		MemberVO loginMembeVo = null; //반환값이 저장될 변수
		
		try {
			session = MybatisSqlsessionFactory.getSqlSession();
			
			loginMembeVo = session.selectOne("member.getMember", memVo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
//			session.commit();
			session.close();
		}
		
		return loginMembeVo;
	}
}
