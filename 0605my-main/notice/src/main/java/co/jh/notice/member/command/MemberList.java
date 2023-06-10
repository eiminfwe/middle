package co.jh.notice.member.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jh.notice.common.Command;
import co.jh.notice.member.service.MemberService;
import co.jh.notice.member.service.MemberVO;
import co.jh.notice.member.serviceImpl.MemberServiceImpl;

public class MemberList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 멤버목록가져오기(memberList)
		MemberService ms= new MemberServiceImpl();
		List<MemberVO>members=new ArrayList<>();
		members= ms.memberSelectList();
		
		request.setAttribute("members", members);
		return "member/memberList";
	}

}
