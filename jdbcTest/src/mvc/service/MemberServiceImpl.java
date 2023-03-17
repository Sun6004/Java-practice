package mvc.service;

import java.util.List;

import mvc.dao.IMemberDao;
import mvc.dao.MemberDaoimpl;
import mvc.vo.MemberVO;

public class MemberServiceImpl implements IMemberService{

	//일을시킬 DAO객체변수 선언
	private IMemberDao dao;
	
	
	public MemberServiceImpl() {
		dao = new MemberDaoimpl(); //객체생성
	}

	
	public int insertMember(MemberVO memVo) { 
		return dao.insertMember(memVo);
	}

	
	public int deleteMember(String memId) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int updateMember(MemberVO memVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public List<MemberVO> getAllMember() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int getMemberCount(String memId) {
		
		return dao.getMemberCount(memId);
	}

}
