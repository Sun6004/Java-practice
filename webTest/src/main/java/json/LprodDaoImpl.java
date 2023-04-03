package json;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import util.MybatisSqlsessionFactory;

public class LprodDaoImpl implements LprodDao{
	SqlSession session = null;
	
	private static LprodDaoImpl dao;
	
	private LprodDaoImpl() {
	}
	
	public static LprodDaoImpl getInstance() {
		if(dao ==null) dao = new LprodDaoImpl(); {
			
			return dao;
		}
	}
	@Override
	public List<LprodVO> getLprodList() {
		SqlSession session = null;
		List<LprodVO> list = null;
		try {
			session = MybatisSqlsessionFactory.getSqlSession();
			list = session.selectList("lprod.getLprod");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		return list;
		
	}
	
}
