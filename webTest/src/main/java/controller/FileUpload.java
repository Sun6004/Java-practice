package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import service.FileinfoServiceImpl;
import service.IFileinfoService;
import vo.FileinfoVO;

/*
 * -Servlet 3.0이상에서 파일 업로드를 하려면 작성하는 서블릿에 @MultipartConfig 애노테이션을 설정해야 한다.
 * 
 * -@MultipartConfig의 설정 값들
 * 1)location: 업로드한 파일이 임시적으로 저장될 경로를 지정한다. (기본값:"")
 * 2)fileSizeThreshold: 이 곳에 지정한 값보다 큰 파일이 전송되면 location에 지정한 임시 디렉토리에 저장한다.
 * 						(단위: byte, 기본값: 0(무조건 임시 디렉토리 사용))
 * 3) maxFileSize: 1개 파일의 최대 크기(단위: byte, 기본값: -1L(무제한))
 * 4) maxRequestSize: 서버로 전송되는 전체 Request데이터의 전체 최대 크기(단위: byte, 기본값: -1(무제한))
 */
@WebServlet("/fileUpload.do")
@MultipartConfig(
		fileSizeThreshold = (1024*1024)*10, maxFileSize = (1024*1024)*30,
		maxRequestSize = (1024*1024)*100
		)
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//파일 입력 폼을 보여주는 view페이지로 이동
		request.getRequestDispatcher("/basic/json/fileUpload.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("파일 업로드 post방식~");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		// 업로드된 파일이 저장될 폴더 설정 
		String uploadPath = "d:/d_other/uploadFiles";
		
		// 저장될 폴더가 없으면 새로 만든다.
		
		java.io.File f = new java.io.File(uploadPath);
		if(!f.exists()) {
			f.mkdirs();
		}
		
		//파일이 아닌 일반 데이터는 getParameter()메서드나 getParametetValues() 메서드를 이용해서 구한다.
		String userName = request.getParameter("username");
		System.out.println("일반 파라미터 데이터: "+ userName);
		
		// 수신받은 파일 데이터 처리하기
		String fileName = ""; // 파일명이 저장될 변수 선언
		
		// 수신 받은 파일이 여러개일 때 Upload한 파일 목록이 저장될 List객체 생성
		List<FileinfoVO> list = new ArrayList<>();
		
		/*
		 * - Servlet 3.0이상에서 새롭게 추가된 Upload용 메서드
		 *  1) request.getParts() ==> 전체 Part객체를 Collection객체에 담아서 반환한다.
		 *  2) request.getPart("part이름") ==> 지정된 'part이름'을 가진 개별 Part객체를 반환한다.
		 *  		'part이름' ==> <form>태그 안의 입력 요소의 name속성값으로 구별한다.
		 */
		
		// 전체 part객체 개수만큼 반복 처리하기
		for(Part part : request.getParts()) {
			
		}
		for (Part part : request.getParts()) {
			fileName = extractFileName(part);
			
			//찾은 파일명이 빈문자열이면 이것은 파일이 아닌 일반 파라미터 데이터라는 의미
			if(!"".equals(fileName)) { //파일인지 검사
				//1개의 Upload파일에 대한 정보를 저장하기 위한 VO객체 생성
				FileinfoVO vo = new FileinfoVO();
				
				vo.setFILE_WRITER(userName); // 작성자 데이터 저장
				vo.setORIGIN_FILE_NAME(fileName); // 실제 파일명을 Vo에 저장
				
				// 실제 저장되는 파일 이름이 중복되는 것을 방지하기 위해서 UUID객체를 이용하여
				// 저장할 파일명을 만든다.
				String saveFileName = UUID.randomUUID().toString()+ "_"+fileName;
				
				// 이 값을 VO에 저장 파일명으로 저장한다.
				vo.setSAVE_FILE_NAME(saveFileName);
				
				// part.getSize(); ==> Upload된 파일의 크기를 반환한다. (단위 : byte)
				
				// 파일 크기를 구해서 Kb단위로 변환해서 vo에 저장한다.
				vo.setFILE_SIZE((long)Math.ceil(part.getSize()/1024.0));
				
				// 수신 받은 파일 내용을 저장한다.
				try {
					// part.write() 메서드 ==> Upload된 파일을 저장하는 메서드
					part.write(uploadPath + File.separator + saveFileName); // 파일 저장하기
				} catch (Exception e) {
					e.printStackTrace();
				}
				list.add(vo);
			} //if
		}//for
		
		//list에 저장된 파일 정보를 db에 insert한다.
		IFileinfoService service = FileinfoServiceImpl.getInstance();
		
		for (FileinfoVO vo : list) {
			service.insertFileinfo(vo);
			
		}
		
		// 저장이 완료된 후에는 파일 목록을 보여주는 페이지로 이동한다.
		response.sendRedirect(request.getContextPath()+"/filelist.do");
		
	}//doPost() end
	//------------------------------------------------------
	/*
	 *  -Part구조
	 *  1) 파일이 아닌 일반 데이터일 경우
	 *  ------------------------------1234539xcsapodkop231 ==> Part를 구분하는 구분선(뒤의 값은 난수)
	 *  content-disposition : form-data; name="username" ==> 파라미터명
	 *  					==> 빈줄
	 *  Hong				==> 파라미터 값
	 *  
	 *  2) 파일일 경우
	 *  ------------------------------1234539xcsapodkop231 ==> Part를 구분하는 구분선(뒤의 값은 난수)
	 *  content-dispostion: form-data; name="upFile"; filename="test1.txt" ==> 파일정보
	 *  content-type: text/plain 	==> 파일의 종류
	 *  				==> 빈줄
	 *  abcd1234ㅎㅇ 	==> 파일의 내용-
	 */	
	//------------------------------------------------------

	// Part구조 안에서 파일명을 찾는 메서드
	private String extractFileName(Part part) {
		String fileName = ""; //반환한 파일명이 저장될 변수
		String headerValue = part.getHeader("content-disposition"); // 헤더의 키값을 이용하여 값을 구함
		
		String[] items = headerValue.split(";");
		for (String item : items) {
			if(item.trim().startsWith("filename")) {
				fileName = item.substring(item.indexOf("=")+2, item.length()-1);
			}
		}
		
		return fileName;
	}
}
