package session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sessionRead.do")
public class sessionRead extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 저장된 Session 정보읽어오기
		
		// 1. Session객체를 생성하거나 현재 Session 가져오기
		HttpSession session = request.getSession();
		
		out.println("<html><head><meta charset='utf-8'><title>Session 세션 읽기 연습</title>");
		out.println("<style>");
		out.println("h2 { color: blue; }");
		out.println("h3 { color: green; }");
		out.println("</style>");
		
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>  저장된 Session데이터 확인하기</h2>");
		out.println("<h3> Session데이터 1개 확인하기</h3>");
		out.println("");	

		// 2. 저장된 Session데이터를 개별적으로 가져올 때는 getAttribute()메서드를 사용한다.
		// 형식) session객체.getAttribute("key값")
		String sessionValue = (String)session.getAttribute("testSession");
		if(sessionValue == null) {
			out.println("<h3>testSession의 세션값이 존재하지 않습니다.</h3>");			
		}else {
			out.println("<h3>testSession: " + sessionValue +"</h3>");			
		}
		out.println("<br><hr><br>");
		out.println("<h2> Session데이터 전체 확인하기</h2>");
		out.println("<ol>");
		
		//Session의 모든 키값들을 구해서 Enumeration객체형으로 반환한다.
		Enumeration<String> sessionNames = session.getAttributeNames();
		int cnt = 0;
		while (sessionNames.hasMoreElements()) { //다음 데이터가 있는지 여부 검사
			cnt++;
			String sessionKey = sessionNames.nextElement(); //다음 번째 값 구하기
			out.println("<li>" + sessionKey +":" +session.getAttribute(sessionKey)+"</li>");
		}
		
		if(cnt ==0) {
			out.println("<h3>세션 데이터가 하나도 없습니다. </h3>");
		}
		
		out.println("<a href='" + request.getContextPath()+"/basic/session/sessionTest.jsp'>시작문서로 이동하기</a>");
		out.println("</body> </html>");
		out.println("</ol>");
		out.println("<hr>");
		//세션id ==> 세션을 구분하기 위한 고유의 값
		out.println("세션 ID: " + session.getId());
		
		//생성시간 ==> 1970년 1월 1일부터 경과한 시간(밀리세컨드 단위)
		out.println("세션 생성시간: " + session.getCreationTime() + "<br>");
		//최근접근시간 ==> 1970년 1월 1일부터 경과한 시간(밀리세컨드 단위)
		out.println("세션 최근 접근 시간: " + session.getLastAccessedTime()+ "<br>");
		
		//세션 유효시간(초)
		//유효시간 설정==> session.setMaxInactiveInterval(시간);
		out.println("세션 유효시간: " + session.getMaxInactiveInterval()+ "<br>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
