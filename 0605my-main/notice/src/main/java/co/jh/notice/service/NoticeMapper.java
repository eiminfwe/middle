package co.jh.notice.service;

import java.util.List;

public interface NoticeMapper {
	// mybatis사용을 위한 interface
	List<NoticeVO> noticeSelectList();// 전체조회

	NoticeVO noticeSelect(NoticeVO vo);// 단건조회

	int noticeInsert(NoticeVO vo);

	int noticeUpdate(NoticeVO vo);

	int noticeDelete(NoticeVO vo);
}
