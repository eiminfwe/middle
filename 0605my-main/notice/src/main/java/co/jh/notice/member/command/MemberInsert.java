package co.jh.notice.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jh.notice.common.Command;
import co.jh.notice.member.service.MemberService;
import co.jh.notice.member.service.MemberVO;
import co.jh.notice.member.serviceImpl.MemberServiceImpl;

public class MemberInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		MemberService ms=new MemberServiceImpl();
		MemberVO vo=new MemberVO();
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPw(request.getParameter("memberPw"));
		vo.setMemberName(request.getParameter("memberName"));
		vo.setMemberTel(request.getParameter("memberTel"));
		vo.setMemberAge(Integer.valueOf(request.getParameter("memberAge")));
		vo.setMemberGender(request.getParameter("memberGender"));
		
		int n=ms.memberInsert(vo);
		if(n>0) {
			request.setAttribute("message","회원가입이 정상적으로 처리되었습니다");
			System.out.println("success!");
		}else {
			request.setAttribute("message", "회원가입에 실패하였습니다 다시 시도해 주세요");
			System.out.println("fail");
		}
		//request안에는 전부 String형으로 넘어옴(따라서 String이외의 타입은 typecasting필요)
		
		//return "memberList.do";
		return "member/memberMessage";
	}

}
