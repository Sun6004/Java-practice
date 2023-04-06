package myMember.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myMember.service.MyMemberService;
import myMember.service.MyMemberServiceImpl;
import myMember.vo.MyMemberVO;


@WebServlet("/memList.jsp")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		MyMemberService service = MyMemberServiceImpl.getInstance();
		
		List<MyMemberVO> list = service.getMemberList();
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/myMember/memList.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
