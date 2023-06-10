package co.jh.notice;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jh.notice.command.NoticeList;
import co.jh.notice.common.Command;
import co.jh.notice.main.command.MainCommand;
import co.jh.notice.member.command.AjaxCheckId;
import co.jh.notice.member.command.MemberInsert;
import co.jh.notice.member.command.MemberJoin;
import co.jh.notice.member.command.MemberList;
import co.jh.notice.member.command.MemberLogin;
import co.jh.notice.member.command.MemberLoginForm;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// 최초에 1번만 실행되는 메서드 요청한 것을(맵에) 담아둠
		map.put("/main.do", new MainCommand());// 처음 들어오는 페이지를 돌려준다
		map.put("/noticeList.do", new NoticeList());// (요청명, 수행할 객체(
		map.put("/memberList.do", new MemberList());//member목록보기
		map.put("/memberJoin.do", new MemberJoin());//회원가입 회면 호출
		map.put("/memberInser.do", new MemberInsert());
		map.put("/ajaxCheckId.do", new AjaxCheckId());
		map.put("/memberLoginForm.do", new MemberLoginForm());
		map.put("/memberLogin.do", new MemberLogin());
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request분석, 수행할 command 찾기, 결과return
		request.setCharacterEncoding("utf-8");// 한글깨짐방지
		String uri = request.getRequestURI();// request객체의 requestURI갖고오기
		String contextPath = request.getContextPath();// request객체의 contextpath(root를 의미함)
		String page = uri.substring(contextPath.length());// 실제요청

		Command command = map.get(page);
		String viewPage = command.exec(request, response);

		if (!viewPage.endsWith(".do")) {
			//이것이 viewresolve
			if(viewPage.startsWith("Ajax:")) {
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
//				getwriter==page에 출력하기
			}
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(viewPage); // 결과가*.do면위임
		}

	
	}

}
