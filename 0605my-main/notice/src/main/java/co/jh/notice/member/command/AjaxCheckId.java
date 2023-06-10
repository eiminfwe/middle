package co.jh.notice.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jh.notice.common.Command;
import co.jh.notice.member.service.MemberService;
import co.jh.notice.member.service.MemberVO;
import co.jh.notice.member.serviceImpl.MemberServiceImpl;

public class AjaxCheckId implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//id중복체크(ajax리턴)
		MemberService ms=new MemberServiceImpl();
		MemberVO vo= new MemberVO();
		vo.setMemberId(request.getParameter("id"));
		vo=ms.memberSelect(vo);
		String str="Ajax:";
		if(vo!=null) {
			str+="No";
		}else {
			str+="Yes";
		}
		return str;
	}

}
