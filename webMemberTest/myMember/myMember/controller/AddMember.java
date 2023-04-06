package myMember.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.print.attribute.standard.Severity;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import myMember.service.MyMemberService;
import myMember.service.MyMemberServiceImpl;
import myMember.vo.MyMemberVO;

@WebServlet("/addMember.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 30, maxRequestSize = 1024 * 1024
		* 100)

public class AddMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// 파일 입력 폼을 보여주는 View페이지로 이동
		request.getRequestDispatcher("/myMember/memAdd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      request.setCharacterEncoding("utf-8");
	      response.setCharacterEncoding("utf-8");
	      
	      String id = request.getParameter("memId");
	      String pass = request.getParameter("memPass");
	      String name =request.getParameter("memName");
	      String tel = request.getParameter("memTel");
	      String addr =request.getParameter("memAddr");
	      
	   
	      MyMemberVO vo = new MyMemberVO();
	      
	      vo.setMem_id(id);
	      vo.setMem_pass(pass);
	      vo.setMem_name(name);
	      vo.setMem_tel(tel);
	      vo.setMem_addr(addr);
	      
	   
	      String uploadPath ="d:/d_other/uploadFiles";
	      
	      // 저장될 폴더가 없으면 새로 만든다.
	      File f = new File(uploadPath);
	      if(!f.exists()) {
	         f.mkdirs();   
	       }
	      String fileName = "";
	      
	      for (Part part : request.getParts()) {
				fileName = extractFileName(part);
				
				//찾은 파일명이 빈문자열이면 이것은 파일이 아닌 일반 파라미터 데이터라는 의미
				if(!"".equals(fileName)) { 
					
					vo.setMem_photo(fileName);
				
					try {
						// part.write() 메서드 ==> Upload된 파일을 저장하는 메서드
						part.write(uploadPath + File.separator + fileName); // 파일 저장하기
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
	      
	      }
	      MyMemberService service = MyMemberServiceImpl.getInstance();
	      service.insertMember(vo);
	      
	      response.sendRedirect(request.getContextPath()+"/memList.jsp");
//	      Part part = request.getPart("mem_photo") ;
//	      
//	      String fileName = part.getSubmittedFileName();
//	      
//	      if(!"".equals(fileName)) {
//	      
//	      String saveFileName = UUID.randomUUID().toString()+ "_" + fileName;
//	      
//	      vo.setMem_photo(fileName);
//	      
//	      try {
//	           // part.write()메서드 ==> Upload된 파일을 저장하는 메서드
//	          part.write(uploadPath + File.separator + saveFileName ) ;      // 파일 저장하기...
//	      } catch (Exception e) {
//	         e.printStackTrace();
//	         
//	      }
//	      
//	      MyMemberService service = MyMemberServiceImpl.getInstance();
//	      
//	      int list = service.insertMember(vo);
//	      
//	      request.setAttribute("list", list);
//	      response.sendRedirect(request.getContextPath() + "/addMember.do");
//	   }
	   
	   }
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
