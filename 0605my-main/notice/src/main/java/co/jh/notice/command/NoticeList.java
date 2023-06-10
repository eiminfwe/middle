package co.jh.notice.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jh.notice.common.Command;
import co.jh.notice.service.NoticeService;
import co.jh.notice.service.NoticeVO;
import co.jh.notice.service.Impl.NoticeServiceImpl;

public class NoticeList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//게시글 목록가져오기
		NoticeService ns= new NoticeServiceImpl();//dao(모델)생성
		List<NoticeVO>notices=new ArrayList<>();//결과를 담을 그릇
		notices= ns.noticeSelectList();
		
		request.setAttribute("notices", notices);//jsp에 보내기 위해 결과객체를 담는다(변수명, 값)
		
		
		return "notice/noticeList";
	}

}
