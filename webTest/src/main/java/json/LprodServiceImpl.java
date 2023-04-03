package json;

import java.util.List;

public class LprodServiceImpl implements LprodService{
	
	private static LprodDao dao;
	
	private static LprodServiceImpl service;
	private LprodServiceImpl() {
		dao = LprodDaoImpl.getInstance();
	}
	
	public static LprodServiceImpl getInstance() {
		if(service==null) service = new LprodServiceImpl();
		return service;
	}
	
	@Override
	public List<LprodVO> getLprodList() {
		// TODO Auto-generated method stub
		return dao.getLprodList();
	}
	
}
