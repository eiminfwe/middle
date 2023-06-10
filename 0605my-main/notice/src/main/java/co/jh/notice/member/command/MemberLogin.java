package co.jh.notice.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.jh.notice.common.Command;
import co.jh.notice.member.service.MemberService;
import co.jh.notice.member.service.MemberVO;
import co.jh.notice.member.serviceImpl.MemberServiceImpl;

public class MemberLogin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		MemberService ms= new MemberServiceImpl();
		MemberVO vo= new MemberVO();
		HttpSession session=request.getSession();
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPw(request.getParameter("memberPw"));
		
		vo=ms.memberLogin(vo);
		if(vo!=null) {
			session.setAttribute("id", vo.getMemberId());
			request.setAttribute("message",vo.getMemberName()+"welcome");
		}else {
			request.setAttribute("message", "로그인않됨");
		}
		return "member/memberMessage";
	}

}
