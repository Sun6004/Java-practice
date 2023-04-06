package myMember.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myMember.service.MyMemberServiceImpl;
import myMember.vo.MyMemberVO;


@WebServlet("/memberDetail.do")
public class MemberDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String memId = request.getParameter("memId");
		System.out.println(memId);
		
		MyMemberVO vo = MyMemberServiceImpl.getInstance().getMember(memId);
		
		request.setAttribute("memVo", vo);
		
		request.getRequestDispatcher("/myMember/memdetail.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
