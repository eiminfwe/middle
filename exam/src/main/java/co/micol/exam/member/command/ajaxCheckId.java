package co.micol.exam.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.exam.common.Command;
import co.micol.exam.member.service.MemberService;
import co.micol.exam.member.service.MemberVO;
import co.micol.exam.member.service.Impl.MemberServiceImpl;

public class ajaxCheckId implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		MemberService ms = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("id"));
		
		vo = ms.memberSelect(vo);
		
		String str="Ajax:";
		if(vo!=null) {
			str += "No";
		} else {
			str += "Yes";
		}
		
		return str;
	}

}
