package myMember.dao;

import java.util.List;

import myMember.vo.MyMemberVO;

public interface MyMemberDao {

	public List<MyMemberVO> getMemberList();
	
	public int insertMember(MyMemberVO vo);
	
	public MyMemberVO getMember(String memId);
	
	public int updateMember(MyMemberVO vo);
	
	public int delMember(String memId);
	
	public MyMemberVO getPhoto(int memId);
}
