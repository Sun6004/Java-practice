package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sessionAdd.do")
public class SessionAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//Session정보 저장하는 방법
		
		//1. Session객체를 생성하거나 현재 Session정보 가져오기
		//형식1) request객체.getSession(); 또는 request객체.getSession(true);
		//		==> 현재 세션이 존재하면 현재 세션을 반환하고, 존재하지 않으면 새로운 세션을 생성한다.
		//형식2) request객체.getSession(false);
		//		==> 현재 세션이 존재하면 현재 세션을 반환하고, 존재하지않으면 null을 반환.
		HttpSession session = request.getSession();
		
		// 2.Session값 저장하기 ==> Session객체의 setAttribute()메서드 이용
		// 형식) session객체.setAttribute("key값", 저장할Session 데이터);
		// 		==>Key값 : 문자열, 저장할 Session 데이터: 모든 종류의 데이터
		session.setAttribute("testSession", "연습용 세션 데이터 입니다.");
		session.setAttribute("userName", "hong");
		session.setAttribute("age", 30);
		
		out.println("<html><head><meta charset='utf-8'><title>Session 저장 연습</title></head>");
		out.println("<body>");
		out.println("<h2>Session데이터가 저장되었습니다.</h2>");
		out.println("<a href='" + request.getContextPath()+"/basic/session/sessionTest.jsp'>시작문서로 이동하기</a>");
		out.println("</body> </html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
