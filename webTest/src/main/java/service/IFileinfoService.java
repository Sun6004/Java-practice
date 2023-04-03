package service;

import java.util.List;

import vo.FileinfoVO;

public interface IFileinfoService {
	/**
	 * fileinfoVO에 저장된 자료를 db에 insert
	 * @param fileVo insert할 자료가 저장된fileinfoVO객체
	 * @return
	 */
	public int insertFileinfo(FileinfoVO vo);
	
	/**
	 * DB에 저장된 전체 파일 정보들을 가져와 List에 담아서 가져오는 메서드
	 * @return 파일 정보가 저장된 List객체
	 */
	public List<FileinfoVO> getAllFileinfo();
	
	/**
	 * 파일번호를 인수값으로 받아서 해당 파일 정보를 검색하여 반환하는 메서드
	 * @param fileNo 검색할 파일 번호
	 * @return  
	 */
	public FileinfoVO getFileinfo(int fileNo);
}
