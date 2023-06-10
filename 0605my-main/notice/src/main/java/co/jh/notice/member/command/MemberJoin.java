package co.jh.notice.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jh.notice.common.Command;

public class MemberJoin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//회원가입 폼을 돌려줌
		return "member/memberInsert";
	}

}
